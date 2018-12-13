package com.stutea.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.jdbc.core.RowMapper;
import com.stutea.bean.StuTea;


public class StuTeaMapper implements RowMapper<StuTea> {

	public StuTea mapRow(ResultSet rs, int rowNum) throws SQLException {
		StuTea stutea = new StuTea();
		stutea.setName(rs.getString("name"));
		stutea.setBirthday(dateToString(rs.getDate("birthday")));
		stutea.setAge(rs.getInt("age"));
		stutea.setScore(rs.getDouble("score"));
		stutea.setClassid(rs.getInt("classid"));
		stutea.setId(rs.getInt("id"));
		stutea.setTeachername(rs.getString("teachername"));
		stutea.setCourse(rs.getString("course"));

		return stutea;
	}

	private String dateToString(Date date) {

		String dateStr = null;
		if (date != null) {
			dateStr = new SimpleDateFormat("yyyy/MM/dd").format(date);
		} else {
			dateStr = "";
		}
		return dateStr;
	}

}