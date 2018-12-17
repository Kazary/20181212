package com.student.controller;



import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.student.bean.Student;
import com.student.dao.StudentDao;
import com.stutea.dao.StuTeaDao;
import com.teacher.bean.Teacher;
import com.teacher.dao.TeacherDao;

@Controller
public class StudentController {

	@RequestMapping(value = "/all")
	public String queryAll(Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//从ioc容器中获取dao
		StudentDao dao = (StudentDao) context.getBean("dao");
		model.addAttribute("students", dao.queryAll());
		return "index";
	}


	@RequestMapping(value = "/teacherall")
	public String queryTeacherAll(Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TeacherDao dao = (TeacherDao) context.getBean("teacherdao");
		model.addAttribute("teachers", dao.queryTeacherAll());
		return "teacher";
	}


	@RequestMapping(value = "/queryByName")
	public String queryByName(String teachername, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//从ioc容器中获取dao
		TeacherDao dao = (TeacherDao) context.getBean("teacherdao");
		model.addAttribute("teachers", dao.queryByName(teachername));
		return "teacher";
	}

	@RequestMapping(value = "/queryById")
	public String queryById(String id, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TeacherDao dao = (TeacherDao) context.getBean("teacherdao");
		model.addAttribute("teachers", dao.queryById(id));
		return "teacher";
	}

	@RequestMapping(value = "/add")
	public String Addstudent(String name, String birthday, String age, String score, String classid, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao dao = (StudentDao) context.getBean("dao");
		Student student = new Student();
		student.setName(name);
		student.setBirthday(birthday);
		student.setAge(Integer.valueOf(age));
		student.setScore(Double.parseDouble(score));
		student.setClassid(Integer.valueOf(classid));
		boolean result = dao.addStu(student);
		if (result) {
			model.addAttribute("msg", "<script>alert('添加成功！')</script>");
		} else {
			model.addAttribute("msg", "<script>alert('添加失敗！')</script>");
		}
		model.addAttribute("students", dao.queryAll());
		return "index";
	}

	@RequestMapping(value = "/addteacher")
	public String Addteacher(String teachername, String course, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TeacherDao dao = (TeacherDao) context.getBean("teacherdao");
		Teacher teacher = new Teacher();
		teacher.setTeachername(teachername);
		teacher.setCourse(course);
		boolean result = dao.addTea(teacher);
		if (result) {
			model.addAttribute("msg", "<script>alert('添加成功！')</script>");
		} else {
			model.addAttribute("msg", "<script>alert('添加失敗！')</script>");
		}
		model.addAttribute("teachers", dao.queryTeacherAll());
		return "teacher";
	}

	@RequestMapping(value = "/updateteacher")
	public String updateTeacher(String id, String teachername, String course, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TeacherDao dao = (TeacherDao) context.getBean("teacherdao");
		Teacher teacher = new Teacher();
		teacher.setId(Integer.parseInt(id));
		teacher.setTeachername(teachername);
		teacher.setCourse(course);
		boolean result = dao.updateTeacher(teacher);
		if (result) {
			System.out.println("update成功");
		} else {
			System.out.println("update失敗");
		}
		model.addAttribute("teachers", dao.queryTeacherAll());
		return "teacher";
	}

	@RequestMapping(value = "/deleteTeacherById")
	public String deleteById(String id, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TeacherDao dao = (TeacherDao) context.getBean("teacherdao");
		boolean result = dao.deleteTea(Integer.parseInt(id));
		if (result) {
			System.out.println("消除成功");
		} else {
			System.out.println("消除失敗");
		}
		model.addAttribute("teachers", dao.queryTeacherAll());
		return "teacher";
	}

	@RequestMapping(value = "/myajax", produces = "application/json;charset=UTF-8")
	public void getAjax(HttpServletRequest request, HttpServletResponse response) {
		JSONObject obj = new JSONObject();
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao studao = (StudentDao) context.getBean("dao");
		List<Student> studentList = new ArrayList<Student>();
		studentList = (ArrayList<Student>) studao.queryAll();
		JSONArray data = new JSONArray(); //  List
		for (Student stu : studentList) {
			JSONObject jsonObject = new JSONObject(); // Map
			jsonObject.put("id", stu.getId());
			jsonObject.put("name", stu.getName());
			jsonObject.put("birthday", stu.getBirthday());
			jsonObject.put("age", stu.getAge());
			jsonObject.put("score", stu.getScore());
			jsonObject.put("classid", stu.getClassid());
			data.add(jsonObject);
		}
		obj.put("result", true);
		obj.put("data", data);
		try {
			response.setContentType("application/json");
			response.getWriter().write(obj.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/stuteaall")
	public String queryStudentTeacherAll(Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StuTeaDao dao = (StuTeaDao) context.getBean("stuteadao");
		model.addAttribute("stuteas", dao.queryStudentTeacherAll());
		return "stutea";
	}

	@RequestMapping(value = "/displayGood")
	public String displayGoodScore(Model model) {
		List<Student> studentList = getStudentList();
		BigDecimal average = getAverAge(studentList);
		List<Student> returnList = getReturnList(studentList, average);
		model.addAttribute("students", returnList);
		return "index";
	}

	private List<Student> getStudentList() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao studao = (StudentDao) context.getBean("dao");
		List<Student> studentList = new ArrayList<Student>();
		studentList = studao.queryAll();
		return studentList;
	}

	private BigDecimal getAverAge(List<Student> studentList) {
		BigDecimal average = BigDecimal.ZERO;
		for (Student student : studentList) {
			average.add(new BigDecimal(student.getScore()));
		}
		return average.divide(new BigDecimal(studentList.size()));
	}

	private List<Student> getReturnList(List<Student> studentList, BigDecimal average) {
		List<Student> returnList = new ArrayList<>();
		for (Student student : studentList) {
			if (new BigDecimal(student.getScore()).compareTo(average) > 0) {
				returnList.add(student);
			}
		}
		return returnList;
	}

}
