package com.teacher.dao;

import java.sql.Types;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import com.teacher.bean.Teacher;
import com.teacher.mapper.TeacherMapper;

public class TeacherDao {

	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Teacher> queryTeacherAll() {
		String sql = "select id,teachername,course from teacher";
		return jdbcTemplate.query(sql, new TeacherMapper());
	}

	public List<Teacher> queryByName(String teachername) {
		String sql = "select id,teachername,course from teacher where teachername like '%" + teachername + "%'";
		return jdbcTemplate.query(sql, new TeacherMapper());
	}

	public List<Teacher> queryById(String id) {
		String sql = "select id,teachername,course from teacher where id like " + id + " ";
		return jdbcTemplate.query(sql, new TeacherMapper());
	}

	public boolean addTea(Teacher teacher) {
		String sql = "insert into teacher(id,teachername,course) values(0,?,?)";
		return jdbcTemplate.update(sql,
				new Object[] { teacher.getTeachername(), teacher.getCourse() },
				new int[] { Types.VARCHAR, Types.VARCHAR }) == 1;
	}

	public boolean updateTeacher(Teacher teacher) {
		String sql = "update teacher set teachername=?,course=?  where id =?";
		Object teaObj[] = new Object[] { teacher.getTeachername(), teacher.getCourse(), teacher.getId() };
		return jdbcTemplate.update(sql, teaObj) == 1;
	}

	public boolean deleteTea(Integer id) {
		String sql = "delete from teacher where id = ?";
		return jdbcTemplate.update(sql, id) == 1;
	}

}
