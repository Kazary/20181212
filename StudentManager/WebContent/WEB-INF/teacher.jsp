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

<script type="text/javascript">

$(document).ready(function(){
	  $("#queryByNameButton").click(function(){
		  var input_teachername=$("#queryname").val();
		  if (input_teachername == "" || input_teachername == null) {
				alert("名前を入力してください！");
				return false;
			}else{
				var username = /^[\u3040-\u309F\u30A0-\u30FF\u4e00-\u9fa5A-Za-z]+$/;
				if(!username.test($("#queryname").val())){
						alert("名前は日本語か英語に限ります！");
						return false;
				    }else{
					$("#queryByNameForm").submit();
					}
				}
	});
  });

$(document).ready(function(){
	  $("#queryByIdButton").click(function(){
		  var input_teacherid=$("#queryid").val();
		  if (input_teacherid == "" || input_teacherid == null) {
				alert("IDを入力してください！");
				return false;
			}else{
				var userid = /^[0-9]+$/;
				if(!userid.test($("#queryid").val())){
						alert("IDは数字に限ります！");
						return false;
				    }else{
					$("#queryByIdForm").submit();
					}
				}
	});
});

$(document).ready(function(){
	  $("#addButton").click(function(){
		  var input_teachername=$("#addname").val();
		  var input_teachercourse=$("#addcourse").val();
		  if (input_teachername == "" || input_teachername == null) {
				alert("名前を入力してください！");
				return false;
			}else{
				if (input_teachercourse == "" || input_teachercourse == null){
					alert("コースを入力してください！");
					return false;
				}
				   var username = /^[\u3040-\u309F\u30A0-\u30FF\u4e00-\u9fa5A-Za-z]+$/;
				    if(!username.test($("#teachername").val())){
						alert("名前は日本語か英語に限ります！");
						return false;
				    }else{
							alert("追加成功！");
							$("#addForm").submit();
				}
			}
	  });
	});

$(document).ready(function(){
	  $("#updateButton").click(function(){
		  var input_teacherid=$("#updateid").val();
		  var input_teachername=$("#updatename").val();
		  var input_teachercourse=$("#updatecourse").val();
		  if (input_teacherid == "" || input_teacherid == null) {
				alert("修正したい先生のIDを入力してください！");
				return false;
			}else{
				if (input_teachername == "" || input_teachername == null){
					alert("修正したい名前を記入してください！");
					return false;
				}else{
					if (input_teachercourse == "" || input_teachercourse == null){
						alert("修正したいコースを記入してください！");
						return false
					}else{
						var userid = /^[0-9]+$/;
						if(!userid.test($("#updateid").val())){
							alert("IDは数字に限ります！");
							return false;
						}
					}
					    var username = /^[\u3040-\u309F\u30A0-\u30FF\u4e00-\u9fa5A-Za-z]+$/;
					    if(!username.test($("#updatename").val())){
							alert("名前は日本語か英語に限ります！");
							return false;
					    }else{
								alert("修正成功！");
								$("#updateForm").submit();
				}
			}
	  }
	});
});

$(document).ready(function(){
	  $("#deleteButton").click(function(){
		  var input_teacherid=$("#deleteid").val();
		  if (input_teacherid == "" || input_teacherid == null) {
				alert("IDを入力してください！");
				return false;
			}else{
				var userid = /^[0-9]+$/;
				if(!userid.test($("#deleteid").val())){
						alert("IDは数字に限ります！");
						return false;
				    }else{
					$("#deleteForm").submit();
					}
				}
	});
});

</script>
</head>


<div id="all_comm" class="all" align="center" >
  <h1>先生情報管理</h1>
  <h2>情報一覧</h2>

  <table id="items" border="3">
	<tr style="color:red" align="center">
		<td>ID</td>
		<td>Name</td>
		<td>Course</td>
	</tr>
    <c:forEach items="${teachers}" var="teacher" >
	    <tr style="color:blue" align="center" >
			<td id="id${teacher.id }">${teacher.id}</td>
			<td id="name${teacher.id }">${teacher.teachername}</td>
			<td id="course${teacher.id }">${teacher.course}</td>
		 </tr>
	 </c:forEach>
  </table>
</div><br><br>

	<div id="add_comm" class="all" align="center" >
	  <h3>先生を検索</h3>
	  <form id="queryByNameForm" action="queryByName" method="post" >
		<input id="queryname" type="text" placeholder="名前" name="teachername" >
		<button id="queryByNameButton" type="button">名前で検索</button>
	  </form><br>
	  <form id="queryByIdForm" action="queryById" method="post" >
		<input id="queryid" type="text" placeholder="ID" name="id" >
		<button id="queryByIdButton" type="button">IDで検索</button>
	  </form><br><br>

	  <h3 id="edit_title">先生を追加</h3>
		<form  id="addForm" action="addteacher" method="post" >
		<input id="addname" type="text" placeholder="名前" name="teachername" />
		<input id="addcourse" type="text" placeholder="コース" name="course" />
		<button id="addButton" type="button">追加</button>
	  </form><br><br>

	  	<h3 id="edit_title">情報を修正</h3>
		<form  id="updateForm" action="updateteacher" method="post" >
		<input id="updateid" type="text" placeholder="ID" name="id" />
		<input id="updatename" type="text" placeholder="名前" name="teachername" />
		<input id="updatecourse" type="text" placeholder="コース" name="course" />
		<button id="updateButton" type="button">修正</button>
	  </form><br><br>

	  	<h3 id="edit_title">情報を削除</h3>
		<form  id="deleteForm" action="deleteTeacherById" method="post" >
		<input id="deleteid" type="text" placeholder="ID" name="id" />
		<button id="deleteButton" type="button">IDを削除</button>
	  </form>
	</div>

</body>
</html>