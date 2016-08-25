<%@page import="com.work.utils.TimeUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
		<!-- 标题 -->
		<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
	
		<div style="height: 20px"></div>
	
		<div class="container">
			<div class="panel panel-default">
				<div class="panel-heading">查看所有的工作日志</div>
				<div class="panel-body">
					<!-- <div align="right">
						<form action="" method="post" class="form-inline">
							<div class="form-group">
								<input class="form-control" type="text" placeholder="选择日期">
							</div>
							<input type="submit" class="form-control" value="查看" />
						</form>
						<br />
					</div> -->
					<ol class="breadcrumb">
						<li><a href="#">日期：${requestScope.pageDate}</a></li>
					</ol>
					<ul class="list-group">
						<s:iterator value="#request.loggingList" var="logging">
							<li class="list-group-item">
								<span class="badge">${logging.user.userName}-${logging.time}</span>
								${logging.loggingText}
							</li>
						</s:iterator>
					</ul>
					<div align="center">
						<nav>
						<ul class="pagination">
							<li><a id="preDate" href="#" aria-label="Previous" >上一天</a></li>
							<li><a id="afterDate" href="#" aria-label="Next">下一天</a></li>
						</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			$(function(){
				var url = "${pageContext.request.contextPath }/user/userAction-viewLoggingByDate?date=";
				var pageDate = "${requestScope.pageDate}";
				$("#preDate").click(function(){
					$("#preDate").attr("href",url + cc(pageDate,-1));
				});
				$("#afterDate").click(function(){
					$("#afterDate").attr("href",url + cc(pageDate,1));
				});
				
				function cc(pageDate,next){
					var a = new Date(pageDate);
					a = a.valueOf();
					a = a + next * 24 * 60 * 60 * 1000;
					a = new Date(a);
					var year = a.getFullYear();
					var month = a.getMonth()+1;
					var date = a.getDate(); 
					if(month<10){
						month = "0" + month;
					}
					if(date<10){
						date = "0" + date;
					}
					return year+"-"+month+"-"+date;
				}
			})
		</script>
	</body>
</html>
