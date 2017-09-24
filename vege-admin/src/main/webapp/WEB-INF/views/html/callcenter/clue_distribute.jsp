<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" 
       aria-hidden="true">×
    </button>
    <h4 class="modal-title" id="myModalLabel">
       线索分配
    </h4>
</div>
<div class="modal-body">
    <form class="form-horizontal lead_distribute" role="form" action="">
        <div class="form-group">
            <label class="col-md-3 control-label" for="form-field-1">归属人：</label>
            <div class="col-md-6">
                <select class="input-sm form-control" name="clue.owner" id="form-field-1">
                    <option value="">请选择归属人</option>
                    <c:forEach items="${adminList}" var="c" varStatus="index">
                        <option value="${c.id}">${c.adminRealName}</option>
                    </c:forEach>
                </select>
                <input type="hidden" name="clue.ownerName" id="id_ownerName" value="">
                <input type="hidden" name="clue.id" value="${clueId}">
            </div>
        </div>
    </form>
</div>
<div class="modal-footer">
    <button type="button" class="btn btn-primary btn-sm">保存</button>
    <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">取消</button>
</div>
<script type="text/javascript">
    $('body').on('change', '#form-field-1', function() {
            var val = $("#form-field-1").val();
            var value = $('#form-field-1 option[value="'+val+'"]').text();
            $("#id_ownerName").val(value);
        })
</script>