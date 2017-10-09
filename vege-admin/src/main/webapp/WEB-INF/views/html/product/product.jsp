<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>产品线管理</title>
</head>
<body class="no-skin">
<div class="page-content">
    <!-- 页面内容全部放大这里 -->
    <div class="row" style="height: 50px;">
        <div class="col-md-12">
            <a data-toggle="modal" data-target="#addProduct" class="btn btn-primary btn-sm btn-filter">添加产品</a>
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
                    <th>产品名称</th>
                    <th>产品类型</th>
                    <th>套餐数量</th>
                    <th>产品状态</th>
                    <th>添加时间</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="product" items="${productList}" varStatus="index">
                    <tr class="selected">
                        <td class="center">
                            <label class="position-relative">
                                <input type="checkbox" class="ace">
                                <span class="lbl"></span>
                            </label>
                        </td>
                        <td>${index.index+1}</td>
                        <td>${product.productName}</td>
                        <td>
                            <c:if test="${product.productType == 1}">
                                定制化产品
                            </c:if>
                            <c:if test="${product.productType == 0}">
                                标准产品
                            </c:if>
                        </td>
                        <td>${fn:length(product.versionList)}</td>
                        <td>
                            <c:if test="${product.productStatus == 1}">
                                正常
                            </c:if>
                            <c:if test="${product.productStatus == 0}">
                                冻结
                            </c:if>
                        </td>
                        <td><fmt:formatDate value="${product.createTime}" pattern="yyyy年MM月dd日 "/></td>
                        <td>
                            <a onclick="editProduct('${product.id}','${product.productName}');" data-toggle="modal"
                               data-target="#editProduct" class="mr20">编辑</a>
                            <c:if test="${product.productStatus == 1}">
                                <a href="/product/freezeProduct?id=${product.id}&productStatus=0" class="mr20">冻结</a>
                            </c:if>
                            <c:if test="${product.productStatus == 0}">
                                <a href="/product/freezeProduct?id=${product.id}&productStatus=1" class="mr20">解冻</a>
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
<!--添加产品弹窗-->
<div class="modal fade" id="addProduct" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">×
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    添加产品
                </h4>
            </div>
            <div class="modal-body">
                <form id="addProductForm" class="form-horizontal" role="form" method="post">
                    <div class="form-group">
                        <label class="col-md-1 control-label" style="width: 25%" for="form-field-1">产品类型<span
                                class="required-star">*</span>：</label>
                        <div class="col-md-9">
                            <input type="radio" name="productType" checked value="0">标准产品
                            <input type="radio" name="productType" value="1">定制化产品
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-1 control-label" style="width: 25%" for="form-field-1">产品名称<span
                                class="required-star">*</span>：</label>
                        <div class="col-md-9">
                            <input type="text" name="productName" class="col-xs-10 col-sm-5">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-1 control-label" style="width: 25%" for="form-field-1">标准版套餐名称<span
                                class="required-star">*</span>：</label>
                        <div class="col-md-9">
                            <input type="text" name="versName" class="col-xs-10 col-sm-5">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-1 control-label" style="width: 25%" for="form-field-1">标准金额<span
                                class="required-star">*</span>：</label>
                        <div class="col-md-9">
                            <input type="text" name="productPrice" class="col-xs-10 col-sm-5">
                            <span class="middle" style="margin-left: 5px;">请输入正确的数字格式，如有小数最多至小数点后两位</span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary btn-sm" onclick="savaProductAdd();">保存</button>
                <button type="button" class="btn btn-default btn-sm" data-dismiss="modal"
                        onclick="cancelSava('addProductForm');">取消
                </button>
            </div>
        </div>
    </div>
</div>
<!--编辑产品弹窗-->
<div class="modal fade" id="editProduct" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">×
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    编辑产品
                </h4>
            </div>
            <div class="modal-body">
                <form id="editProductForm" class="form-horizontal" role="form" method="post">
                    <input type="hidden" name="id" id="editProductId"/>
                    <div class="form-group">
                        <label class="col-md-1 control-label" style="width: 25%" for="form-field-1">产品名称<span
                                class="required-star">*</span>：</label>
                        <div class="col-md-9">
                            <input type="text" name="productName" id="editProductName" class="col-xs-10 col-sm-5">
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary btn-sm" onclick="savaProductUpdate();">保存</button>
                <button type="button" class="btn btn-default btn-sm" data-dismiss="modal"
                        onclick="cancelSava('editProduct');">取消
                </button>
            </div>
        </div>
    </div>
</div>
<script src="/static/admin/js/crm/product/product.js"></script>
</body>
</html>