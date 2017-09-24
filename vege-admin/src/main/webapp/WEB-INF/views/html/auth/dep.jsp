<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>部门管理</title>
      
       
	</head>

	<body class="no-skin">
		<div class="page-content">
			<!-- 页面内容全部放大这里 -->
			<div class="row">
			
				<div class="col-md-3">
					<div id="tree_test"></div>
					<div id="mm" class="easyui-menu" style="width:120px;">
						<div onclick="append()" data-toggle="modal" data-target="#add"  data-options="iconCls:'icon-add'">添加部门</div>
						<div onclick="edit()" data-toggle="modal" data-target="#edit" data-options="iconCls:'icon-edit'">修改部门</div>
						<div onclick="deleteNode()" data-options="iconCls:'icon-remove'">删除部门</div>
					</div>
					
				</div>
				<form id="loadAdminBydep" class="form-horizontal" role="form" method="post">
				    <input type="hidden" name="adminDep" id="loadAdminDep">
				</form>
				<div class="col-md-9">
					<h5 class="center" id="total">全部成员（${fn:length(page.results)}）</h5>
					<table class="table table-striped table-bordered table-hover dataTable ">
						<thead>
							<tr>
								<th>序号</th>
								<th>姓名</th>
								<th>部门</th>
								<th>部门管理者</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="tableBody">
						    <c:forEach var="admin" items="${page.results}" varStatus="index">
						       <tr>
									<td>${index.index+1}</td>
									<td>${admin.adminName}</td>
									<td>${admin.depName}</td>
									<td>
										<label>
										   <c:choose>  
  
											   <c:when test="${admin.isDepManager == 1}">
											       <input name="switch-field-1" checked="checked" onchange="setIsDepManager(0,'${admin.id}','${admin.adminDep}');" class="ace ace-switch ace-switch-6" type="checkbox">  
											   </c:when>   
											   <c:otherwise>
                                                   <input name="switch-field-1" onchange="setIsDepManager(1,'${admin.id}','${admin.adminDep}');" class="ace ace-switch ace-switch-6" type="checkbox">  
											   </c:otherwise>  
											</c:choose> 
											
											<span class="lbl"></span>
										</label>
									</td>
									<td><a  data-toggle="modal" data-target="#move" class="mr20" onclick="moveAdmin('${admin.id}');">移动</a><!-- <a href="#">删除</a> --></td>
								</tr>
						    </c:forEach>
						</tbody>
					</table>
					<%-- <%@include file="/WEB-INF/views/common/pagination.jsp" %> --%>
				</div>
			</div>				
			<!-- 页面内容全部放大这里 结束 -->
		</div>
		
		<!--添加子部门弹窗-->
		<div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		   <div class="modal-dialog">
			    <div class="modal-content">
			      	<div class="modal-header">
					    <button type="button" class="close" data-dismiss="modal" 
					       aria-hidden="true">×
					    </button>
					    <h4 class="modal-title" id="myModalLabel">
					       添加部门
					    </h4>
					</div>
					<div class="modal-body">
					    <form id="addDepForm" class="form-horizontal" role="form" method="post">
					        <input type="hidden" id="parentId" name="parentId">
					        <div class="form-group">
					            <label class="col-md-3 control-label" for="form-field-1">部门名称：</label>
					            <div class="col-md-9">
					                <input type="text" name="depName" placeholder="请输入部门名称" class="input-sm form-control">
					            </div>
					        </div>
					    </form>
					</div>
					<div class="modal-footer">
					    <button type="button" class="btn btn-primary btn-sm" onclick="savaAddDep();" data-dismiss="modal">保存</button>
					    <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">取消</button>
					</div>
			    </div>
		   </div>
		</div>
		
		<!--修改部门弹窗-->
		<div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		   <div class="modal-dialog">
			    <div class="modal-content">
			      	<div class="modal-header">
					    <button type="button" class="close" data-dismiss="modal" 
					       aria-hidden="true">×
					    </button>
					    <h4 class="modal-title" id="myModalLabel">
					        修改部门
					    </h4>
					</div>
					<div class="modal-body">
					    <form id="editDepForm" class="form-horizontal" role="form" method="post">
					        <input type="hidden" id="depId" name="id">
					        <div class="form-group">
					            <label class="col-md-3 control-label" for="form-field-1">部门名称：</label>
					            <div class="col-md-9">
					                <input type="text" name="depName" id="editDepName" class="input-sm form-control">
					            </div>
					        </div>
					    </form>
					</div>
					<div class="modal-footer">
					    <button type="button" class="btn btn-primary btn-sm" onclick="savaUpdateDep();" data-dismiss="modal">保存</button>
					    <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">取消</button>
					</div>
			    </div>
		   </div>
		</div>
		
		<!--移动部门-->
		<div class="modal fade" id="move" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		   <div class="modal-dialog">
			    <div class="modal-content">
			      	<div class="modal-header">
					    <button type="button" class="close" onclick="cancelMove();" data-dismiss="modal" 
					       aria-hidden="true">×
					    </button>
					    <h4 class="modal-title" id="myModalLabel">
					       请选择从属部门
					    </h4>
					</div>
					<div class="modal-body">
					    <form id="moveAdminForm" class="department_dialog" role="form" method="post">
					       <input type="hidden" name="adminId" id="adminId"/> 
					       <c:forEach var="dep" items="${depList}">
						        <div class="form-group">
									<label>
										<input name="adminDep" type="radio" class="ace" value="${dep.id}">
										<span class="lbl"> ${dep.depName}</span>
									</label>
						        </div>
					        </c:forEach>
					        <input type="reset" name="resetBtn" style="display: none;">
					    </form>
					</div>
					<div class="modal-footer">
					    <button type="button" class="btn btn-primary btn-sm" onclick="savaMoveAdmin();">保存</button>
					    <button type="button" onclick="cancelMove();" class="btn btn-default btn-sm" data-dismiss="modal">取消</button>
					</div>
			    </div>
		   </div>
		   
		</div>
		<!-- ace scripts -->
		<!-- <script src="/static/admin/js/ace.min.js"></script>
		<script src="/static/admin/js/ace-elements.min.js"></script>
		<script src="/static/admin/js/fuelux/data/fuelux.tree-sample-demo-data.js"></script>
		<script src="/static/admin/js/fuelux/fuelux.tree.min.js"></script> -->
		 <link rel="stylesheet" type="text/css" href="/static/admin/js/easyui/themes/default/easyui.css">
         <link rel="stylesheet" type="text/css" href="/static/admin/js/easyui/themes/icon.css">
		<script type="text/javascript" src="/static/admin/js/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="/static/admin/js/easyui/jquery-migrate-1.2.1.min.js"></script>
        <script src="/static/admin/js/crm/auth/dep.js"></script>
	</body>
</html>
