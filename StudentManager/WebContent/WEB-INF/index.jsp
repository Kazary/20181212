<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="./css/student.css"/>
  <title>学员管理</title>
<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>

	<script type="text/javascript">
		$(document).ready(function(){
			  $("#display").click(function(){
				  $("#displayGood").submit();
				  }
		}
		});
		  });

	</script>
</head>

<body>
<img src="./images/header.jpg" />
${msg}
<h1 align="center">学员信息管理</h1>

<div id="all_comm" class="all"  >
  <h2 align="center">学员信息一览</h2>
  <table id="items" cellspacing="0px" cellspadding="0px" align="center" width="500px">
	<tr>
		<th>ID</td>
		<th width="80px">姓名</th>
		<th width="150px">出生年月</th>
		<th width="40px">年龄</th>
		<th width="80px">分数</th>
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
</div>

	<div id="add_comm" class="all" align="center">
	  <h2>查找学员</h2>
	  <form action="queryByName" method="post" >
		<input type="text" placeholder="姓名" name="name" >
		<input type="submit" value="查找学员" >
	  </form>
	  <form action="queryById" method="post" >
		<input type="text" placeholder="ID" name="id" >
		<input type="submit" value="查找学员" >
	  </form>

	  <h2 id="edit_title">添加学员</h2>
		<form  id="addForm" action="add" method="post" >
		<input id="addid" type="text" placeholder="ID" name="id" />
		<input id="addname" type="text" placeholder="姓名" name="name" />
		<input id="addbirthday" type="text" placeholder="出生年月" name="birthday" />
		<input id="addage" type="text" placeholder="年龄" name="age" />
		<input id="addscore" type="text" placeholder="分数" name="score" />
		<input id="addclassid" type="text" placeholder="ClassId" name="classid" />
		<input type="button" value="添加" onClick="addCheckForm()"/>
	  </form>
	</div>

	<div align="center">
		<h2>成績優秀者</h2>
		<form id="displayGood" action="displayGoodController" method="post">
			<button id="display" type="button">表示</button>
		</form>
	</div>

</body>
</html>