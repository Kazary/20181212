//package com.stutea.mapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import org.springframework.jdbc.core.RowMapper;
//import com.stutea.bean.StuTea;
//
//
//public class StuTeaMapper implements RowMapper<StuTea> {
//
//	public StuTea mapRow(ResultSet rs, int rowNum) throws SQLException {
//		StuTea student = new Student();
//		StuTea teacher = new Teacher();
//S
//		teacher.setId(rs.getInt(1));
//		teacher.setTeachername(rs.getString(2));
//		teacher.setCourse(rs.getString(3));
//		return StuTea;
//	}
//
//	private String getStringDate(String birthday) {
//
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		Date dateString = new Date();
//		String strRtnDate = "";
//		try {
//			dateString = formatter.parse(birthday);
//			strRtnDate = new SimpleDateFormat("yyyy-MM-dd").format(dateString);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		return strRtnDate;
//	}
//
//}