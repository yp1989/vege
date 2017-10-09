<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="form-inline">
    <div class="form-group">
        <ul class="pagination">
            <c:set value="10" var="pageLen"/>
            <fmt:formatNumber type="number" value="${((page.pageNo-1)-(page.pageNo-1)%pageLen)/pageLen}"
                              var="pageIndex"/>
            <c:choose>
                <c:when test="${page.totalPage > 1}">
                    <c:if test="${page.pageNo != 1}">
                        <li><a href="javascript:" onclick="paging(1)">首页</a></li>
                        <li><a href="javascript:" onclick="paging(${page.pageNo - 1})">上一页</a></li>
                    </c:if>
                    <c:set var="lastPageNo" value="${pageLen*(pageIndex+1)}"/>
                    <c:forEach var="p" begin="${pageLen*pageIndex + 1}"
                               end="${lastPageNo gt page.totalPage ? page.totalPage:lastPageNo}" step="1">
                        <c:choose>
                            <c:when test="${p == page.pageNo}">
                                <li class="active"><a href="javascript:">${p}<span class="sr-only">(current)</span></a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="javascript:" onclick="paging(${p})">${p}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${page.pageNo != page.totalPage}">
                        <li><a href="javascript:" onclick="paging(${page.pageNo + 1})">下一页</a></li>
                        <li><a href="javascript:" onclick="paging(${page.totalPage})">尾页</a></li>
                    </c:if>
                </c:when>
                <c:otherwise>
                    <li class="active"><a href="#">1<span class="sr-only">(current)</span></a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
    <div class="form-group margin-left-10">共 ${page.totalPage} 页 第</div>
    <div class="form-group font-size-0">
        <div class="form-group has-error">
            <label for="pagination-input" class="sr-only">pagination-input</label>
            <input type="text" class="form-control vcard-input-page" id="pagination-input" value="${page.pageNo}">
        </div>
        <div class="form-group">
            <button id="goPage" class="btn btn-danger vcard-btn-page btn-sm">GO</button>
        </div>
    </div>
    <div class="form-group">页</div>
</div>

<script>
    function paging(pageNo) {
        $('#pageNo').val(pageNo);
        $('#findForm').submit();
    }

    $('#goPage').click(function () {
        var pageNo = $('#pagination-input').val();
        if (isNaN(parseInt(pageNo))) {
            pageNo = 1;
        } else {
            pageNo = parseInt(pageNo);
        }

        paging(pageNo);
    });
    $("#findForm :input").on("change", function () {
        $("#pageNo").val('1');
    });
</script>