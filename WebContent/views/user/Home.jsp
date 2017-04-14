<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*" %>
     <%@page import="com.ip.model.Ad" %>
      <%@page import="com.ip.model.Product" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

    <!--[if lt IE 9]>
    <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
    <![endif]-->
    <meta charset = "UTF-8">
    <meta name="viewport" content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no,minimal-ui;" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link rel="stylesheet" type="text/css" href="<%=response.encodeURL(request.getContextPath()+"/assets/css/bootstrap.min.css") %>">
    <link rel="stylesheet" type="text/css" href="<%=response.encodeURL(request.getContextPath()+"/assets/css/custom.css") %>">
    <script src = "<%=response.encodeURL(request.getContextPath()+"/assets/js/bootstrap.min.js") %>"></script>
    <title>爱比价网</title>
</head>
<body>
<%@include file="../common/userNavbar.jsp" %>
<div>
    <div style="margin-top: 8%;margin-left:15%;width:52%;display:inline-block;">
        <form class="form-inline" method="post" action=""
              style="width:97%;margin-left: 3%;">
            <div class="input-group" style="width:100%;">
                <input type="text" class="form-control" name="pname" placeholder="商品名称"
                       style="font-size: 20px;height: 42px;">
                <span class="input-group-btn" style="width:20%;">
                <input type="submit" class="btn btn-info" style="height: 42px;width:100%;"/>
            </span>
            </div>
        </form>
        
        <div style="margin-top: 3%;margin-left:5%;font-size:16px;">
            <span>价格
                <a class="glyphicon glyphicon-arrow-up sorticon"
                href="<%=request.getContextPath()+"/Home?sortRule='price:asc'"%>"></a>
                <a class="glyphicon glyphicon-arrow-down sorticon"
                href="<%=request.getContextPath()+"/Home?sortRule='price:desc'"%>"></a>
            </span>
            <span style="margin-left: 3%;">销量
                <a class="glyphicon glyphicon-arrow-up sorticon"
                href="<%=request.getContextPath()+"/Home?sortRule='volume:asc'"%>"></a>
                <a class="glyphicon glyphicon-arrow-down sorticon"
                href="<%=request.getContextPath()+"/Home?sortRule='volume:desc'"%>"></a>
            </span>
            <span>可靠度
                <a class="glyphicon glyphicon-arrow-up sorticon"
                href="<%=request.getContextPath()+"/Home?sortRule='reliability:asc'"%>"></a>
                <a class="glyphicon glyphicon-arrow-down sorticon"
                href="<%=request.getContextPath()+"/Home?sortRule='reliability:desc'"%>"></a>
            </span>
        </div>

        <div style="margin-top: 4%;width:100%;">
        
        <%
        List prolist = (List)request.getAttribute("products");
        for(int i = 0;i<prolist.size();i++){
        	Product p = (Product)prolist.get(i);
        	out.println("<a class=\"productDiv\" style=\"display: inline-block;margin-left: 3%;\" href=\""
        	+request.getContextPath()+"product/detail?name="+p.getProduct()+"\">"
        	+"<div style=\"width:150px;\">"
        	+" <img src="+"''" +"height=\"150\" width=\"150\"/>"
        	+"<div style=\"font-size: 18px;margin-top: 2%;\">"+p.getProduct()+"</div>"
        	+"<div style=\"font-size: 15px;color: darkgrey\">"+"参考价："
        	+"<span style=\"color:red;font-size: 20px;\">"+p.getPrice()+"</span></div>"
        	+"<div><span style=\"font-size: 14px;color: darkgrey;\">"+"总销量："+p.getVolumn()+"</span>"
        	+"<span style=\"font-size: 14px;color: darkgrey;margin-left: 10%;\">"+p.getValue()+"</span>"
        	+" </div> </div> </a>");
        }
        %>

        </div>
    </div>

    <div style="margin-left:13%;width:17%;display:inline-block;vertical-align:top;margin-top:5%;">
     <%
     List adList = (List)request.getAttribute("ads");
     
        for(int i = 0;i<adList.size();i++){
        	Ad ad = (Ad)adList.get(i);
        	
        	out.println("<a href='"+ad.getLinkurl()+"' style=\"color:black;\">"
        			+"<div class=\"productDiv\" style=\"margin-top: 3%;\">"
        	+"<div style=\"width:150px;\">"
        	+" <img src='"+ad.getImgurl() +"' height=\"150\" width=\"150\"/>"
        	+"<div style=\"font-size: 18px;margin-top: 2%;\">"+ad.getContent()+"</div>"
        	+" </div></div></a>");
        }
        
        %>
    </div>
</div>
</body>
</html>