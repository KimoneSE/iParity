<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>iParity网站修改</title>
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
				<div >修改网站信息</div>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-xs-offset-1 col-xs-10">
                    	<form class="form-horizontal modify_form"  >
                    		<div class="form-group ">
                    			<label class="col-xs-3">网站名</label>
								<div class="col-xs-9">
                                    <input type="text" class="form-control" id="name" name="name" value="${website.name}" >
                                </div>                    		
                            </div>
                    		<div class="form-group">
                    			<label class="col-xs-3">网站地址</label>
                    			<div class="col-xs-9">
                                    <input type="text" class="form-control" id="url" name="url" value="${website.url }" >
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
		chooseActive("#website");
	});
    
	function save(){
	
		$.ajax({
			type:"POST",
			url:"http://localhost:8080/iParity/admin/modWebsite",
			data:$.param({'idS':"${website.id}"})+'&'+$('.modify_form').serialize(),
			
			success:function(data){
				if(data["success"]==false){
					showTip(data["tip"]);
				}else if(data["success"]==true){
					showTip("修改成功");
					setTimeout(function(){
						window.location.href = "http://localhost:8080/iParity/admin/website";
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