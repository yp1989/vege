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
		<title>收款管理</title>
		<meta name="description" content="overview &amp; stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<!-- css样式表异步加载 在/layout/stylesheets.html内 -->
	</head>

	<body class="no-skin">
				<div class="page-content">
                    <%
                        Integer sumCode = (Integer)request.getSession().getAttribute("sumCode");
                    %>
					<!-- 页面内容全部放大这里 -->
					<div class="row">
						<div class="col-md-12">
							<form class="form-horizontal" role="form" action="/gather/index" method="post" id="findForm">
								<input type="hidden" id="pageNo" name="pageNo" value="${page.pageNo}"/>
								<div class="col-md-3 pb10 no-padding-left">
									<div class="input-group">
										<span class="input-group-addon">
											客户名称
										</span>
										<input type="text" name="custName" placeholder="请输入客户名称" value="${gath.custName}" class="input-sm form-control">
									</div>
								</div>
								<div class="col-md-3 pb10 no-padding-left">
									<div class="input-group">
										<span class="input-group-addon">
											合同编号
										</span>
										<input type="text" name="contNumber" placeholder="请输入合同编号" value="${gath.contNumber}" class="input-sm form-control">
									</div>
								</div>
								<div class="col-md-3 pb10 no-padding-left">
									<div class="input-group">
										<span class="input-group-addon">
											合同类型
										</span>
										<select class="input-sm form-control" name="clueStatusOnline" id="clueStatusOnline_id">
											<option value="">全部</option>
											<c:forEach items="${contractType}" var="c" varStatus="index">
												<option value="${c.code}" <c:if test="${gath.contType == c.code}">selected</c:if>>${c.desc}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="col-md-3 pb10 no-padding-left">
									<div class="input-group">
										<span class="input-group-addon">
											日期
										</span>
                                        <div class="input-daterange input-group">
                                            <input type="text" class="input-sm form-control" name="createTimestart" value='<fmt:formatDate value="${gath.gathTimestart}" pattern="yyyy-MM-dd"/>'>
											<span class="input-group-addon">
												<i class="fa fa-exchange"></i>
											</span>

                                            <input type="text" class="input-sm form-control" name="createTimeend" value='<fmt:formatDate value="${gath.gathTimeend}" pattern="yyyy-MM-dd"/>'>
                                        </div>
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
												<option value="${c.id}" <c:if test="${gath.owner == c.id}">selected</c:if> >${c.adminRealName}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<button type="submit" class="btn btn-sm btn-primary btn_normal" data-fn="submit">查询</button>
							</form>
						</div>
                        <%
                            if((sumCode&256)==256){
                        %>
						<div class="col-md-12">
							<a href="###" class="btn btn-primary btn-sm btn-filter" data-toggle="modal" data-target="#modal_receive">新增收款</a>
						</div>
                        <%}%>
						<div class="col-xs-12" style="margin-top: 10px;">
							<table id="sample-table-1" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>序号</th>
										<th>收款时间</th>
										<th>合同编号</th>
										<th>客户名称</th>
										<th>到款金额(元)</th>
										<th>合同类型</th>
										<th>归属人</th>
										<th>登记人</th>
										<th>操作</th>
									</tr>
								</thead>

								<tbody>
								<c:forEach items="${page.results}" var="p" varStatus="index">
									<tr class="selected">
										<td class="center">
											${index.index +1}
										</td>
										<td><fmt:formatDate value="${p.gathDate}" pattern="yyyy-MM-dd"/></td>
										<td>${p.contNumber}</td>
										<td><a href="/clue/toShowClue?clueId=${p.clueId}">${p.custName}</a></td>
										<td>${p.gathMoney}</td>
										<td>${p.contTypeStr}</td>
										<td>${p.owerName}</td>
										<td>${p.registerName}</td>
										<td>
                                            <%
                                                if((sumCode&1024)==1024){
                                            %>
											<a href="###" class="mr20" id="edit_gather" data-toggle="modal" data-target="#modal_receive_edit" data-id="${p.id}" data-contNumber="${p.contNumber}">编辑</a>
                                            <%}%>
                                            <c:choose>
                                                <c:when test="${p.accStatus == 2}">
                                                    <%
                                                        if((sumCode&512)==512){
                                                    %>
                                                    <a href="###" id="confirm_open" data-contid="${p.contId}">确认开通</a>
                                                    <%}%>
                                                </c:when>
                                                <c:otherwise>
                                                    <a href="###">已开通</a>
                                                </c:otherwise>
                                            </c:choose>
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
                <!--新增收款-->
                <div class="modal fade" id="modal_receive" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"
                                        aria-hidden="true">×
                                </button>
                                <h4 class="modal-title" id="myModalLabel">
                                    新增收款
                                </h4>
                            </div>
                            <div class="modal-body">
                                <form class="form-horizontal" role="form" action="/gather/doGather" method="post" id="gatherAddForm">
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">关联合同：</label>
                                        <div class="col-md-8">
                                            <div class="pos-rel">
                                                <input class="typeahead scrollable" type="text" placeholder="请输入合同编号" id="Contract_contNumber" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">应收款：</label>
                                        <div class="col-md-9">
                                            <div class="col-md-9">
                                                <p class="form-control-static" id="cont_receivable">0</p>
                                            </div>
                                            <p class="form-control-static col-sm-2">元</p>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">已收款：</label>
                                        <div class="col-md-9">
                                            <div class="col-md-9">
                                                <p class="form-control-static" id="cont_collected">0</p>
                                            </div>
                                            <p class="form-control-static col-sm-2">元</p>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">本次收款：</label>
                                        <div class="col-md-9">
                                            <input type="text" name="gathMoney" id="cont_gathMoney" class="col-sm-9" placeholder="请输入本次收款金额"/>
                                            <p class="form-control-static col-sm-2">元</p>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">收款时间：</label>
                                        <div class="col-md-8">
                                            <input class="form-control date-picker" name="gathDate" type="text" data-date-format="dd-mm-yyyy" />
                                        </div>
                                    </div>
                                    <input type="hidden" name="contId" id="cont_id" value=""/>
                                </form>

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-primary btn-sm" id="gatherAddBtn">保存</button>
                                <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">取消</button>
                            </div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div>
                <!--编辑收款-->
                <div class="modal fade" id="modal_receive_edit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"
                                        aria-hidden="true">×
                                </button>
                                <h4 class="modal-title" id="myModalLabelEdit">
                                    编辑收款
                                </h4>
                            </div>
                            <div class="modal-body">
                                <form class="form-horizontal" role="form" action="/gather/doGather" method="post" id="gatherAddFormEdit">
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">关联合同：</label>
                                        <div class="col-md-8">
                                            <div class="pos-rel">
                                                <input class="typeahead scrollable" type="text" placeholder="请输入合同编号" id="Contract_contNumberEdit" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">应收款：</label>
                                        <div class="col-md-9">
                                            <div class="col-md-9">
                                                <p class="form-control-static" id="cont_receivable_edit">0</p>
                                            </div>
                                            <p class="form-control-static col-sm-2">元</p>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">已收款：</label>
                                        <div class="col-md-9">
                                            <div class="col-md-9">
                                                <p class="form-control-static" id="cont_collected_edit">0</p>
                                            </div>
                                            <p class="form-control-static col-sm-2">元</p>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">本次收款：</label>
                                        <div class="col-md-9">
                                            <input type="text" name="gathMoney" id="cont_gathMoney_edit" data-old-val="" class="col-sm-9" id="gathMoney_edit" placeholder="请输入本次收款金额"/>
                                            <p class="form-control-static col-sm-2">元</p>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">收款时间：</label>
                                        <div class="col-md-8">
                                            <input class="form-control date-picker" name="gathDate" id="gathDate_edit" type="text" data-date-format="dd-mm-yyyy" />
                                        </div>
                                    </div>
                                    <input type="hidden" name="id" id="id_edit" value=""/>
                                </form>

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-primary btn-sm" id="gatherAddBtn_edit">保存</button>
                                <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">取消</button>
                            </div>
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
		    <script src="/static/admin/js/crm/gathering.js"></script>
            <script src="/static/admin/js/typeahead.jquery.min.js"></script>
				<script type="application/javascript">
                    Gathering.init();
                    $(function(){
                        //typeahead.js
                        var substringMatcher = function(strs) {
                            return function findMatches(q, cb) {
                                var matches, substringRegex;
                                matches = [];
                                substrRegex = new RegExp(q, 'i');
                                $.each(strs, function(i, str) {
                                    if (substrRegex.test(str)) {
                                        matches.push({ value: str });
                                    }
                                });

                                cb(matches);
                            }
                        }

                        $('#Contract_contNumber').typeahead({
                            hint: true,
                            highlight: true,
                            minLength: 1
                        }, {
                            name: 'states',
                            displayKey: 'value',
                            source: substringMatcher(${contractNames}),
                            updater: function(item) {
                                console.log("'" + item + "' selected.");
                                return item;
                            }
                        });

                    });

					var msg = '${msg}';
					if(msg != undefined && msg != ""){
						$.tipshow({
                            'msg':msg,
                            'type':'info',
                            'ico':'fa-check-circle-o'
                        });
					}
				</script>
	</body>
</html>
