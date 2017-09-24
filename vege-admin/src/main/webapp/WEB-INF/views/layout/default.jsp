<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title><sitemesh:write property='title' /></title>
		<meta name="description" content="overview &amp; stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<!-- css样式表异步加载 在/layout/stylesheets.html内 -->
		<%@include file="/WEB-INF/views/layout/stylesheets.jsp" %>
		<%@include file="/WEB-INF/views/layout/scripts.jsp" %>
	</head>

	<body class="no-skin">
	<input type="hidden" value="${sessionScope.sumCode}" id="sumCode">
		<!-- 异步加载头部导航条 -->
		<div id="navbar" class="navbar navbar-default">
			<%@include file="/WEB-INF/views/layout/navbar.jsp" %>
		</div>
		<!-- 异步加载头部导航条 结束 -->
		<div class="main-container" id="main-container">
			<!-- 异步加载左侧边栏 -->
			<div id="sidebar" class="sidebar responsive">
				<%@include file="/WEB-INF/views/layout/sidebar.jsp" %>
			</div>
			<!-- 异步加载左侧边栏 结束-->
			<div class="main-content">
				<!-- 异步加载面包屑 -->
				<div class="breadcrumbs" id="breadcrumbs">
					<%@include file="/WEB-INF/views/layout/breadcrumbs.jsp" %>
				</div>
				<!-- 异步加载面包屑 结束-->

				<!-- 页面内容全部放大这里 -->
				<sitemesh:write property='body' />
				<!-- 页面内容全部放大这里 结束 -->
			</div>
			<!-- 异步加载footer -->
			<div class="footer">
				<div class="footer-inner">
						<div class="footer-content">
							<span class="bigger-120">
							  <span class="blue bolder">微客来</span>
							  销售管理系统 <span style="font-family:Arial;">&copy;</span> 205-2016
							</span>
						</div>
					</div>
			</div>
			<!-- 异步加载footer 结束-->
			<!-- 返回顶部按钮 -->
			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
			<!-- 返回顶部按钮 结束-->
		</div>

	</body>
</html>
