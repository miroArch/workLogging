<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header class="navbar navbar-static-top bs-docs-nav" id="top" role="banner">
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
				<li><a style="color: #FFFFFF" href="${pageContext.request.contextPath }/user/userAction-">习惯记录</a></li>
				<li><a style="color: #FFFFFF" href="${pageContext.request.contextPath }/user/userAction-toAddLoggingPage">日志记录</a></li>
				<li><a style="color: #FFFFFF" href="${pageContext.request.contextPath }/user/userAction-viewLoggingByDate">查看</a></li>
				<li><a style="color: #FFFFFF" href="${pageContext.request.contextPath }/user/feedback.jsp">反馈</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a style="color: #FFFFFF" href="${pageContext.request.contextPath }/login.jsp">${sessionScope.user.userName}</a></li>
				<li><a style="color: #FFFFFF" href="${pageContext.request.contextPath }/visitor-logout">退出登录</a></li>
			</ul>
		</nav>
	</div>
</header>