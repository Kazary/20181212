package com.stutea.dao;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import com.stutea.bean.StuTea;
import com.stutea.mapper.StuTeaMapper;

public class StuTeaDao {

	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<StuTea> queryStudentTeacherAll() {
		String sql = "select student.name\r\n" +
				"	 , student.birthday\r\n" +
				"	 , student.age\r\n" +
				"	 , student.score\r\n" +
				"	 , student.classid\r\n" +
				"	 , teacher.id\r\n" +
				"	 , teacher.teachername\r\n" +
				"	 , teacher.course \r\n" +
				"	 from student \r\n" +
				"	 left join teacher \r\n" +
				"	 on student.id = teacher.id";
		return jdbcTemplate.query(sql, new StuTeaMapper());
	}

}
