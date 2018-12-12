<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
<!-- jQuery -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
<!-- DataTables -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>

</head>


<div id="all_comm" class="all" align="center" >
  <h1>結合情報フォーム</h1>
  <h2>情報一覧</h2>

  <table id="items" border="3">
	<tr style="color:red" align="center">
		<td>StudentName</td>
		<td>Birthday</td>
		<td>Age</td>
		<td>Score</td>
		<td>ClassID</td>
		<td>CommonID</td>
		<td>TeacherName</td>
		<td>Course</td>

	</tr>
    <c:forEach items="${stuTeaAll}" var="queryStudentTeacherAll" >
	    <tr style="color:blue" align="center" >
			<td id="StudentName${student.id }">${student.name}</td>
			<td id="Birthday${student.id }">${student.id}</td>
			<td id="Age${student.id }">${student.age}</td>
			<td id="Score${student.id }">${student.id}</td>
			<td id="ClassID${student.id }">${student.id}</td>
			<td id="CommonID${student.id }">${teacher.id}</td>
			<td id="TeacherName${teacher.id }">${teacher.teachername}</td>
			<td id="Course${teacher.id }">${teacher.course}</td>
		 </tr>
	 </c:forEach>
  </table>
</div><br><br>

</body>
</html>