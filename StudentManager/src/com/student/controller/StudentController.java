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

	/**
	 * すべての学生の情報を表示する。
	 * @param model
	 * @return index.jsp
	 */
	@RequestMapping(value = "/all")
	public String queryAll(Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//从ioc容器中获取dao
		StudentDao dao = (StudentDao) context.getBean("dao");
		model.addAttribute("students", dao.queryAll());
		return "index";
	}

	/**
	 * ログイン画面で、アドレスを変えないままボタンを押して指定の内容を表示するAjax機能を実現する。
	 * 実現方法：ログイン画面の「read」ボタンを押す。
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/myajax", produces = "application/json;charset=UTF-8")
	public void getAjax(HttpServletRequest request, HttpServletResponse response) {
		JSONObject obj = new JSONObject();
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao studao = (StudentDao) context.getBean("dao");
		List<Student> studentList = new ArrayList<Student>();
		studentList = (ArrayList<Student>) studao.queryAll();
		JSONArray data = new JSONArray(); //List機能に相当する
		for (Student stu : studentList) {
			JSONObject jsonObject = new JSONObject(); //Map機能に相当する。
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

	/**
	 * 学生と先生の情報をIDを通じて一つのテーブルに表示する。
	 * 実現方法：アドレスの末尾を変更。
	 * @param model
	 * @return stutea
	 */
	@RequestMapping(value = "/stuteaall")
	public String queryStudentTeacherAll(Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StuTeaDao dao = (StuTeaDao) context.getBean("stuteadao");
		model.addAttribute("stuteas", dao.queryStudentTeacherAll());
		return "stutea";
	}

	/**
	 * 以下四つの方法を合わせて、成績平均値を超えた学生を取り出して表示する。
	 * その一：全員の情報を取り出して、「studentList」というリストに表示する。
	 * @return studentList
	 */
	private List<Student> getStudentList() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao studao = (StudentDao) context.getBean("dao");
		List<Student> studentList = new ArrayList<Student>();
		studentList = studao.queryAll();
		return studentList;
	}

	/**
	 * その二：全員の成績の平均値を求める。（コメントの内容は、まだ習っていない別の先生の書き方）
	 * @param stuList
	 * @return averageScore
	 */
//	private BigDecimal getAverScore(List<Student> studentList) {
//		BigDecimal average = BigDecimal.ZERO;
//		for (Student student : studentList) {
//			average.add(new BigDecimal(student.getScore()));
//		}
//		//System.out.println(average.divide(new BigDecimal(studentList.size())));
//		return average.divide(new BigDecimal(studentList.size()));
	private double getAverageScore(List<Student> stuList) {
		double sum = 0;
		for(Student stu:stuList) {
			sum += stu.getScore();
		}
		double averageScore = sum / stuList.size();
		System.out.print(averageScore);
		return averageScore;
	}

	/**
	 * その三：成績が平均値より高い学生の情報を取り出して、「returnGoodScoreList」というリストに表示する。
	 * （コメントの内容は、まだ習っていない別の先生の書き方）
	 * @param stuList
	 * @param avrage
	 * @return returnGoodScoreList
	 */
//	private List<Student> getReturnList(List<Student> studentList, BigDecimal average) {
//		List<Student> returnList = new ArrayList<>();
//		for (Student student : studentList) {
//			if (new BigDecimal(student.getScore()).compareTo(average) >0) {
//				returnList.add(student);
//			}
//		}
//		return returnList;
//	}
	private List<Student> getGoodScoreReturnList(List<Student> stuList,double averageScore) {
		List<Student> returnGoodScoreList = new ArrayList<>();
		for (Student stu:stuList) {
			if (averageScore < stu.getScore()) {
				returnGoodScoreList.add(stu);
			}
		}
		return returnGoodScoreList;
	}

	/**
	 * その四：上記のリスト「returnList」をモデルの形で、フロントの「index.jsp」ファイルに返す。
	 * （コメントの内容は、まだ習っていない別の先生の書き方）
	 * @param model
	 * @return
	 */
//	@RequestMapping(value = "/displayGoodScore")
//	public String displayGoodScore(Model model) {
//		List<Student> studentList = getStudentList();
//		BigDecimal average = getAverageScore(studentList);
//		List<Student> returnList = getReturnList(studentList, average);
//		model.addAttribute("students", returnList);
//		return "index";
//	}
	@RequestMapping(value = "/goodScore")
	public String displayGoodScore(Model model) {
		List<Student> studentList = getStudentList();
		double averageScore = getAverageScore(studentList);
		List<Student> returnGoodScoreList = getGoodScoreReturnList(studentList, averageScore);
		model.addAttribute("students", returnGoodScoreList);
		return "index";
	}

	/**
	 * 以下四つの方法を合わせて、成績が最大値に該当する学生を取り出して表示する。
	 * その一（上と被るゆえ省略）：全員の情報を取り出して、「studentList」というリストに表示する。
	 * その二：全員の成績の最大値を求める。
	 * @param stuList
	 * @return double
	 */
	private double getMaxScore(List<Student> stuList) {
		double maxScore = 0;
		for(Student stu:stuList) {
			if(maxScore < stu.getScore()) {
				maxScore = stu.getScore();
			}
		}
		System.out.print(maxScore);
		return maxScore;
	}

	/**
	 * その三：成績が最大値と等しい学生の情報を、「returnMaxScoreList」というリストに表示する。
	 * @param stuList
	 * @param avrage
	 * @return returnMaxScoreList
	 */
	private List<Student> getMaxScoreReturnList(List<Student> stuList,double maxScore) {
		List<Student> returnMaxScoreList = new ArrayList<>();
		for (Student stu:stuList) {
			if (maxScore == stu.getScore()) {
				returnMaxScoreList.add(stu);
			}
		}
		return returnMaxScoreList;
	}

	/**
	 * その四：上記のリスト「returnMaxScoreList」をモデルの形で、フロントの「index.jsp」ファイルに返す。
	 * @param model
	 * @return index.jsp
	 */
	@RequestMapping(value = "/maxScore")
	public String displayMaxScore(Model model) {
		List<Student> studentList = getStudentList();
		double maxScore = getMaxScore(studentList);
		List<Student> returnMaxScoreList = getMaxScoreReturnList(studentList, maxScore);
		model.addAttribute("students", returnMaxScoreList);
		return "index";
	}

}
