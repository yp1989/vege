<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>修改密码</title>
</head>
<body>
	<div class="page-content">
		<!-- 页面内容全部放大这里 -->
		
		<div class="row">
			<div class="col-md-7">
				<div class="widget-box">
					<div class="widget-header">
						<h4 class="widget-title">账户姓名：${sessionScope.admin.adminName}</h4>
					</div>
	
					<div class="widget-body">
						<div class="widget-main no-padding">
							<form role="form" method="post" id="updatePasswordForm">
							    <input type="hidden" name="id" value="${sessionScope.admin.id}">
								<fieldset>
									<label>旧密码：</label>
									<input type="password" placeholder="" id="oldPassword" onblur="checkPassword();">
									<span id="checkPasswordSpan" class="middle" style="color: red"></span>	
								</fieldset>
								<fieldset>
									<label>新密码：</label>
									<input type="password" disabled="disabled" placeholder="" name="adminPassword" id="newPassword">	
									<span class="middle">密码必须为6位或6位以上</span>
								</fieldset>
								<fieldset>
									<label>确认密码：</label>
									<input disabled="disabled" type="password" placeholder="" id="surePassword">
									<span id="surePasswordSpan" class="middle" style="color: red;display: none;">密码不一致</span>	
								</fieldset>
								<div class="form-actions center">
									<button type="button" class="btn btn-sm btn-primary" data-fn="submit" onclick="sava();">保存</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>				
		<!-- 页面内容全部放大这里 结束 -->
	</div>
	<script type="text/javascript" src="/static/admin/js/crm/auth/password.js"></script>
</body>
</html>