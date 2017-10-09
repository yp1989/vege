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
    <title>查看线索</title>
    <meta name="description" content="overview &amp; stats"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
    <!-- css样式表异步加载 在/layout/stylesheets.html内 -->
</head>

<body class="no-skin">
<form class="form-horizontal" role="form" method="post" id="addNewCustForm">
    <input type="hidden" name="clue.clueKnow" value="-1" id="clueKnow">
    <input type="hidden" name="clue.clueConsult" value="-1" id="clueConsult">
    <div class="page-content">
        <!-- 页面内容全部放大这里 -->
        <div class="page-header">
            <h1>客户联系人信息</h1>
        </div>
        <div class="row">
            <div class="col-md-12">

                <div class="form-group no-margin-left">
                    <div class="input-group col-md-3">
                        <input type="text" class="form-control search-query" placeholder="请输入电话号码" id="searchPhone">
                        <span class="input-group-btn" data-toggle="modal" data-target="#myModal" id="searchPhoneBtn">
											<button type="button" class="btn btn-purple btn-sm">
												查询
												<i class="ace-icon fa fa-search icon-on-right bigger-110"></i>
											</button>
										</span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-1 control-label" for="form-field-1">客户名称<span
                            class="required-star">*</span>：</label>
                    <div class="col-md-6">
                        <input type="text" id="form-field-1" name="clue.custName" class="input-sm form-control"
                               value="${clue.custName}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-1 control-label" for="form-field-1">客户地址<span
                            class="required-star">*</span>：</label>
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
                    <label class="col-md-1 control-label" for="form-field-1">详细地址：</label>
                    <div class="col-md-6">
                        <input type="text" id="form-field-2" class="input-sm form-control" name="clue.custAddr"
                               value="${clue.custAddr}">
                    </div>
                </div>

            </div>
            <div class="col-md-7" style="margin-top: 10px;">
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
                    <c:forEach items="${customerList}" var="c" varStatus="index">
                        <tr>
                            <td>${index.index +1}</td>
                            <td>
                                <select class="form-control" name="customerList[${index.index}].custRole">
                                    <c:forEach items="${roles}" var="r">
                                        <option value="${r.code}"
                                                <c:if test="${c.custRole == r.code}">selected</c:if>>${r.desc}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td><input type="text" class="form-control" name="customerList[${index.index}].custName"
                                       value="${c.custName}" placeholder="请输入姓名"></td>
                            <td><input type="text" class="form-control" name="customerList[${index.index}].custRole"
                                       value="${c.custJob}" placeholder="请输入职务"></td>
                            <td><input type="text" class="form-control" name="customerList[${index.index}].custPhone"
                                       value="${c.custPhone}" placeholder="请输入联系方式"></td>
                            <td><input type="text" class="form-control" name="customerList[${index.index}].custQq"
                                       value="${c.custQq}" placeholder="请输入QQ"></td>
                            <td><input type="text" class="form-control" name="customerList[${index.index}].custEmail"
                                       value="${c.custEmail}" placeholder="请输入邮箱"></td>
                            <input type="hidden" name="customerList[${index.index}].id" value="${c.id}">
                        </tr>
                    </c:forEach>
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
                        <label class="col-md-1 control-label" for="form-field-1">录入人：</label>
                        <div class="col-md-7">
                            <p class="form-control-static">${clue.adminName}</p>
                            <input type="hidden" name="clue.adminId" value="${clue.adminId}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-1 control-label" for="form-field-1">线索来源<span
                                class="required-star">*</span>：</label>
                        <div class="col-md-2">
                            <select class="input-sm form-control" name="clue.clueSource" id="clueSource">
                                <option value="">请选择</option>
                                <c:forEach items="${ClueSource}" var="c" varStatus="index">
                                    <option value="${c.code}"
                                            <c:if test="${clue.clueSource == c.code}">selected</c:if>>${c.desc}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-1 control-label" for="form-field-1">线索类型<span
                                class="required-star">*</span>：</label>
                        <div class="col-md-2">
                            <select class="input-sm form-control" name="clue.clueType" id="clueType">
                                <option value="">请选择</option>
                                <c:forEach items="${ClueType}" var="c" varStatus="index">
                                    <option value="${c.code}"
                                            <c:if test="${clue.clueType == c.code}">selected</c:if> >${c.desc}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-1 control-label" for="form-field-1">预购产品<span
                                class="required-star">*</span>：</label>
                        <div class="col-md-10">
                            <c:forEach items="${products}" var="c" varStatus="index">
                                <label class="checkbox-inline no-padding-left">
                                    <input name="productIds" type="checkbox" value="${c.id}" class="ace"
                                           <c:forEach items="${clueProducts}" var="cp">
                                           <c:if test="${c.id == cp.id}">checked</c:if>
                                    </c:forEach>>
                                    <span class="lbl">${c.productName}</span>
                                </label>

                            </c:forEach>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-1 control-label" for="form-field-1">关键字：</label>
                        <div class="col-md-5">
                            <input type="text" name="clue.clueKeyword" id="form-field-3" class="input-sm form-control"
                                   value="${clue.clueKeyword}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-1 control-label" for="form-field-1">备注：</label>
                        <div class="col-md-5">
                            <textarea id="form-field-11" class="input-sm form-control" name="clue.remark"
                                      style="overflow: hidden; word-wrap: break-word; resize: horizontal; height: 52px;">${clue.remark}</textarea>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div class="mt20">
            <div class="page-header">
                <h1>回访信息</h1>
            </div>
            <form role="form">
                <div class="form-group no-margin">
                    <label>添加回访内容</label>
                    <div class="row">
                        <div class="col-md-5">
                            <textarea class="form-control" rows="3" name="callback.callContent"></textarea>
                        </div>
                    </div>
                </div>
                <div class="form-group no-margin">
                    <label>下次回访时间</label>
                    <div class="input-group col-md-2">
                        <input type="text" data-date-format="dd-mm-yyyy" id="id-date-picker-1"
                               class="form-control date-picker" name="callback.callNextTime">
                        <span class="input-group-addon">
										<i class="fa fa-calendar bigger-110"></i>
									</span>
                    </div>
                </div>
                <div class="form-group no-margin">
                    <label>成交意向</label>
                    <div class="input-group">
                        <label class="checkbox-inline no-padding-left">
                            <input name="callBargainByte" type="radio" class="ace" value="1">
                            <span class="lbl">无人接听</span>
                        </label>
                        <label class="checkbox-inline no-padding-left">
                            <input name="callBargainByte" type="radio" class="ace" value="2">
                            <span class="lbl">长期跟进</span>
                        </label>
                        <label class="checkbox-inline no-padding-left">
                            <input name="callBargainByte" type="radio" class="ace" value="3">
                            <span class="lbl">短期跟进</span>
                        </label>
                        <label class="checkbox-inline no-padding-left">
                            <input name="callBargainByte" type="radio" class="ace" value="4">
                            <span class="lbl">不会成交</span>
                        </label>
                        <label class="checkbox-inline no-padding-left">
                            <input name="callBargainByte" type="radio" class="ace" value="5">
                            <span class="lbl">已成交</span>
                        </label>
                    </div>
                </div>
                <div class="visit_record">
                    <div class="widget-box transparent" id="recent-box">
                        <div class="widget-header">
                            <div class="widget-toolbar no-border">
                                <ul class="nav nav-tabs" id="recent-tab">
                                    <li class="active">
                                        <a data-toggle="tab" href="#task-tab">回访记录</a>
                                    </li>
                                    <li class="">
                                        <a data-toggle="tab" href="#member-tab">分配记录</a>
                                    </li>
                                    <li class="">
                                        <a data-toggle="tab" href="#comment-tab">操作记录</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="widget-body">
                            <div class="widget-main padding-4">
                                <div class="tab-content padding-8">
                                    <div id="task-tab" class="tab-pane active">
                                        <table id="vweddingTable1"
                                               class="table table-striped table-bordered table-hover dataTable ">
                                            <thead>
                                            <tr>
                                                <th>回访人</th>
                                                <th>回访时间</th>
                                                <th>成交意向</th>
                                                <th>下次回访时间</th>
                                                <th>回访内容</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${callbackList}" var="c" varStatus="index">
                                                <tr>
                                                    <td>${c.adminName}</td>
                                                    <td><fmt:formatDate value="${c.callTime}"
                                                                        pattern="yyyy-MM-dd"/></td>
                                                    <td>${c.callBargainStr}</td>
                                                    <td><fmt:formatDate value="${c.callNextTime}"
                                                                        pattern="yyyy-MM-dd"/></td>
                                                    <td>${c.callContent}</td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div id="member-tab" class="tab-pane">
                                        <c:forEach items="${allocationLogList}" var="c">
                                            <p class="muted"><fmt:formatDate value="${c.createTime}"
                                                                             pattern="yyyy年MM月dd日 HH:mm"/>
                                                由 ${c.alloAdminName} 分配给 ${c.alloOwnerName}</p>
                                        </c:forEach>
                                    </div>
                                    <div id="comment-tab" class="tab-pane">
                                        <table id="vweddingTable2"
                                               class="table table-striped table-bordered table-hover dataTable ">
                                            <thead>
                                            <tr>
                                                <th>操作时间</th>
                                                <th>操作人</th>
                                                <th>操作</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${optionLogList}" var="c" varStatus="index">
                                                <tr>
                                                    <td><fmt:formatDate value="${c.createTime}"
                                                                        pattern="yyyy-MM-dd HH:mm"/></td>
                                                    <td>${c.alloAdminName}</td>
                                                    <td>${c.optionStr}</td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <!-- 页面内容全部放大这里 结束 -->
    </div>
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
                            <table id="vweddingTableModel"
                                   class="table table-striped table-bordered table-hover dataTable ">
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
                        <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">取消</button>
                    </div>
                </form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div>
    <!--关闭-->
    <div class="modal fade" id="modal_close" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content"></div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div>
</form>
<!-- 返回顶部按钮 -->
<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
    <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
</a>
<!-- 返回顶部按钮 结束-->

<script src="/static/admin/js/area.js"></script>
<script src="/static/admin/js/crm/clue.js"></script>
<script type="application/javascript">
    Clue.setCustRoleJson(${rolesJson});
    Clue.init();
    //初始化加载省市县联动数据
    showLocationId('${clue.custProvince}', '${clue.custCity}', '${clue.custArea}', '#sheng', '#shi', '#qu');
    var msg = '${msg}';
    if (msg != undefined && msg != "") {
        $.tipshow({
            'msg': msg,
            'type': 'info',
            'ico': 'fa-check-circle-o'
        });
    }
</script>
</body>
</html>
