<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>套餐管理</title>
</head>
<body class="no-skin">
	<div class="page-content">
		<!-- 页面内容全部放大这里 -->
		<div class="row" style="height: 50px;">
			<div class="col-md-12">
				<a  data-toggle="modal" data-target="#addVersion" class="btn btn-primary btn-sm btn-filter">添加套餐</a>
			</div>
		</div>
		<div class="row">
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
							<th>所属产品</th>
							<th>套餐名称</th>
							<th>套餐价格</th>
							<th>套餐状态</th>
							<th>添加时间</th>
							<th>操作</th>
						</tr>
					</thead>
	
					<tbody>
					    <c:forEach var="version"  items="${versionList}" varStatus="index">
							<tr class="selected">
								<td class="center">
									<label class="position-relative">
										<input type="checkbox" class="ace">
										<span class="lbl"></span>
									</label>
								</td>
								<td>${index.index+1}</td>
								<td>${version.productName}</td>
								<td>${version.versName}</td>
								<td>${version.versPrice}</td>
								<td>
								    <c:if test="${version.versStatus == 1}">
									          正常
									</c:if>
									<c:if test="${version.versStatus == 0}">
									           冻结
									</c:if>
								</td>
								<td><fmt:formatDate value="${version.createTime}" pattern="yyyy年MM月dd日 "/></td>
								<td>
									<a onclick="editVersion('${version.id}','${version.versName}','${version.versPrice}');" data-toggle="modal" data-target="#editVersion" class="mr20">编辑</a>
									<c:if test="${version.versStatus == 1}">
									   <a href="/product/freezeVersion?id=${version.id}&versStatus=0" class="mr20">冻结</a>
									</c:if>
									<c:if test="${version.versStatus == 0}">
									   <a href="/product/freezeVersion?id=${version.id}&versStatus=1" class="mr20">解冻</a>
									</c:if>
									
								</td>
							</tr>
	                                </c:forEach>
						
					</tbody>
				</table>
				
			</div>
		</div>					
		<!-- 页面内容全部放大这里 结束 -->
	</div>
	<!--新增套餐弹窗-->
	<div class="modal fade" id="addVersion" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	   <div class="modal-dialog">
		    <div class="modal-content">
		      	<div class="modal-header">
				    <button type="button" class="close" data-dismiss="modal" 
				       aria-hidden="true">×
				    </button>
				    <h4 class="modal-title" id="myModalLabel">
				        新增套餐
				    </h4>
				</div>
				<div class="modal-body">
				    <form id="addVersionForm" class="form-horizontal" role="form" method="post">
				        <div class="form-group">
							<label class="col-md-1 control-label" for="form-field-1" style="width: 25%">产品线<span class="required-star">*</span>：</label>
							<div class="col-md-2" style="width: 200px">
								<select class="input-sm form-control" name="prodId">
								    <option value="">请选择</option>
									<c:forEach var="product" items="${productList}"> 
									   <option value="${product.id}">${product.productName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
				        <div class="form-group">
							<label class="col-md-1 control-label" style="width: 25%" for="form-field-1">套餐名称<span class="required-star">*</span>：</label>
							<div class="col-md-9">
								<input type="text" name="versName" class="col-xs-10 col-sm-5">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-1 control-label" style="width: 25%" for="form-field-1">套餐价格<span class="required-star">*</span>：</label>
							<div class="col-md-9">
								<input type="text" name="versPrice"  class="col-xs-10 col-sm-5">
							</div>
						</div>
						
				    </form>
				</div>
				<div class="modal-footer">
				    <button type="button" class="btn btn-primary btn-sm" onclick="savaVersionAdd();">保存</button>
				    <button type="button" class="btn btn-default btn-sm" data-dismiss="modal" onclick="cancelSava('addVersionForm');">取消</button>
				</div>
		    </div>
	   </div>
	</div>
	<!--新增套餐弹窗-->
	<div class="modal fade" id="editVersion" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	   <div class="modal-dialog">
		    <div class="modal-content">
		      	<div class="modal-header">
				    <button type="button" class="close" data-dismiss="modal" 
				       aria-hidden="true">×
				    </button>
				    <h4 class="modal-title" id="myModalLabel">
				        编辑套餐
				    </h4>
				</div>
				<div class="modal-body">
				    <form id="editVersionForm" class="form-horizontal" role="form" method="post">
				        <input type="hidden" name="id" id="editVersionId" /> 
				        <div class="form-group">
							<label class="col-md-1 control-label" style="width: 25%" for="form-field-1">套餐名称<span class="required-star">*</span>：</label>
							<div class="col-md-9">
								<input type="text" name="versName" id="editVersionName" class="col-xs-10 col-sm-5">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-1 control-label" style="width: 25%" for="form-field-1">套餐价格<span class="required-star">*</span>：</label>
							<div class="col-md-9">
								<input type="text" name="versPrice" id="editVersionPrice" class="col-xs-10 col-sm-5">
							</div>
						</div>
						
				    </form>
				</div>
				<div class="modal-footer">
				    <button type="button" class="btn btn-primary btn-sm" onclick="savaVersionUpdate();">保存</button>
				    <button type="button" class="btn btn-default btn-sm" data-dismiss="modal" onclick="cancelSava('editVersionForm');">取消</button>
				</div>
		    </div>
	   </div>
	</div>
    <script src="/static/admin/js/crm/product/version.js"></script>
</body>
</html>