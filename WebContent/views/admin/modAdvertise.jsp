<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>iParity广告修改</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ip.css">
	
	<style>
		.myPanel{margin-top: 20%;}
	</style>
</head>
<body>
	<%@include file="../common/adminNavbar.jsp" %>
	<div class="col-sm-offset-4 col-sm-4">
		<div class="panel panel-warning myPanel">
			<div class="panel-heading text-center">
				<div >修改广告信息</div>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-xs-offset-1 col-xs-10">
                    	<form class="form-horizontal modify_form"  >
                    		<div class="form-group ">
                    			<label class="col-xs-3">广告内容</label>
								<div class="col-xs-9">
                                    <input type="text" class="form-control" id="name" name="name" value="${ad.content}" >
                                </div>                    		
                            </div>
                    		<div class="form-group">
                    			<label class="col-xs-3">图片链接</label>
                    			<div class="col-xs-9">
                                    <input type="text" class="form-control" id="imgurl" name="imgurl" value="${ad.imgurl}" >
                                </div>
                    		</div>
                    		<div class="form-group">
                    			<label class="col-xs-3">广告链接</label>
                    			<div class="col-xs-9">
                                    <input type="text" class="form-control" id="linkurl" name="linkurl" value="${ad.linkurl}" >
                                </div>
                    		</div>
                    		<div class="form-group ">
                    			<label class="col-xs-3"></label>
                    			<div class="col-xs-9">
									<button type="button" class="btn btn-info pull-right" onclick="save()">保存</button>
								</div>
							</div>
                    	</form>
                    </div>
                    <div class="col-xs-offset-2 col-xs-8 text-center">                    	
                    	<%@include file="/views/common/tip.jsp"%>
                    </div>
                </div>
			</div>
		</div>
	</div>
</body>

<script src="${pageContext.request.contextPath}/assets/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/myscript.js"></script>

<script>
	$(document).ready(function() {
		chooseActive("#advertisement");
	});
    
	function save(){
		$.ajax({
			type:"POST",
			url:"http://localhost:8080/iParity/admin/modAd",
			data:$.param({'idS':"${ad.id}",'imgurl':"${ad.imgurl}",'linkurl':"${ad.linkurl}",'content':"${ad.content}"})+'&'+$('.modify_form').serialize(),
			
			success:function(data){
				if(data["success"]==false){
					showTip(data["tip"]);
				}else if(data["success"]==true){
					showTip("修改成功");
					setTimeout(function(){
						window.location.href = "http://localhost:8080/iParity/admin/ad";
					},3000);
					
				}
			},
			error: function() {
				showTip("连接错误，请稍后再试");
			}	
		})
	}
</script>

</html>