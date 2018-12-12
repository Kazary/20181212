<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
src="C:\Users\USER\Desktop\新しいフォルダー\StudentManager\WebContent\WEB-INF\images\header.jpg"></a>
<h1>Hello World!</h1>
<h6>Hello World!!!!!!</h6>
<table  border="1" rules="all">
<tr>
<th></th>
<th>月</th>
<th>火</th>
<th>水</th>
<th>木</th>
<th>金</th>
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
</table>
<input type="text" id="inputid">
<a id="ajaxbtn" href="javascript:void(0);">Hello</a>
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
					var html = "<div>"
					for(var i=0;i<data.length;i++){
						html+="<span>id："+data[i].id+"</span><br>"
						html+="<span>名字："+data[i].name+"</span><br>"
						html+="<span>出生："+data[i].birthday+"</span><br>"
						html+="<span>年齡："+data[i].age+"</span><br>"
						html+="<span>分数："+data[i].score+"</span><br>"
						html+="<span>班级："+data[i].classid+"</span><br>"
					}
					html+='</div>'
					$("body").append(html);
					//$("#inputid").hide();
					//$("#inputpsd").hide();
					//$("#but").hide();
					//$("body").css('background-color','green');
				});
			});
		});
	</script>

</body>

</html>