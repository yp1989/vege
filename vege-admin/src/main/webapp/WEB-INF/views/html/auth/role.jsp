<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>

</head>
<body class="no-skin">
   			<div class="page-content">
					<!-- 页面内容全部放大这里 -->
					<div class="row" style="height: 50px;">
						<div class="col-md-12">
							<a href="${pageContext.request.contextPath}/auth/addRolePage" class="btn btn-primary btn-sm btn-filter">添加角色</a>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<table id="sample-table-1" class="table table-striped table-bordered table-hover" >
								<thead>
									<tr>
										<th class="center">
											<label class="position-relative">
												<input type="checkbox" class="ace">
												<span class="lbl"></span>
											</label>
										</th>
										<th>序号</th>
										<th>角色名称</th>
										<th style="width: 500px">权限</th>
										<th>创建时间</th>
										<th>操作</th>
									</tr>
								</thead>

								<tbody>
								    <c:forEach var="role"  items="${roleList}" varStatus="index">
										<tr class="selected">
											<td class="center">
												<label class="position-relative">
													<input type="checkbox" class="ace">
													<span class="lbl"></span>
												</label>
											</td>
											<td>${index.index+1}</td>
											<td>${role.roleName}</td>
											<td>
                                                <c:forEach var="auth"  items="${role.authRoleList}" varStatus="index">
                                                     ${auth.authName}&nbsp;
                                                </c:forEach>
                                            </td>
											<td><fmt:formatDate value="${role.createTime}" pattern="yyyy年MM月dd日 "/></td>
											<td>
												<a onclick="editRole('${role.id}');" data-toggle="modal" data-target="#editRole" class="mr20">编辑</a>
												<a onclick="deleteRole('${role.id}');" class="mr20">删除</a>
											</td>
										</tr>
                                    </c:forEach>
									
								</tbody>
							</table>
							
						</div>
					</div>					
					<!-- 页面内容全部放大这里 结束 -->
				</div>
				<!--编辑角色弹窗-->
				<div class="modal fade" id="editRole" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				   <div class="modal-dialog">
					    <div class="modal-content">
					      	<div class="modal-header">
							    <button type="button" class="close" onclick="cancelSava();" data-dismiss="modal" 
							       aria-hidden="true">×
							    </button>
							    <h4 class="modal-title" id="myModalLabel">
							        编辑角色
							    </h4>
							</div>
							<div class="modal-body">
							    <form id="editRoleForm" class="form-horizontal" role="form" method="post">
							        <input type="hidden" name="id" id="editRoleId" /> 
							        <div class="form-group">
										<label class="col-md-1 control-label" style="width: 20%" for="form-field-1">角色名称<span class="required-star">*</span>：</label>
										<div class="col-md-9">
											<input type="text" name="roleName"  id="editRoleName" class="col-xs-10 col-sm-5">
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-1 control-label" style="width: 20%" for="form-field-1">角色描述：</label>
										<div class="col-md-9">
											<input type="text" name="roleDesc" id="editRoleDesc"  class="col-xs-10 col-sm-5">
										</div>
									</div>
									<div>
									   <table border="1" style="height: 400px;width: 80%;border: 1px solid #BEBEBE;font-size: 14px">
									       <c:forEach var="auth" items="${authList}">
									          <tr style="background-color: #EAEAEA">
									             <td><input type="checkbox" name="authIdArray" value="${auth.id}" style="margin-left: 20px;">&nbsp;${auth.authName}</td>
									          </tr>
									          <c:if test="${fn:length(auth.children) > 0}">
									              <tr>
									                  <td>
									                     <c:forEach var="authChild" items="${auth.children}">
									                         <input type="checkbox" name="authIdArray" value="${authChild.id}" style="margin-left: 50px">&nbsp;${authChild.authName}&nbsp;
									                     </c:forEach>  
									                  </td>
									              </tr>
									          </c:if>
									           
									       </c:forEach>
									       
									   </table>
									</div>
							    </form>
							</div>
							<div class="modal-footer">
							    <button type="button" class="btn btn-primary btn-sm" onclick="savaEditAdmin();">保存</button>
							    <button type="button" class="btn btn-default btn-sm" data-dismiss="modal" onclick="cancelSava();">取消</button>
							</div>
					    </div>
				   </div>
				</div>
				 <script src="/static/admin/js/crm/auth/role.js"></script>
</body>
</html>