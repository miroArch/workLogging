<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width,user-scalable=no" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css" />
<title></title>
<style type="text/css">
body {
	font-family: "微软雅黑";
	background-image: url(${pageContext.request.contextPath }/resources/img/23535G604-11.jpg);
}

.form-control {
	margin-bottom: 10px;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery.min.js"></script>
</head>
<body>
	<div style="height: 150px;"></div>
	<div class="container" align="center">
		<div style="width: 300px;">
			<h1 style="color: #FFFFFF; padding-bottom: 20px;">工作日志系统注册</h1>
			<div id="error" class="alert alert-danger hidden">最多500字！</div>
			<form action="${pageContext.request.contextPath }/visitor-register" method="post">
				<input type="text" class="form-control" name="username" placeholder="用户名" /> <input id="password"
					type="password" class="form-control" name="password" placeholder="密码" /> <input id="confirm-password"
					type="password" class="form-control" name="confirmPassword" placeholder="确认密码" />
				<div class="row">
					<div class="col-md-6">
						<input type="button" onclick="window.location.href='${pageContext.request.contextPath }/visitor-toLoginPage'" class="form-control"
							value="返回" />
					</div>
					<div class="col-md-6">
						<input type="submit" class="form-control" id="" name="" value="注册" />
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$("#confirm-password").blur(function() {
			var password = $("#password").val();
			var confirmPassword = $("#confirm-password").val();
			if (password != confirmPassword) {
				$("#error").removeClass("hidden");
				$("#error").html("两次输入密码不一致！");
			}
		})
	})
</script>
</html>
