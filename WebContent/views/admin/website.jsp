<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>iParity管理网站</title>
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
	<!--  
	<div class="panel-body panel-top-border"><div class="hostel-name">list[i].name</div><div class="row"><div class="col-xs-1">list[i].address</div></div></div>
	-->
</body>

<script src="${pageContext.request.contextPath}/assets/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/myscript.js"></script>

<script>
	$(document).ready(function() {
		chooseActive("#website");
		getWebsite();
	});

	function getWebsite(){
		$.ajax({
            type: "GET",
            url: "http://localhost:8080/iParity/admin/getWebsite",
            
            success: function(data) {
                $("#myContent").empty();
                var list=data.list;
				if(list==null||list.length==0){
					var tip = '<div>暂时没有网站</div>'
					$("#myContent").append(tip);
				}else{
					for(var i=0;i<list.length;i++){
						var delUrl = "http://localhost:8080/iParity/admin/delWebsite?id="+list[i].id
						var modUrl = "http://localhost:8080/iParity/admin/modifySite?id="+list[i].id
						var panel = '<div class="panel "><div class="row"><div class="col-xs-2 headLabel">'+list[i].name+'</div>'+
						'<div class="col-xs-6 headLabel">'+list[i].url+'</div><div class="col-xs-2 headLabel"><a href="'+delUrl+'">删除</a></div>'+
						'<div class="col-xs-2 headLabel"><a href="'+modUrl+'">修改</a></div></div></div>';
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