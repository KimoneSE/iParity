<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>iParity广告管理</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ip.css">
	
	<style>
		.headLabel{
            font-family: 等线;
            font-size: 14px;
        }
	</style>
</head>
<body>
	<%@include file="../common/adminNavbar.jsp" %>
	
	<div class="col-xs-offset-2 col-xs-8" id="myContent" style="min-height: 40px"></div>
	
</body>

<script src="${pageContext.request.contextPath}/assets/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/myscript.js"></script>
<script>
	$(document).ready(function() {
		chooseActive("#advertisement");
		getAd();
	});

	function getAd(){
		$.ajax({
            type: "GET",
            url: "http://localhost:8080/iParity/admin/getAd",
            
            success: function(data) {
                $("#myContent").empty();
                var list=data.list;
				if(list==null||list.length==0){
					var tip = '<div>暂时没有广告</div>'
					$("#myContent").append(tip);
				}else{
					for(var i=0;i<list.length;i++){
						var delUrl = "http://localhost:8080/iParity/admin/delAd?id="+list[i].id
						var panel = '<div class="panel "><div class="row"><div class="col-xs-2 headLabel">'+list[i].content+'</div>'+
						'<div class="col-xs-6 headLabel">'+list[i].imgurl+'</div><div class="col-xs-6 headLabel">'+list[i].linkurl+
						'<div class="col-xs-2 headLabel"><a href="'+delUrl+'">删除</a></div>'+
						'<div class="col-xs-2 headLabel"><a href=modAdvertise.jsp>修改</a></div></div></div>';
						$("#myContent").append(panel);
					}
				}
               


            },
            error: function() {
                showTip("连接错误！");
            }
        });
	}
</script>
</html>