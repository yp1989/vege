<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <title>商机管理</title>
    <meta name="description" content="overview &amp; stats"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
    <!-- css样式表异步加载 在/layout/stylesheets.html内 -->
</head>

<body class="no-skin">
<div class="page-content">
    <%
        Integer num = (Integer) request.getSession().getAttribute("sumCode");
    %>
    <!-- 页面内容全部放大这里 -->
    <div class="row">
        <div class="col-md-12">
            <form class="form-horizontal" role="form" action="/business/index" method="post" id="findForm">
                <input type="hidden" id="pageNo" name="pageNo" value="${page.pageNo}"/>
                <div class="col-md-3 pb10 no-padding-left">
                    <div class="input-group">
										<span class="input-group-addon">
											客户名称
										</span>
                        <input type="text" name="custName" placeholder="请输入客户名称" value="${business.custName}"
                               class="input-sm form-control">
                    </div>
                </div>
                <div class="col-md-3 pb10 no-padding-left">
                    <div class="input-group">
										<span class="input-group-addon">
											注册时间
										</span>
                        <div class="input-daterange input-group">
                            <input type="text" class="input-sm form-control" name="createTimestart"
                                   value='<fmt:formatDate value="${business.createTimestart}" pattern="yyyy-MM-dd"/>'>
                            <span class="input-group-addon">
												<i class="fa fa-exchange"></i>
											</span>

                            <input type="text" class="input-sm form-control" name="createTimeend"
                                   value='<fmt:formatDate value="${business.createTimeend}" pattern="yyyy-MM-dd"/>'>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 pb10 no-padding-left">
                    <div class="input-group">
										<span class="input-group-addon">
											状态
										</span>
                        <select class="input-sm form-control" name="busiStatus" id="busiStatus_id">
                            <option value="">全部</option>
                            <c:forEach items="${businessStatus}" var="c" varStatus="index">
                                <option value="${c.code}"
                                        <c:if test="${busi.busiStatus == c.code}">selected</c:if>>${c.desc}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col-md-3 pb10 no-padding-left">
                    <div class="input-group">
										<span class="input-group-addon">
											商机来源
										</span>
                        <select class="input-sm form-control" name="busiSource" id="busiSource_id">
                            <option value="">全部</option>
                            <c:forEach items="${businessSource}" var="c" varStatus="index">
                                <option value="${c.code}"
                                        <c:if test="${busi.busiSource == c.code}">selected</c:if>>${c.desc}</option>
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
                                <option value="${c.id}"
                                        <c:if test="${busi.owner == c.id}">selected</c:if> >${c.adminRealName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col-md-3 pb10 no-padding-left">
                    <div class="input-group">
										<span class="input-group-addon">
											商机类型
										</span>
                        <select class="input-sm form-control" name="busiType">
                            <option value="">全部</option>
                            <c:forEach items="${businessType}" var="c" varStatus="index">
                                <option value="${c.code}"
                                        <c:if test="${busi.busiType == c.code}">selected</c:if> >${c.desc}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col-md-3 pb10 no-padding-left">
                    <div class="input-group">
										<span class="input-group-addon">
											预购套餐
										</span>
                        <select class="input-sm form-control" name="callBargain" id="dealIntention">
                            <option value="">全部</option>
                            <c:forEach items="${productVersions}" var="c" varStatus="index">
                                <option value="${c.id}"
                                        <c:if test="${clue.callBargain == c.id}">selected</c:if> >${c.versName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <button type="submit" class="btn btn-sm btn-primary btn_normal" data-fn="submit">查询</button>
            </form>
        </div>
        <%
            if ((num & 16) == 16) {
        %>
        <div class="col-md-12">
            <a href="####" data-toggle="modal" data-target="#myModal" id="allotClue_id"
               class="btn btn-primary btn-sm btn-filter">商机分配</a>
        </div>
        <%}%>
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
                    <th>编号</th>
                    <th>注册时间</th>
                    <th>客户名称</th>
                    <th>商机状态</th>
                    <th>商机来源</th>
                    <th>归属人</th>
                    <th>商机类型</th>
                    <th>预购套餐</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${page.results}" var="p" varStatus="index">
                    <tr class="selected">
                        <td class="center">
                            <label class="position-relative">
                                <input type="checkbox" class="ace acechild" value="${p.id}" name="clueIds">
                                <span class="lbl"></span>
                            </label>
                        </td>
                        <td>${p.busiNumber}</td>
                        <td><fmt:formatDate value="${p.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${p.custName}</td>
                        <td>${p.busiStatusStr}<c:if test="${p.busiStatus == 2}"><a href="###" data-toggle="modal"
                                                                                   id="return_clue_detail"
                                                                                   data-target="#modal_business_detail"
                                                                                   data-remark="${p.returnChangeRemark}">详情</a></c:if>
                        </td>
                        <td>${p.busiSourceStr}</td>
                        <td>${p.ownerName}</td>
                        <td>${p.busiTypeStr}</td>
                        <td>
                            <c:forEach items="${p.productVersionList}" var="pv">
                                ${pv.versName}
                            </c:forEach>
                        </td>
                        <td>
                            <a href="/business/show?busiId=${p.id}" class="mr20">查看</a>
                            <c:if test="${p.busiStatus != 0 && p.busiStatus != 4 && p.busiStatus != 1}">
                                <a href="/business/edit?busiId=${p.id}" class="mr20">编辑</a>
                            </c:if>
                            <%
                                if ((num & 32) == 32) {
                            %>
                            <c:if test="${p.busiStatus == 1}">
                                <a href="###" data-toggle="modal" data-target="#Auditing" data-id="${p.id}" class="mr20"
                                   id="auditing_shenhe">审核</a>
                            </c:if>
                            <%}%>
                            <c:if test="${p.busiStatus == 3 || p.busiStatus == 2}">
                                <c:if test="${p.busiType == 1}">
                                    <a href="/business/productsContract?busiId=${p.id}" data-id="${p.id}" class="mr20"
                                       id="auditing_shenhe">生成合同</a>
                                </c:if>
                                <c:if test="${p.busiType == 2}">
                                    <a href="/business/agentContract?busiId=${p.id}" data-id="${p.id}" class="mr20"
                                       id="auditing_shenhe">生成合同</a>
                                </c:if>
                            </c:if>
                            <c:if test="${p.busiStatus != 0 && p.busiStatus != 4 }">
                                <a href="javascript:;" id="businessClose" data-id="${p.id}" class="mr20">关闭</a>
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
<!--商机分配-->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">×
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    商机分配
                </h4>
            </div>
            <form class="form-horizontal lead_distribute" role="form" action="/business/distribution" method="post">
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
                    <button type="button" class="btn btn-primary btn-sm busi_allot">保存</button>
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
<!--审核合同-->
<div class="modal fade" id="Auditing" tabindex="-1" role="dialog" aria-labelledby="AuditingLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/business/auditing" method="post" id="auditing_form">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true">×
                    </button>
                    <h4 class="modal-title">
                        审核商机
                    </h4>
                </div>
                <div class="modal-body">
                    <p class="modal_closeTip text-center">该商机是否审核通过？</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary btn-sm sure_confirm">确认通过</button>
                    <button type="button" class="btn btn-default btn-sm back_edit">退回修改</button>
                </div>
                <div class="modal_more hide">
                    <p class="form-control-static">请输入退回修改原因：</p>
                    <textarea id="form-field-11" name="remark" class="autosize-transition form-control"></textarea>
                    <input type="hidden" name="busiId" id="audit_busiId" value="">
                    <input type="hidden" name="pass" id="audit_pass" value="">
                    <div class="text-right">
                        <button type="button" class="btn btn-primary btn-sm mt10 auditing-mt10 sure_submit"
                                data-dismiss="modal">提交
                        </button>
                    </div>
                </div>
            </div><!-- /.modal-content -->
        </form>
    </div><!-- /.modal-dialog -->
</div>
<!--详情-->
<div class="modal fade" id="modal_business_detail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <p class="modal_closeTip text-center" id="return_change_remark"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary btn-sm mt11" data-dismiss="modal">确认</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<!-- 返回顶部按钮 -->
<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
    <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
</a>
<!-- 返回顶部按钮 结束-->
</div>
<script src="/static/admin/js/crm/clue.js"></script>
<script src="/static/admin/js/crm/business.js"></script>
<script type="application/javascript">
    Clue.setCustRoleJson('');
    Clue.init();
    Business.init();
    //初始化加载省市县联动数据
    showLocationId('${clue.custProvince}', '${clue.custCity}', '', '#sheng', '#shi', '#qu');
    var msg = '${msg}';
    if (msg != undefined && msg != "") {
        $.getNormalMessage(msg);
    }
</script>
</body>
</html>
