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
    <title>生成代理合同</title>
    <meta name="description" content="overview &amp; stats"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
    <!-- css样式表异步加载 在/layout/stylesheets.html内 -->
</head>

<body class="no-skin">
<div class="page-content">
    <!-- 页面内容全部放大这里 -->
    <div class="row">
        <div class="col-md-12">
            <div class="tabbable">
                <div class="tab-content no-border padding-24">
                    <div class="tab-pane fade active in">
                        <form class="form-horizontal" role="form" action="/business/doProductsContract" method="post"
                              enctype="multipart/form-data">
                            <input type="hidden" name="contract.busiId" value="${busiId}"/>
                            <input type="hidden" name="contract.contType" value="1"/>
                            <div class="form-group">
                                <label class="col-md-1 control-label">签约时间：</label>
                                <div class="col-md-7">
                                    <p class="form-control-static"><fmt:formatDate value="${currentDate}"
                                                                                   pattern="yyyy-MM-dd"/></p>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-1 control-label">客户名称：</label>
                                <div class="col-md-7">
                                    <p class="form-control-static">${clue.custName}</p>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-1 control-label">录入人：</label>
                                <div class="col-md-7">
                                    <p class="form-control-static">${business.adminName}</p>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-1 control-label">客户地址<span class="required-star">*</span>：</label>
                                <div class="col-md-2">
                                    <select class="input-sm form-control" name="" id="sheng">
                                        <option value="">省</option>
                                        <option value="">上海</option>
                                        <option value="">北京</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    <select class="input-sm form-control" name="" id="shi">
                                        <option value="">市</option>
                                        <option value="">上海</option>
                                        <option value="">北京</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    <select class="input-sm form-control" name="" id="qu">
                                        <option value="">区</option>
                                        <option value="">上海</option>
                                        <option value="">北京</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-1 control-label">详细地址<span class="required-star">*</span>：</label>
                                <div class="col-md-8">
                                    <input type="text" class="input-sm form-control" value="${clue.custAddr}">
                                </div>
                            </div>
                            <c:forEach items="${customerList}" var="c" varStatus="index">
                                <div class="form-group">
                                    <label class="col-md-1 control-label">联系人<span
                                            class="required-star">*</span>：</label>
                                    <div class="col-md-2">
                                        <input type="text" class="input-sm form-control"
                                               name="customerList[${index.index}].custName" value="${c.custName}">
                                    </div>
                                    <label class="col-md-1 control-label">电话<span
                                            class="required-star">*</span>：</label>
                                    <div class="col-md-2">
                                        <input type="text" class="input-sm form-control"
                                               name="customerList[${index.index}].custPhone" value="${c.custPhone}">
                                    </div>
                                    <label class="col-md-1 control-label">邮件<span
                                            class="required-star">*</span>：</label>
                                    <div class="col-md-2">
                                        <input type="text" class="input-sm form-control"
                                               name="customerList[${index.index}].custEmail" value="${c.custEmail}">
                                    </div>
                                </div>
                            </c:forEach>
                            <div class="form-group">
                                <div class="col-md-4">
                                    <label class="col-md-3 control-label">服务级别<span
                                            class="required-star">*</span>：</label>
                                    <div class="col-md-9">
                                        <select class="input-sm form-control" name="contract.contServiceLevel"
                                                id="serviceLevel">
                                            <option value="">请选择</option>
                                            <c:forEach items="${serviceLevel}" var="c" varStatus="index">
                                                <option value="${c.code}">${c.desc}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <label class="col-md-3 control-label">类别<span
                                            class="required-star">*</span>：</label>
                                    <div class="col-md-9">
                                        <select class="input-sm form-control" name="contract.contCategory"
                                                id="agentCategory">
                                            <option value="">请选择</option>
                                            <c:forEach items="${category}" var="c" varStatus="index">
                                                <option value="${c.code}">${c.desc}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-4">
                                    <label class="col-md-3 control-label">代理商级别<span
                                            class="required-star">*</span>：</label>
                                    <div class="col-md-9">
                                        <select class="input-sm form-control" name="contract.agentLevel"
                                                id="agentLevel">
                                            <option value="">请选择</option>
                                            <c:forEach items="${agentLevel}" var="c" varStatus="index">
                                                <option value="${c.code}">${c.desc}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-1 control-label">购买产品<span class="required-star">*</span>：</label>
                                <div class="col-md-10">
                                    <c:forEach items="${productList}" var="p">
                                        <label class="checkbox-inline no-padding-left">
                                            <input name="versionIds" type="checkbox" class="ace agentCheckbox"
                                                   data-price="${p.productPrice}" value="${p.id}"
                                                   <c:forEach items="${business.productList}" var="bp">
                                                   <c:if test="${p.id == bp.id}">checked</c:if>
                                            </c:forEach> >
                                            <span class="lbl">${p.productName}</span>
                                        </label>
                                    </c:forEach>
                                    <div class="form_group pb10">
                                        <p class="form-control-static"></p>
                                    </div>
                                    <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                                        <thead>
                                        <tr>
                                            <th>代理产品</th>
                                            <th>金额</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${business.productList}" var="bp" varStatus="index">
                                            <tr class="selectedagent" data-v-id="${bp.id}">
                                                <td>${bp.productName}<input type="hidden"
                                                                            name="contProducts[${index.index}].prodId"
                                                                            value="${bp.id}"/>
                                                </td>
                                                <td class="Standard_amount">${bp.productPrice}<input type="hidden"
                                                                                                     name="contProducts[${index.index}].actualAmount"
                                                                                                     value="${bp.productPrice}"/>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        <tr class="heji">
                                            <td>合计</td>
                                            <td class="Standard_amount">0</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-1 control-label">合同文件<span class="required-star">*</span>：</label>
                                <div class="col-md-2">
                                    <div class="file-btn">
                                        <input type="file" name="file" value="">
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-1 control-label"></label>
                                <div class="col-md-2">
                                    <div class="file-btn">
                                        <button type="button" class="btn btn-sm btn-primary" data-fn="submit"
                                                id="add_new_contract_file">新增合同文件
                                        </button>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-1 control-label">备注：</label>
                                <div class="col-md-5">
                                    <textarea id="form-field-11" class="autosize-transition form-control"
                                              name="contract.contRemark"
                                              style="overflow: hidden; word-wrap: break-word; resize: horizontal; height: 52px;"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-5">
                                    <button type="button" class="btn btn-sm btn-primary" data-fn="submit"
                                            id="product_contract_submit">保存
                                    </button>
                                    <button type="button" class="btn btn-sm btn-default" data-dismiss="modals">取消
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 页面内容全部放大这里 结束 -->
</div>
</div>
<!-- 异步加载footer -->
<div class="footer"></div>
<!-- 异步加载footer 结束-->
<!-- 返回顶部按钮 -->
<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
    <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
</a>
<!-- 返回顶部按钮 结束-->
</div>

<script src="/static/admin/js/area.js"></script>
<script src="/static/admin/js/crm/package.js"></script>
<script type="application/javascript">
    //初始化加载省市县联动数据
    Package.init();
    Package.calculationAgentTotal();
    showLocationId('${clue.custProvince}', '${clue.custCity}', '${clue.custArea}', '#sheng', '#shi', '#qu');
    var msg = '${msg}';
    if (msg != undefined && msg != "") {
        $.getNormalMessage(msg);
    }
</script>
</body>
</html>
