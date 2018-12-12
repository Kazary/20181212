//package com.stutea.dao;
//
//import java.util.List;
//import org.springframework.jdbc.core.JdbcTemplate;
//import com.stutea.bean.StuTea;
//import com.stutea.mapper.StuTeaMapper;
//
//public class StuTeaDao {
//
//	private JdbcTemplate jdbcTemplate;
//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}
//
//	public List<StuTea> queryStudentTeacherAll() {
//		String sql = "select student.name, student.birthday, student.age, student.classid, teacher.id as comid, teacher.course from student left join teacher on student.id = teacher.id";
//		return jdbcTemplate.query(sql, new StuTeaMapper());
//	}
//
//}
