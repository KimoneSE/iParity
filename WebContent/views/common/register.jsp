<%@page import="com.sun.xml.internal.bind.CycleRecoverable.Context"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!--<link rel="icon" href="../../favicon.ico">-->

    <title>注册</title>

    <!-- Bootstrap core CSS -->
     <link href="<%=response.encodeURL(request.getContextPath()+"/assets/css/bootstrap.min.css") %>" rel="stylesheet">
</head>

<body>
<div style="width: 50%;margin-left: 25%;margin-top: 20%;">
	<form class="form-signin" role="form" style="width: 100%;" method="POST" 
	action="<%=response.encodeURL(request.getContextPath()+"/register") %>">
		
		<input name="nickname" type="text" value=""  
		style="display:inline-block;width:50%;margin-left: 20%;" class="form-control" placeholder="用户名" required autofocus>
		
		<input name="password" type="password" value="" 
		style="width:50%;margin-left: 20%;margin-top:1%;" class="form-control" placeholder="密码 " required>
	    <br>

		<input type="submit" class="btn btn-primary" value="注册"
				 style="margin-left: 28%;width:30%;margin-top:3%;"/>

	</form>
	</div>
</body>
</html>