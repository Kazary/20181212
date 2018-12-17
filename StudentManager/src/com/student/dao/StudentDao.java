package com.student.dao;

import java.sql.Types;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import com.student.bean.Student;
import com.student.mapper.StudentMapper;

public class StudentDao {


	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 查询所有学生
	 * @return 返回值类型： List<Student>
	 */
	public List<Student> queryAll() {
		String sql = "select id,name,birthday,age,score,classid from student";
		//将查询结果映射到Student类中，添加到list中，并返回
		return jdbcTemplate.query(sql, new StudentMapper());
	}

	/**
	 * 通过姓名查询
	 * @param name
	 * @return 返回值类型： List<Student>
	 */
	public List<Student> queryByName(String name) {
		String sql = "select id,name,birthday,age,score,classid from student where name like '%" + name + "%'";
		return jdbcTemplate.query(sql, new StudentMapper());
	}

	/**
	 * 添加学生
	 * @param student
	 * @return 返回值类型： boolean
	 */
	public boolean addStu(Student student) {
		String sql = "insert into student(id,name,birthday,age,score,classid) values(0,?,?,?,?)";
		return jdbcTemplate.update(sql,
				new Object[] { student.getName(), student.getBirthday(), student.getAge(),
						student.getScore(),student.getClassid() },
				new int[] { Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.DOUBLE, Types.VARCHAR }) == 1;
	}

	/**
	 * 删除学生
	 * @param id
	 * @return 返回值类型： boolean
	 */
	public boolean deleteStu(Integer id) {
		String sql = "delete from student where id = ?";
		return jdbcTemplate.update(sql, id) == 1;
	}

	/**
	 * 更新学生信息
	 * @param student
	 * @return 返回值类型： boolean
	 */
	public boolean updateStu(Student student) {
		String sql = "update student set name=? ,age=?,birthday = ? ,score = ?,classid = ?  where id = ?";
		Object stuObj[] = new Object[] {student.getId(), student.getName(), student.getBirthday(), student.getAge(), student.getScore(), student.getClassid() };
		return jdbcTemplate.update(sql, stuObj) == 1;
	}

	public List<Student> queryById(String id) {
		String sql = "select id,name,birthday,age,score,classid from student where id like '" + id + "'";
		return jdbcTemplate.query(sql, new StudentMapper());
	}

}
