<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>iParity商品详情</title>
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
	<%@include file="../common/userNavbar.jsp" %>
	
	<div class="col-xs-offset-2 col-xs-8" id="myContent" style="min-height: 40px">
			<ul class="nav nav-tabs" id="selectTab" style="font-family: 等线">
            	<li id="list" class="active"><a href="#plist" data-toggle="tab">商家列表</a></li>
                <li id="com"><a href="#comment" data-toggle="tab">评论</a></li>
            </ul>
            <div id="myTabContent" class="tab-content">
				<div class="tab-pane fade in active" id="plist">
					<div class="panel">
						<div class="row">
							<div class="col-xs-3">
								<!-- 
								<img style="width:100px;height: 100px" src="http://ec4.images-amazon.com:80/images/I/31L29DF5-4L.SL500_AA300_.jpg"/>
								 -->
							</div>
							<!-- <div class="col-xs-8"> -->
								<div class="col-xs-3">商品名</div>
								<div class="col-xs-2"><button class="btn" onclick="priceSort()">价格</button></div>
								<div class="col-xs-2"><button class="btn" onclick="reSort()">商家信用</button></div>
								
							<!-- </div> -->
						</div>
					</div>
				</div>
				<div class="tab-pane fade" id="comment">
					
					
				</div>
			</div>
		</div>
			
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
		getWebsite();
	});

	function priceSort(){
		
		$.ajax({
            type: "GET",
            url: "http://localhost:8080/iParity/product/priceSort",
            
            success: function(data) {
                $("#plist").empty();
                var list=data.list;
				if(list==null||list.length==0){
					var tip = '<div>没有其他商家信息</div>'
					$("#plist").append(tip);
				}else{
					for(var i=0;i<list.length;i++){
						//var delUrl = "http://localhost:8080/iParity/admin/delWebsite?id="+list[i].id
						//var modUrl = "http://localhost:8080/iParity/admin/modifySite?id="+list[i].id
						var panel = '<div class="panel"><div class="row"><div class="col-xs-3">'+
							'<img style="width:100px;height: 100px" src="'+list[i].imageLink+'"/></div>'+
							'<div class="col-xs-3">'+list[i].product+'</div><div class="col-xs-2">'+list[i].price+'</div><div class="col-xs-2">'+list[i].value+'</div>'+
							'<div class="col-xs-2"><a href="'+list[i].storeLink+'">详情</a></div></div></div>';
						$("#plist").append(panel);
					}
				}
               


            },
            error: function() {
                showTip("连接错误！");
            }
        });
	}


	function reSort(){
		
		$.ajax({
            type: "GET",
            url: "http://localhost:8080/iParity/product/reSort",
            
            success: function(data) {
                $("#plist").empty();
                var list=data.list;
				if(list==null||list.length==0){
					var tip = '<div>没有其他商家信息</div>'
					$("#plist").append(tip);
				}else{
					for(var i=0;i<list.length;i++){
						//var delUrl = "http://localhost:8080/iParity/admin/delWebsite?id="+list[i].id
						//var modUrl = "http://localhost:8080/iParity/admin/modifySite?id="+list[i].id
						var panel = '<div class="panel"><div class="row"><div class="col-xs-3">'+
							'<img style="width:100px;height: 100px" src="'+list[i].imageLink+'"/></div>'+
							'<div class="col-xs-3">'+list[i].product+'</div><div class="col-xs-2">'+list[i].price+'</div><div class="col-xs-2">'+list[i].value+'</div>'+
							'<div class="col-xs-2"><a href="'+list[i].storeLink+'">详情</a></div></div></div>';
						$("#plist").append(panel);
					}
				}
               


            },
            error: function() {
                showTip("连接错误！");
            }
        });
	}
	
	function getWebsite(){
		
		$.ajax({
            type: "GET",
            url: "http://localhost:8080/iParity/product/goodsDetail",
            
            success: function(data) {
                $("#plist").empty();
                var list=data.list;
				if(list==null||list.length==0){
					var tip = '<div>没有其他商家信息</div>'
					$("#plist").append(tip);
				}else{
					for(var i=0;i<list.length;i++){
						//var delUrl = "http://localhost:8080/iParity/admin/delWebsite?id="+list[i].id
						//var modUrl = "http://localhost:8080/iParity/admin/modifySite?id="+list[i].id
						var panel = '<div class="panel"><div class="row"><div class="col-xs-3">'+
							'<img style="width:100px;height: 100px" src="'+list[i].imageLink+'"/></div>'+
							'<div class="col-xs-3">'+list[i].product+'</div><div class="col-xs-2">'+list[i].price+'</div><div class="col-xs-2">'+list[i].value+'</div>'+
							'<div class="col-xs-2"><a href="'+list[i].storeLink+'">详情</a></div></div></div>';
						$("#plist").append(panel);
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