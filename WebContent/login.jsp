<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width,user-scalable=no" />
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery.min.js"></script>
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
</head>
<body>
	<div style="margin: 150px;"></div>
	<div class="container" align="center">
		<div style="width: 300px;">
			<h1 style="color: #FFFFFF; padding-bottom: 10px;">工作日志系统登录</h1>
			<div id="error" class="alert alert-danger <c:if test="${error == null }">hidden</c:if>">${error}</div>
			<form action="${pageContext.request.contextPath }/visitor-login" method="post">
				<input type="text" name="username" class="form-control" value="" placeholder="用户名" />
				<input type="password" name="password" class="form-control" placeholder="密码" />
				<div class="row">
					<div class="col-md-6">
						<input type="submit" class="form-control" value="登录" />
					</div>
					<div class="col-md-6">
						<input type="button" onclick="window.location.href='${pageContext.request.contextPath }/visitor-toRegisterPage'" class="form-control"
							value="注册" />
					</div>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		/* 			$(function(){
		 $("#error").removeClass("hidden");
		 $("#error").html("error");
		 })
		 */
	</script>
</body>
</html>