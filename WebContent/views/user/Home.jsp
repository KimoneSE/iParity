<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<div>
    <form class="form-inline" method="post" action=""
          style="margin-top: 8%;margin-left:18%;margin-right: 15%;width:60%;">
        <div class="input-group" style="width:100%;">
            <input type="text" class="form-control" name="pname" placeholder="商品名称"
                   style="font-size: 20px;height: 42px;">
            <span class="input-group-btn" style="width:20%;">
                <input type="submit" class="btn btn-info" style="height: 42px;width:100%;"/>
            </span>
        </div>
    </form>

    <div style="margin-top: 4%;margin-left:18%;margin-right: 15%;width:60%;">
       <div class="productDiv">
            <div style="width:150px;">
                <img src="../../assets/img/1.jpeg" height="150" width="150"/>
                <div style="font-size: 18px;margin-top: 2%;">oppo</div>
                <div style="font-size: 15px;color: darkgrey">参考价：
                    <span style="color:red;font-size: 20px;">¥1299</span></div>
            </div>
        </div>
        
    </div>
</div>
</body>
</html>