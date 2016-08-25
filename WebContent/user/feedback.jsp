<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,user-scalable=no" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css" />
		<script src="${pageContext.request.contextPath }/resources/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath }/resources/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
		<title></title>
		<style type="text/css">
			body {
				font-family: "微软雅黑";
				background-image: url(${pageContext.request.contextPath }/resources/img/23535G604-11.jpg);
			}
		</style>
	</head>

	<body>
		<header class="navbar navbar-static-top bs-docs-nav" id="top" role="banner" >
			<div class="container">
				<div class="navbar-header">
					<button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target="#bs-navbar" aria-controls="bs-navbar" aria-expanded="false">
				      <span class="sr-only">Toggle navigation</span>
				      <span class="icon-bar"></span>
				      <span class="icon-bar"></span>
				      <span class="icon-bar"></span>
				    </button>
					<a href="../" style="color: #FFFFFF" class="navbar-brand">WorkLogging</a>
				</div>
				<nav id="bs-navbar" class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
						<li><a style="color: #FFFFFF" href="${pageContext.request.contextPath }/user/userAction-toAddLoggingPage">日志记录</a></li>
						<li><a style="color: #FFFFFF" href="${pageContext.request.contextPath }/user/userAction-viewLoggingByDate">查看</a></li>
						<li><a style="color: #FFFFFF" href="${pageContext.request.contextPath }/user/feedback.jsp">反馈</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a style="color: #FFFFFF" href="${pageContext.request.contextPath }/visitor-logout">张三：退出</a></li>
					</ul>
				</nav>
			</div>
		</header>
		
		<div style="height: 20px;"></div>
		<div class="container">
			<div class="panel panel-default">
				<!--显示用户的名字和现在的日期-->
				<div class="panel-heading">有什么问题，通过下面反馈给朕！</div>
				<div class="panel-body">
					<form action="addLogging.html" method="post">
						<textarea class="form-control" rows="10"></textarea><br />
						<div class="alert alert-danger hidden">最多500字！</div>
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