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

    <title>爱比价网登录</title>

    <!-- Bootstrap core CSS -->
     <link href="<%=response.encodeURL(request.getContextPath()+"/assets/css/bootstrap.min.css") %>" rel="stylesheet">
</head>
<body>

	<div style="font-family: 微软雅黑;">
	<div class="container" style="font-family: 微软雅黑;width:50%;margin-left:25%;margin-top:15%;">
	<form method="POST" action="<%=response.encodeURL(request.getContextPath()+"/login") %>">
	
		<input type='text' name='username' value=""
		class="form-control" placeholder="用户名" style="display:inline-block;width:40%;margin-left:30%;font-size:18;" required>
		
		<input type='password' name='password' value=''
		class="form-control" placeholder="密码" style="display:inline-block;width:40%;margin-left:30%;margin-top:3%;" required>
		<div style="color:red;font-size:18px;">${error}</div>
		
		<div style="display: block;width: 70%;margin-left: 15%;margin-top:5%;">
            <input type="submit" class="btn btn-primary" value="登录"
                   style="display: inline-block;width:30%;font-size:16px;margin-left: 15%;"/>
            <a href="<%=response.encodeURL(request.getContextPath()+"/register") %>" style="display: inline-block;width:30%;font-size:16px;margin-left: 8%;"
               class="btn btn-info">注册
            </a>
        </div>
	</form>
	</div>
    </div>
</body>
</html>