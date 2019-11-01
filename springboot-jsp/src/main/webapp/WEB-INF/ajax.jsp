<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>您好Springboot</title>
<!-- 引入jquary函数内库 -->
<script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
<!-- 编写jquary -->
<script type="text/javascript">
	//js解释执行语言  让页面加载完成之后执行
	$(function() {
		//$.get(),$.post(),$.getJSON(),$.load(),$.ajax()
		/*1.get请求
		参数说明:
			URL:异步请求的地址
			data:页面传递给后台服务器的数据,一般以key-value格式传递
			callback:回调函数,请求执行成功之后执行的动作
			type:服务器返回数据类型text/json/html/xml/script/default
			*/
			alert("ajax开始");
			
			$.get("/ajaxFindUser",{id:100},function(result){
				var tr=null;
					$(result).each(function(index,user){
						var id=user.id;
						var name=user.name;
						var age=user.age;
						var sex=user.sex;
					tr += "<tr align='center'><td>"+id+"</td><td>"+name+"</td><td>"+age+"</td><td>"+sex+"</td></tr>"
						});
						$("#tb1").append(tr);
				
				},"json");
			$.ajax({
				type:"get",
				url:"/ajaxFindUser",
				data:"id=1&name=tomcat",
				success:function(result){
					alert("调用成功");
					}
				});
			
	});
</script>
</head>
<body>
	<table id="tb1" border="1px" width="65%" align="center" cellspacing="0">
		<tr>
			<td colspan="6" align="center"><h3>学生信息</h3></td>
		</tr>
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>性别</th>
			<th></th>
		</tr>

	</table>
</body>
</html>