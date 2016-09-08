<%@page import="com.work.utils.TimeUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,user-scalable=no" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css" />
<script
	src="${pageContext.request.contextPath }/resources/js/jquery.min.js"
	type="text/javascript" charset="utf-8"></script>
<script
	src="${pageContext.request.contextPath }/resources/js/bootstrap.js"
	type="text/javascript" charset="utf-8"></script>
<title></title>
<style type="text/css">
body {
	font-family: "微软雅黑";
	background-image:
		url(${pageContext.request.contextPath }/resources/img/23535G604-11.jpg);
}
</style>
</head>
	<body>
		<!-- 标题 -->
		<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
		
		<!-- 间隔div  -->
		<div style="height: 20px;"></div>
		
		<!-- 网页主体 -->
		<div class="container">
			<div class="panel panel-default">
				<!--显示用户的名字和现在的日期-->
				<div class="alert alert-info"><b>你好！</b>${sessionScope.user.userName}，现在时间是<%= TimeUtils.getNow(TimeUtils.YMD) %></div>
				<div class="panel-heading">记录下自己的工作日志</div>
				<div class="panel-body">
					<div class="alert alert-danger <c:if test="${msg == null }">hidden</c:if>">${msg }</div>
					<form action="${pageContext.request.contextPath }/user/userAction-saveLogging" method="post">
						<textarea class="form-control" rows="10" name="logging.loggingText"></textarea><br />
							
						<div align="right">
							<input class="btn btn-default" type="reset" id="" name="" value="重置" />
							<input class="btn btn-default" type="submit" id="" name="" value="提交" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>