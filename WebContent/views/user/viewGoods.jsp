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
					
					
				</div>
				<div class="tab-pane fade" id="comment">
					<div class="col-md-12 ">
                        <div class="panel panel-default">
                            <div class="panel-body">
                            <h3 align="left">发布评论</h3>
                                <form action="http://localhost:8080/iParity/addcomment" method="post">
                                <div>
                                    <textarea name="content" id="conBox" class="comments" rows="6" ></textarea>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-offset-8 col-sm-4">
                                        <button type="submit" class="btn btn-default button1">发布</button>
                                    </div>
                                </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-12 ">
                        <div class="panel panel-default">
                            <div class="panel-body" id="allcomment">
                            <h3 align="left">评论</h3>


                            </div>
                        </div>
                    </div>
					
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
		getComment();
	});

	function priceSort(){
		
		$.ajax({
            type: "GET",
            url: "http://localhost:8080/iParity/product/priceSort?name="+'${product.product}',
            
            success: function(data) {
                $("#plist").empty();
                var listPanel = '<div class="panel"><div class="row"><div class="col-xs-3">'+
                '</div><div class="col-xs-3">商品名</div><div class="col-xs-2"><button class="btn" onclick="priceSort()">价格</button></div>'+
                '<div class="col-xs-2"><button class="btn" onclick="reSort()">商家信用</button></div></div></div>'
                $("#plist").append(listPanel);
                var list=data.list;
				if(list==null||list.length==0){
					var tip = '<div>未找到相关信息</div>'
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
            url: "http://localhost:8080/iParity/product/reSort?name="+'${product.product}',
            
            success: function(data) {
                $("#plist").empty();
                var listPanel = '<div class="panel"><div class="row"><div class="col-xs-3">'+
                '</div><div class="col-xs-3">商品名</div><div class="col-xs-2"><button class="btn" onclick="priceSort()">价格</button></div>'+
                '<div class="col-xs-2"><button class="btn" onclick="reSort()">商家信用</button></div></div></div>'
                $("#plist").append(listPanel);
                var list=data.list;
				if(list==null||list.length==0){
					var tip = '<div>未找到相关信息</div>'
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
            url: "http://localhost:8080/iParity/product/goodsDetail?name="+'${product.product}',
            
            success: function(data) {
                $("#plist").empty();
                var listPanel = '<div class="panel"><div class="row"><div class="col-xs-3">'+
                '</div><div class="col-xs-3">商品名</div><div class="col-xs-2"><button class="btn" onclick="priceSort()">价格</button></div>'+
                '<div class="col-xs-2"><button class="btn" onclick="reSort()">商家信用</button></div></div></div>'
                $("#plist").append(listPanel);
                var list=data.list;
				if(list==null||list.length==0){
					var tip = '<div>未找到相关信息</div>'
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
	
	function getComment(){
		$.ajax({
			type:"GET",
			url:"http://localhost:8080/iParity/comment",
			
			success:function(data){
				
				$("#allcomment").empty();
				var list = data.comments;
				if(list==null||list.length==0){
					var tip = '<div>目前没有评论</div>'
					$("#comment").append(tip);
				}else{
					for(var i=0;i<list.length;i++){
						
						var panel = '<div class="panel"><div class="row"><div class="col-xs-3">'+
							'<h4>'+list[i].uid+'</h4><p>'+list[i].datetime+'</p></div>'+
							'<div class="col-xs-8">'+list[i].content+'</div></div></div>';
						$("#allcomment").append(panel);
					}
				}
			}
		});
	}
</script>
</html>