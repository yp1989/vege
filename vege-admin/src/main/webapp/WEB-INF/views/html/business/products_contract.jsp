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
    <title>生成产品合同</title>
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
                            <input type="hidden" name="contract.contType" value="2"/>
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
                                <label class="col-md-1 control-label">购买产品<span class="required-star">*</span>：</label>
                                <div class="col-md-10">
                                    <c:forEach items="${productList}" var="p">
                                        <div class="form_group pb10">
                                            <p class="form-control-static">${p.productName}</p>
                                            <c:forEach items="${p.versionList}" var="v">
                                                <label class="checkbox-inline no-padding-left">
                                                    <input name="versionIds" type="checkbox" class="ace products"
                                                           value="${v.id}" data-productType="${p.productType}"
                                                           data-pro-id="${p.id}" data-standardAmount="${v.versPrice}"
                                                           data-name="${v.versName}"
                                                           <c:forEach items="${business.productVersionList}" var="bp">
                                                           <c:if test="${v.id == bp.id}">checked</c:if>
                                                    </c:forEach> >
                                                    <span class="lbl">${v.versName}</span>
                                                </label>
                                            </c:forEach>
                                        </div>
                                    </c:forEach>
                                    <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                                        <thead>
                                        <tr>
                                            <th>购买套餐</th>
                                            <th>数量</th>
                                            <th>标准单价</th>
                                            <th>实际金额</th>
                                            <th>总人天（数量）</th>
                                            <th>人天单价</th>
                                            <th>折扣</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${business.productVersionList}" var="bp" varStatus="index">
                                            <tr class="selected" data-v-id="${bp.id}">
                                                <td>${bp.versName}
                                                    <input type="hidden" name="contProducts[${index.index}].prodId"
                                                           value="${bp.prodId}"/>
                                                    <input type="hidden" name="contProducts[${index.index}].versId"
                                                           value="${bp.id}"/>
                                                </td>
                                                <td class="count_num"><input type="text"
                                                                             name="contProducts[${index.index}].buyCount"
                                                                             class="col-xs-10 col-sm-5" value=""></td>
                                                <td class="Standard_amount">${bp.versPrice}<input type="hidden"
                                                                                                  name=""/></td>
                                                <td class="Actual_amount"><input type="text"
                                                                                 name="contProducts[${index.index}].actualAmount"
                                                                                 class="col-xs-10 col-sm-5" value="">
                                                </td>
                                                <td class="zong_ren_tian"><input type="text"
                                                                                 name="contProducts[${index.index}].sumMenday"
                                                                                 class="col-xs-10 col-sm-5" value="">
                                                </td>
                                                <td class="ren_tian_dan_jian"><input type="text"
                                                                                     name="contProducts[${index.index}].priceMenday"
                                                                                     class="col-xs-10 col-sm-5"
                                                                                     value=""></td>
                                                <td class="Discount"><input type="text"
                                                                            name="contProducts[${index.index}].prodDiscount"
                                                                            class="col-xs-10 col-sm-5" value=""></td>
                                            </tr>
                                        </c:forEach>
                                        <tr class="heji">
                                            <td>合计</td>
                                            <td class="count_num">0</td>
                                            <td class="Standard_amount">0</td>
                                            <td class="Actual_amount">0<input type="hidden"
                                                                              name="contract.contReceivable" value=""/>
                                            </td>
                                            <td class="zong_ren_tian"></td>
                                            <td class="ren_tian_dan_jian"></td>
                                            <td class="Discount"></td>
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
    showLocationId('${clue.custProvince}', '${clue.custCity}', '${clue.custArea}', '#sheng', '#shi', '#qu');
    var msg = '${msg}';
    if (msg != undefined && msg != "") {
        $.getNormalMessage(msg);
    }
</script>
</body>
</html>
