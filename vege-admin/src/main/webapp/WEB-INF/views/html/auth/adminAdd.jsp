<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员新增</title>

</head>
<body class="no-skin">
	<div class="page-content">
		<!-- 页面内容全部放大这里 -->
		<div class="row">
			<div class="col-xs-12">
				<form id="addAdminForm" class="form-horizontal" method="post">
					<div class="form-group">
						<label class="col-md-1 control-label" style="width: 10%"
							for="form-field-1">账号<span class="required-star">*</span>：
						</label>
						<div class="col-md-9">
							<input type="text" name="adminName" class="col-xs-10 col-sm-5">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-1 control-label" style="width: 10%"
							for="form-field-1">姓名<span class="required-star">*</span>：</label>
						<div class="col-md-9">
							<input type="text" name="adminRealName" class="col-xs-10 col-sm-5">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-1 control-label" for="form-field-1" style="width: 10%">部门<span class="required-star">*</span>：</label>
						<div class="col-md-2" >
							<select class="input-sm form-control" name="adminDep">
							    <option value="">请选择</option>
								<c:forEach var="dep" items="${depList}"> 
								   <option value="${dep.id}">${dep.depName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-1 control-label" for="form-field-1" style="width: 10%">角色<span class="required-star">*</span>：</label>
						<div class="col-md-2" >
							<select class="input-sm form-control" name="role_id">
							    <option value="">请选择</option>
								<c:forEach var="role" items="${roleList}"> 
								   <option value="${role.id}">${role.roleName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group" style="margin-top: 20px;margin-left: 5%;">
						<div class="col-md-5">
							<button type="button" onclick="savaAdmin();" class="btn btn-sm btn-primary"
								style="width: 100px;">保存</button>
							<button type="button" onclick="getBack();"
								class="btn btn-sm btn-primary" style="width: 100px;">返回</button> 
						</div>
					</div>
					<input id="reset" type="reset" style="display: none;" />

				</form>
			</div>
		</div>
		<!-- 页面内容全部放大这里 结束 -->
		<script type="text/javascript" src="/static/admin/js/crm/auth/admin.js"></script>
	</div>

</body>

</html>
