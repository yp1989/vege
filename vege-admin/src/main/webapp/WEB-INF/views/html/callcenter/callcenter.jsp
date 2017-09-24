<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>呼叫中心</title>
		<meta name="description" content="overview &amp; stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<!-- css样式表异步加载 在/layout/stylesheets.html内 -->
	</head>

	<body class="no-skin">
				<div class="page-content">
					<!-- 页面内容全部放大这里 -->
					<div class="row">
						<div class="col-md-12">
							<form class="form-horizontal" role="form" action="/callcenter/index" method="post" id="findForm">
								<input type="hidden" id="pageNo" name="pageNo" value="${page.pageNo}"/>
								<div class="col-md-3 pb10 no-padding-left">
									<div class="input-group">
										<span class="input-group-addon">
											客户名称
										</span>
										<input type="text" name="custName" placeholder="请输入客户名称" value="${clue.custName}" class="input-sm form-control">
									</div>
								</div>
								<div class="col-md-3 pb10 no-padding-left">
									<div class="input-group">
										<span class="input-group-addon">
											线索状态
										</span>
										<select class="input-sm form-control" name="clueStatusOnline" id="clueStatusOnline_id">
											<option value="">全部</option>
											<c:forEach items="${clueStatusOnline}" var="c" varStatus="index">
												<option value="${c.code}" <c:if test="${clue.clueStatusOnline == c.code}">selected</c:if>>${c.desc}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="col-md-3 pb10 no-padding-left">
									<div class="input-group">
										<span class="input-group-addon">
											创建时间
										</span>
										<div class="input-daterange input-group">
											<input type="text" class="input-sm form-control" name="createTimestart" value='<fmt:formatDate value="${clue.createTimestart}" pattern="yyyy-MM-dd"/>'>
											<span class="input-group-addon">
												<i class="fa fa-exchange"></i>
											</span>

											<input type="text" class="input-sm form-control" name="createTimeend" value='<fmt:formatDate value="${clue.createTimeend}" pattern="yyyy-MM-dd"/>'>
										</div>
									</div>
								</div>
								<div class="col-md-3 pb10 no-padding-left">
									<div class="input-daterange input-group">
										<span class="input-group-addon">
											分配时间
										</span>
										<div class="input-daterange input-group">
											<input type="text" class="input-sm form-control" name="allotTimestart" value='<fmt:formatDate value="${clue.allotTimestart}" pattern="yyyy-MM-dd"/>'>
											<span class="input-group-addon">
												<i class="fa fa-exchange"></i>
											</span>

											<input type="text" class="input-sm form-control" name="allotTimeend" value='<fmt:formatDate value="${clue.allotTimeend}" pattern="yyyy-MM-dd"/>'>
										</div>
									</div>
								</div>						
								<div class="col-md-3 pb10 no-padding-left">
									<div class="input-group">
										<span class="input-group-addon">
											联系方式
										</span>
										<input type="text" placeholder="请输入联系方式" name="contactsPhone" value="${clue.contactsPhone}"  class="input-sm form-control">
									</div>
								</div>
								<div class="col-md-3 pb10 no-padding-left">
									<div class="input-group">
										<span class="input-group-addon">
											省份
										</span>
										<select class="input-sm form-control" name="custProvince" id="sheng">

										</select>
									</div>
								</div>
								<div class="col-md-3 pb10 no-padding-left">
									<div class="input-group">
										<span class="input-group-addon">
											城市
										</span>
										<select class="input-sm form-control" name="custCity" id="shi">

										</select>
									</div>
								</div>
								<div class="col-md-3 pb10 no-padding-left">
									<div class="input-group">
										<span class="input-group-addon">
											线索类型
										</span>
										<select class="input-sm form-control" name="clueType">
											<option value="">全部</option>
											<c:forEach items="${ClueType}" var="c" varStatus="index">
												<option value="${c.code}" <c:if test="${clue.clueType == c.code}">selected</c:if> >${c.desc}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="col-md-3 pb10 no-padding-left">
									<div class="input-group">
										<span class="input-group-addon">
											归属人
										</span>
										<select class="input-sm form-control" name="owner" id="form-field-owner">
											<option value="">全部</option>
											<c:forEach items="${adminList}" var="c" varStatus="index">
												<option value="${c.id}" <c:if test="${clue.owner == c.id}">selected</c:if> >${c.adminRealName}</option>
											</c:forEach>
										</select>
									</div>
								</div>
                                <div class="col-md-3 pb10 no-padding-left">
                                    <div class="input-group">
										<span class="input-group-addon">
											代理商归属人
										</span>
                                        <input type="text" name="ownerName" placeholder="请输入代理商名称" value="${clue.ownerName}" class="input-sm form-control">
                                    </div>
                                </div>
								<div class="col-md-3 pb10 no-padding-left">
									<div class="input-group">
										<span class="input-group-addon">
											预购产品
										</span>
										<select class="input-sm form-control" name="productId">
											<option value="">全部</option>
											<c:forEach items="${products}" var="c" varStatus="index">
												<option value="${c.id}" <c:if test="${clue.productId == c.id}">selected</c:if> >${c.productName}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="col-md-3 pb10 no-padding-left">
									<div class="input-group">
										<span class="input-group-addon">
											成交意向
										</span>
										<select class="input-sm form-control" name="callBargain" id="dealIntention">
											<option value="">全部</option>
											<c:forEach items="${dealIntention}" var="c" varStatus="index">
												<option value="${c.code}" <c:if test="${clue.callBargain == c.code}">selected</c:if> >${c.desc}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="col-md-3 pb10 no-padding-left">
									<div class="input-group">
										<span class="input-group-addon">
											了解方式
										</span>
										<select class="input-sm form-control" name="clueKnow">
											<option value="">全部</option>
											<c:forEach items="${ClueKnow}" var="c" varStatus="index">
												<option value="${c.code}" <c:if test="${clue.clueKnow == c.code}">selected</c:if> >${c.desc}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<button type="submit" class="btn btn-sm btn-primary btn_normal" data-fn="submit">查询</button>
							</form>
						</div>
						<div class="col-md-12">
							<a href="/callcenter/toAddClue" class="btn btn-primary btn-sm btn-filter">新增线索</a>
							<a href="javascript:;"  id="allotClue_id" class="btn btn-primary btn-sm btn-filter">线索分配</a>
							<a href="javascript:;"  id="allotClue_id_toAgent" class="btn btn-primary btn-sm btn-filter">分配给代理商</a>
						</div>
						<div class="col-xs-12" style="margin-top: 10px;">
							<table id="sample-table-1" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center">
											<label class="position-relative">
												<input type="checkbox" class="ace">
												<span class="lbl"></span>
											</label>
										</th>
										<th>创建时间</th>
										<th>分配时间</th>
										<th>回访时间</th>
										<th>回访状态</th>
										<th>客户名称</th>
										<th>联系人</th>
										<th>省份</th>
										<th>城市</th>
										<th>线索状态</th>
										<th>成交意向</th>
										<th>了解方式</th>
										<th>归属人</th>
										<th>线索类型</th>
										<th>录入人</th>
										<th>操作</th>
									</tr>
								</thead>

								<tbody>
								<c:forEach items="${page.results}" var="p" varStatus="index">
									<tr class="selected <c:if test="${p.isRepeat > 0}">red</c:if>">
										<td class="center">
											<label class="position-relative">
												<input type="checkbox" class="ace acechild" value="${p.id}" data-status="${p.clueStatusOnline}" name="clueIds" data-owner-type="${p.ownerType}">
												<span class="lbl"></span>
											</label>
										</td>
										<td><fmt:formatDate value="${p.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
										<td><fmt:formatDate value="${p.allotTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
										<td><fmt:formatDate value="${p.callTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
										<td>${p.optionStatus == 0 ? "未回访" : "已回访"}</td>
										<td>${p.custName}</td>
										<td>${p.contacts}</td>
										<td>${p.provinceName}</td>
										<td>${p.cityName}</td>
										<td>${p.clueStatusOnlineStr}</td>
										<td>${p.callBargainStr}</td>
										<td>${p.clueKnowStr}</td>
										<td>${p.ownerName}</td>
										<td>${p.clueTypeStr}</td>
										<td>${p.adminName}</td>
										<td>
											<a href="/callcenter/toShowClue?clueId=${p.id}" target="_blank" class="mr20">查看</a>
											<c:if test="${p.clueStatusOnline != 2 && p.clueStatusOnline != 1 && p.clueStatusOnline != 4}">
												<a href="/callcenter/toEditClue?clueId=${p.id}" target="_blank" class="mr20">编辑</a>
											</c:if>
											<c:if test="${p.clueStatusOnline != 2 && p.clueStatusOnline != 1 && p.clueStatusOnline != 4}">
												<a href="javascript:;" class="mr20 centerCloseClue"  data-id="${p.id}">关闭</a>
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
			</div>
				<!--线索分配-->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
							    <button type="button" class="close" data-dismiss="modal" 
							       aria-hidden="true">×
							    </button>
							    <h4 class="modal-title" id="myModalLabel">
							       线索分配
							    </h4>
							</div>
							<%--<form class="form-horizontal lead_distribute" role="form" action="/callcenter/distribution" method="post">--%>
							<div class="modal-body">
						        <div class="form-group">
						            <label class="col-md-3 control-label" for="form-field-1">归属人：</label>
						            <div class="col-md-6">
						                <select class="input-sm form-control" name="owner" id="form-field-1">
						                    <option value="">请选择归属人</option>
						                    
						                </select>
						                <input type="hidden" name="ownerName" id="id_ownerName" value="">
						                <input type="hidden" name="cluds" value="">
						            </div>
						        </div>
							</div>
							<div class="modal-footer">
							    <button type="submit" class="btn btn-primary btn-sm" id="fenpei_xiansuo_button">保存</button>
							    <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">取消</button>
							</div>
							<%--</form>--%>
						</div><!-- /.modal-content -->
					</div><!-- /.modal-dialog -->
				</div>
				<!--线索分配给代理商-->
				<div class="modal fade" id="myModalAgent" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">

							<div class="modal-header">
							    <button type="button" class="close" data-dismiss="modal"
							       aria-hidden="true">×
							    </button>
							    <h4 class="modal-title" id="myModalLabelAgent">
							       线索分配
							    </h4>
							</div>
							<div class="modal-body">
						        <div class="form-group">
						            <label class="col-md-3 control-label" for="form-field-1">公司名称：</label>
						            <div class="col-md-6">
										<input type="text" placeholder="请输入公司名称" name="companyName" value="" id="query_agent_companyName"  class="input-sm form-control">

						            </div>
									<button type="button" class="btn btn-sm btn-primary btn_normal" data-fn="submit" id="query_agent_submit">查询</button>
						        </div>
							</div>

							<div class="modal-body">
								<table id="sample-table-2" class="table table-striped table-bordered table-hover">
									<thead>
									<tr>
										<th class="center">
											<label class="position-relative">
												<span class="lbl"></span>
											</label>
										</th>
										<th>登录名</th>
										<th>公司名称</th>
									</tr>
									</thead>

									<tbody class="tbody_agent">

									</tbody>
								</table>
							</div>
                            <form class="form-horizontal lead_distribute_agent" role="form" action="/callcenter/addClueToAgent" method="post">
							<div class="modal-footer">
                                <input type="hidden" name="clueIds" id="query_agent_clueIds" value="">
                                <input type="hidden" name="agentName" id="query_agent_name" value="">
                                <input type="hidden" name="agentId" id="query_agent_id" value="">
                                <input type="hidden" name="opt" id="query_agent_opt" value="add">
							    <button type="button" class="btn btn-primary btn-sm" id="query_agent_sure">确定</button>
							    <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">取消</button>
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
			<!-- 返回顶部按钮 -->
			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
			<!-- 返回顶部按钮 结束-->
		</div>
		<script src="/static/admin/js/crm/clue.js"></script>
				<script type="application/javascript">
					Clue.setCustRoleJson('');
					Clue.init();
					//初始化加载省市县联动数据
					showLocationId('${clue.custProvince}','${clue.custCity}','','#sheng','#shi','#qu');
					var msg = '${msg}';
					var msgcode = '${msgcode}';
					if(msg != undefined && msg != ""){
						if(msgcode == '1'){
							$.tipshow({
								'msg':msg,
								'type':'info',
								'ico':'fa-check-circle-o'
							});
						}else{
							$.getWarnMessage(msg);
						}

					}
					var sumCode = $("#sumCode").val();
					if((sumCode&2)!=2){
						$('#allotClue_id').remove();
						$('#allotClue_id_toAgent').remove();
					}

					function goPaging (pageNo){
						var query = $("#query_agent_companyName").val();
						Clue.queryAgent(query,pageNo,10);
					}
				</script>
	</body>
</html>
