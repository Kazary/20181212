<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/student.css"/>
	<!-- jQuery -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
<!-- DataTables -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
	<title>学员管理</title>
	<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>

	<script type="text/javascript">
	$(function(){
		  $("#goodScorebtn").click(function(){
				$("#displayGoodScore").submit();
			});

		  $("#maxScorebtn").click(function(){
				$("#displayMaxScore").submit();
			});
	});
	</script>
</head>

<body>

	<div align="center">
	<img src="./images/header.jpg" alt="first develope" title="first develope"/>
	</div>

	<h1 align="center">学生情報管理システム</h1>

	<div id="all_comm" class="all"  >
	  <h2 align="center">情報一覧</h2>
	  <table id="items" cellspacing="0px" cellspadding="0px" align="center" width="500px">
		<tr>
			<th>ID</td>
			<th width="80px">Name</th>
			<th width="150px">Birthday</th>
			<th width="40px">Age</th>
			<th width="80px">Score</th>
			<th width="20px">ClassId</th>
		</tr>

	    <c:forEach items="${students}" var="student" >
		    <tr style="color:blue">
				<td id="id${student.id }">${student.id}</td>
				<td id="name${student.id }">${student.name}</td>
				<td id="birthday${student.id}">${student.birthday}</td>
				<td id="age${student.id }">${student.age}</td>
				<td id="score${student.id}">${student.score}</td>
				<td id="classid${student.id}">${student.classid}</td>
			 </tr>
		 </c:forEach>
	  </table>
	</div><br><br>

	<div align="center">
		<form id="displayGoodScore" action="goodScore" method="post">
			<button id="goodScorebtn" type="button">成績優秀者を表示</button>
		</form><br>
		<form id="displayMaxScore" action="maxScore" method="post">
			<button id="maxScorebtn" type="button">成績最大値を表示</button>
		</form>
	</div><br><br>

	<div id="add_comm" class="all" align="center">
	<h2>学生を検索</h2>
	<form action="queryByName" method="post" >
		<input type="text" placeholder="名前" name="name" >
		<input type="submit" value="名前で検索" ><br><br>
	</form>
	  <form action="queryById" method="post" >
		<input type="text" placeholder="ID" name="id" >
		<input type="submit" value="IDで検索" >
	  </form><br><br>

	  <h2>学生を追加</h2>
	  	<form  id="addForm" action="add" method="post" >
		<input id="addid" type="text" placeholder="ID" name="id" />
		<input id="addname" type="text" placeholder="名前" name="name" />
		<input id="addbirthday" type="text" placeholder="生年月日" name="birthday" />
		<input id="addage" type="text" placeholder="年齢" name="age" />
		<input id="addscore" type="text" placeholder="成績" name="score" />
		<input id="addclassid" type="text" placeholder="ClassId" name="classid" />
		<input type="button" value="追加" onClick="addCheckForm()"/>
	  </form>
	</div><br><br>

</body>
</html>