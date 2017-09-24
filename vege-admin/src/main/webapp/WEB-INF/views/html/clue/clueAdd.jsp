<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>新增线索</title>
		<meta name="description" content="overview &amp; stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<!-- css样式表异步加载 在/layout/stylesheets.html内 -->
	</head>

				<form class="form-horizontal" role="form" method="post" id="addNewCustForm" action="/clue/doAddClue">
					<input type="hidden" name="clue.clueKnow" value="-1" id="clueKnow">
					<input type="hidden" name="clue.clueConsult" value="-1" id="clueConsult">
				<div class="page-content">
					<!-- 页面内容全部放大这里 -->
					<div class="page-header">
						<h1>客户联系人信息</h1>
					</div>
					<div class="row">
						<div class="col-md-12">
								<div class="form-group">
									<label class="col-md-1 control-label">客户名称<span class="required-star">*</span>：</label>
									<div class="col-md-6">
										<input type="text" id="form-field-1" name="clue.custName" class="input-sm form-control">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-1 control-label">客户地址<span class="required-star">*</span>：</label>
									<div class="col-md-2">
										<select class="input-sm form-control" name="clue.custProvince" id="sheng">

										</select>
									</div>
									<div class="col-md-2">
										<select class="input-sm form-control" name="clue.custCity" id="shi">

										</select>
									</div>
									<div class="col-md-2">
										<select class="input-sm form-control" name="clue.custArea" id="qu">

										</select>
									</div>
									<div class="clear" id="shengshiInfo"></div>
									<p class="tips red hide">您输入的省市信息不完整</p>
								</div>
								<div class="form-group">
									<label class="col-md-1 control-label">详细地址：</label>
									<div class="col-md-6">
										<input type="text" id="form-field-2" class="input-sm form-control" name="clue.custAddr">
									</div>
								</div>
							
						</div>
					</div>
					<div class="row">
						<div class="col-md-7">
			                <table id="vweddingTable" class="table table-striped table-bordered table-hover dataTable ">
			                    <thead>
				                    <tr>
				                        <th>序号</th>
				                        <th>角色</th>
				                        <th>姓名</th>
				                        <th>职务</th>
				                        <th>联系方式</th>
				                        <th>QQ</th>
				                        <th>邮箱</th>
				                    </tr>
			                    </thead>
			                    <tbody>

								</tbody>
			                </table>
			            </div>
			            <div class="col-md-12 mt20">
			            	<button class="btn btn-sm btn-primary" id="addNewCust" type="button">新增联系人</button>
			            </div>
					</div>

					<div class="mt20">
						<div class="page-header">
							<h1>线索基本信息</h1>
						</div>
						<div class="row">
							<div class="col-md-12">
									<div class="form-group">
										<label class="col-md-1 control-label" >录入人：</label>
										<div class="col-md-7">
											 <p class="form-control-static">${admin.adminRealName}</p>
                                            <input type="hidden" name="clue.adminId">
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-1 control-label" >线索来源<span class="required-star">*</span>：</label>
										<div class="col-md-2">
											<select class="input-sm form-control" name="clue.clueSource" id="clueSource">
                                                <option value="">请选择</option>
                                                <c:forEach items="${ClueSource}" var="c" varStatus="index">
                                                    <option value="${c.code}" >${c.desc}</option>
                                                </c:forEach>
											</select>
										</div>
									</div>


									<div class="form-group">
										<label class="col-md-1 control-label" >线索类型<span class="required-star">*</span>：</label>
										<div class="col-md-2">
											<select class="input-sm form-control" name="clue.clueType" id="clueType">
												<option value="">请选择</option>
                                                <c:forEach items="${ClueType}" var="c" varStatus="index">
                                                    <option value="${c.code}">${c.desc}</option>
                                                </c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-1 control-label" >预购产品<span class="required-star">*</span>：</label>
										<div class="col-md-10">
											<c:forEach items="${products}" var="c" varStatus="index">
												<label class="checkbox-inline no-padding-left">
													<input name="productIds" type="checkbox" value="${c.id}" class="ace">
													<span class="lbl">${c.productName}</span>
												</label>
											</c:forEach>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-1 control-label">关键字：</label>
										<div class="col-md-5">
											<input type="text" name="clue.clueKeyword" id="form-field-3" class="input-sm form-control">
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-1 control-label" >备注：</label>
										<div class="col-md-5">
											<textarea id="form-field-11" class="input-sm form-control" name="clue.remark" style="overflow: hidden; word-wrap: break-word; resize: horizontal; height: 52px;"></textarea>
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-5">
											<button type="button" class="btn btn-sm btn-primary" data-fn="submit" id="submitBtn">保存</button>
											<button type="button" class="btn btn-sm btn-default" data-dismiss="modals">取消</button>
										</div>
									</div>
							</div>
						</div>	
					</div>
					<!-- 页面内容全部放大这里 结束 -->
					<!--该号码关联线索-->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-lg">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">×
									</button>
									<h4 class="modal-title" id="myModalLabel">
										该号码关联线索
									</h4>
								</div>
								<form class="form-horizontal lead_distribute" role="form" action="/clue/distribution" method="post">
									<div class="modal-body">
										<div class="form-group">
											<table id="vweddingTableModel" class="table table-striped table-bordered table-hover dataTable ">
												<thead>
												<tr>
													<th>线索编号</th>
													<th>线索状态</th>
													<th>归属人</th>
													<th>预购产品</th>
													<th>创建时间</th>
												</tr>
												</thead>
												<tbody>

												</tbody>
											</table>
										</div>
									</div>
									<div class="modal-footer">
										<%--<button type="button" class="btn btn-primary btn-sm" id="pickCustomer">保存</button>--%>
										<button type="button" class="btn btn-default btn-sm" data-dismiss="modal" >取消</button>
									</div>
								</form>
							</div><!-- /.modal-content -->
						</div><!-- /.modal-dialog -->
					</div>
					<!--关闭-->
					<div class="modal fade" id="modal_close" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content"></div><!-- /.modal-content -->
						</div><!-- /.modal-dialog -->
					</div>
				</div>
				</form>
            <script src="/static/admin/js/area.js"></script>
            <script src="/static/admin/js/crm/clue.js"></script>
            <script type="application/javascript">
            	Clue.setCustRoleJson(${roles});
                Clue.init();
				showLocationId('${clue.custProvince}','${clue.custCity}','','#sheng','#shi','#qu');
				var msg = '${msg}';
				if(msg != undefined && msg != ""){
					$.tipshow({
						'msg':msg,
						'type':'info',
						'ico':'fa-check-circle-o'
					});
				}
            </script>
</html>
