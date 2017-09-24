<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员管理</title>

</head>
<body class="no-skin">
   			<div class="page-content">
					<!-- 页面内容全部放大这里 -->
					<div class="row">
					   <div class="col-md-12"> 
					    <form id="findForm" class="form-horizontal"  method="post" action="${pageContext.request.contextPath}/auth/adminPage">
						    <input type="hidden" id="pageNo" name="pageNo" value="${page.pageNo}"/>
						    <div class="col-md-3 pb10 no-padding-left">
								<div class="input-group">
									<span class="input-group-addon">
										姓名
									</span>
									<input type="text" value="${admin.adminRealName}" name="adminRealName" class="input-sm form-control">
								</div>
							</div>
							<div class="col-md-3 pb10 no-padding-left">
								<div class="input-group">
									<span class="input-group-addon">
										角色
									</span>
									<select class="input-sm form-control" name="role_id">
										<option value="">全部</option>
										<c:forEach var="role" items="${roleList}"> 
										   <option 
										   <c:if test="${admin.role_id==role.id}">selected="selected"</c:if>
										   value="${role.id}">${role.roleName}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="col-md-3 pb10 no-padding-left">
								<div class="input-group">
									<span class="input-group-addon">
										状态
									</span>
									<select class="input-sm form-control" name="adminStatus">
										<option value="">请选择</option>
										<option <c:if test="${admin.adminStatus==1}">selected="selected"</c:if> value="1">正常</option>
										<option <c:if test="${admin.adminStatus==2}">selected="selected"</c:if> value="2">冻结</option>
									</select>
								</div>
							</div>
						    <button type="button" class="btn btn-sm btn-primary btn_normal" onclick="queryAdmin();" id="queryAdminBtn" data-fn="submit">查询</button>
							</form> 
						</div>
						<div class="col-md-12" style="margin-bottom: 5px;">
							<a href="${pageContext.request.contextPath}/auth/addAdminPage" class="btn btn-primary btn-sm btn-filter">添加管理员</a>
						</div>
						
					<!-- </div>
					<div class="row"> -->
						<div class="col-xs-12">
							<table id="sample-table-1" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center">
											<label class="position-relative">
												<input type="checkbox" class="ace">
												<span class="lbl"></span>
											</label>
										</th>
										<th>序号</th>
										<th>姓名</th>
										<th>账号</th>
										<th>角色</th>
										<th>状态</th>
										<th>操作</th>
									</tr>
								</thead>

								<tbody>
								    <c:forEach var="admin"  items="${page.results}" varStatus="index">
										<tr class="selected">
											<td class="center">
												<label class="position-relative">
													<input type="checkbox" class="ace">
													<span class="lbl"></span>
												</label>
											</td>
											<td>${index.index+1}</td>
											<td>${admin.adminRealName}</td>
											<td>${admin.adminName}</td>
											<td>
											    <c:forEach var="role" items="${admin.roleList}">
											        ${role.roleName}&nbsp;
											    </c:forEach>
											</td>
											<td>
                                                <c:if test="${admin.adminStatus == 1}">
												   正常
												</c:if>
												<c:if test="${admin.adminStatus == 2}">
												   冻结
												</c:if>
                                            </td>
											<td>
												<!-- <a href="callCenter_look.html" class="mr20">查看</a> -->
												<a  data-toggle="modal" data-target="#editAdmin" onclick="editAdmin('${admin.id}');" class="mr20">编辑</a>
												<c:if test="${admin.adminStatus == 1}">
												   <a href="/auth/closeAdmin?id=${admin.id}&adminStatus=2" class="mr20">冻结</a>
												</c:if>
												<c:if test="${admin.adminStatus == 2}">
												   <a href="/auth/closeAdmin?id=${admin.id}&adminStatus=1" class="mr20">解冻</a>
												</c:if>
											</td>
										</tr>
                                    </c:forEach>
									
								</tbody>
							</table>
							<%@include file="/WEB-INF/views/common/pagination.jsp" %>
						</div>
					</div>					
					<!-- 页面内容全部放大这里 结束 -->
				
				</div>
					<!--编辑管理员弹窗-->
				<div class="modal fade" id="editAdmin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				   <div class="modal-dialog">
					    <div class="modal-content">
					      	<div class="modal-header">
							    <button type="button" class="close" data-dismiss="modal" 
							       aria-hidden="true">×
							    </button>
							    <h4 class="modal-title" id="myModalLabel">
							        编辑管理员
							    </h4>
							</div>
							<div class="modal-body">
							    <form id="editAdminForm" class="form-horizontal" role="form" method="post">
							        <input type="hidden" id="adminId" name="id">
							        <div class="form-group">
							            <label class="col-md-3 control-label" style="width: 25%;" for="form-field-1">管理员姓名<span class="required-star">*</span>：</label>
							            <div class="col-md-9">
							                <input type="text" name="adminRealName" id="editAdminRealName" class="input-sm form-control">
							            </div>
							        </div>
							        <div class="form-group">
										<label class="col-md-1 control-label" style="width: 25%;" for="form-field-1" >角色<span class="required-star">*</span>：</label>
										<div class="col-md-2" style="width: 200px;">
											<select class="input-sm form-control" name="role_id" id="edit_role_id" >
											    <option value="">请选择</option>
												<c:forEach var="role" items="${roleList}"> 
												   <option value="${role.id}">${role.roleName}</option>
												</c:forEach>
											</select>
										</div>
									</div> 
									<div class="form-group">
									    <input type="checkbox" name="isResetPassword" id="editAdminPassword" value="1" style="margin-left: 80%;">重置密码
									</div> 
									
							    </form>
							</div>
							<div class="modal-footer">
							    <button type="button" class="btn btn-primary btn-sm" onclick="savaEditAdmin();">保存</button>
							    <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">取消</button>
							</div>
					    </div>
				   </div>
				</div>
				<script type="text/javascript" src="/static/admin/js/crm/auth/admin.js"></script>
</body>
</html>