
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@page import="com.ip.model.User" %>

<nav class="navbar navbar-default navbar-fixed-top" style="height:35px;">
    <div class="navbar-header" style="">
        <a class="navbar-brand" href="#">爱比价网</a>
    </div>
<%
	String op = "";
	String link = "";
	if(session.getAttribute("user")==null){
		op="登录";
		link=request.getContextPath()+"/login";
	}else{
		User u = (User)session.getAttribute("user");
		op=u.getName()+"退出";
		link=request.getContextPath()+"/logout";
	}%>
    <ul class="nav navbar-nav navbar-right" style="display: inline-block;width:20%;height: 100%;">
        <li style="font-size: 17px;text-align: center;float: right;margin-right: 10%;">
        <a href="<%=link%>"><%=op %></a></li>
    </ul>
</nav>
