<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/student.css"/>

<!-- jQuery -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
<!-- DataTables -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
<script src="../js/jquery-1.11.3.js"></script>

<link rel="stylesheet" type="text/css" href="./css/test.css"/>
<title>welcome</title>
</head>

<body>
<a href="http://www.firstdevelop.com/"><img alt="first develope" title="first develope"
src="C:\GitHub\StudentManeger\StudentManager\WebContent\WEB-INF\images\header.jpg"></a>

<h1>Hello World!</h1>
<h2>Hello World!!</h2>
<h3>Hello World!!!</h3>
<h4>Hello World!!!!</h4>
<h5>Hello World!!!!!</h5>
<h6>Hello World!!!!!!</h6>

<p>Span Test:The word is <span style="color:red">red</span>.</p>

<textarea rows="3";cols="10"; height="500px"; width="500px";>TextArea Test:123456789ABCDEFG</textarea>

<div style="width:500px; height:70px; overflow-y:auto; position:relative; top:10px; left:100px;">
	<table  border="1" rules="all">

		<tr style="align:center">
			<th class="headBackground" width="80"></th>
			<th class="headBackground" width="50">月</th>
			<th class="headBackground" width="50">火</th>
			<th class="headBackground" width="50">水</th>
			<th class="headBackground" width="50">木</th>
			<th class="headBackground" width="50">金</th>
		</tr>

		<tr>
			<td>一限目</td>
			<td>1</td>
			<td>2</td>
			<td>3</td>
			<td>4</td>
			<td>5</td>
		</tr>

		<tr>
			<td>二限目</td>
			<td>1</td>
			<td>2</td>
			<td rowspan="2" colspan="2" align="center">3</td>
			<td>5</td>
		</tr>

		<tr>
			<td>三限目</td>
			<td>1</td>
			<td>2</td>
			<td>5</td>
		</tr>

		<tr>
			<td>四限目</td>
			<td>1</td>
			<td>2</td>
			<td>3</td>
			<td>4</td>
			<td>5</td>
		</tr>

		<tr>
			<td  colspan="6" style="border-top:1px solid red" align="center">休み</td>
		</tr>

		<tr>
			<td>五限目</td>
			<td>1</td>
			<td>2</td>
			<td>3</td>
			<td rowspan="2">4</td>
			<td>5</td>
		</tr>

		<tr>
			<td>六限目</td>
			<td>1</td>
			<td>2</td>
			<td>3</td>
			<td>5</td>
			</tr>
	</table><br>

	<div style="position:absolute; top:25px; left:50px; color:blue;">Absolute position.</div>
	<div style="position:fixed; top:25px; left:50px; color:red">Another absolute position.</div>
</div>

<br><br>

<form align="center">
	<h3 style="color:red">Ajax Effect</h3>
	<h4>Student Table</h4>
	<button type="button" id="ajaxbtn" href="javascript:void(0);" value="Student">Read</button>
	<button type="button" id="hide" value="Hide" class="hideform">Hide</button>
	<button type="button" id="show" value="Show" class="showform">Show</button>
</form><br>
<script type="text/javascript">
		$(function() {
			$('#ajaxbtn').click(function(){
				var ajaxUrl = 'myajax';
				var username = $("#inputid").val();
				var param = {id:username};

				$.getJSON(ajaxUrl,param,function(result){
					//if(!result.result){
						//alert('接口失敗');
						//return false;
					//}else{
						//alert("接口成功");
					//};

					var data = result.data;
					var html = "<table id='studenttable' border='3' align='center'><tr><th>ID</th> <th>Name</th> <th>Birthday</th> <th>Age</th> <th>Score</th> <th>ClassID</th></tr>"
					for(var i=0;i<data.length;i++){
						html+="<tr align='center'><td>"+data[i].id+"</td>"
						html+="<td>"+data[i].name+"</td>"
						html+="<td>"+data[i].birthday+"</td>"
						html+="<td>"+data[i].age+"</td>"
						html+="<td>"+data[i].score+"</td>"
						html+="<td>"+data[i].classid+"</td>"
					}
					html+='</tr></table>'
					$("body").append(html);
					//$("#inputid").hide();
					//$("#inputpsd").hide();
					//$("#but").hide();
					//$("body").css('background-color','green');
				});
			});
		});

		//ボタンhideに隠す効果を、ボタンshowに表示する効果を付ける。
		$(document).ready(function(){
			  $(".hideform").click(function(){
			  $("#studenttable").hide();
			  });
			  $(".showform").click(function(){
			  $("#studenttable").show();
			  });
			});
	</script>

</body>

</html>