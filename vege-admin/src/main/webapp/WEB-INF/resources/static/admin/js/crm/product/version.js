/**
 * 添加套餐保存按钮
 */
function savaVersionAdd() {
    if ($("select[name='prodId']").val() == null || $("select[name='prodId']").val() == "") {
        $("select[name='prodId']").focus();
        return;
    }
    if ($("input[name='versName']").val() == null || $("input[name='versName']").val() == "") {
        $("input[name='versName']").focus();
        return;
    }
    if ($("input[name='versPrice']").val() == null || $("input[name='versPrice']").val() == "") {
        $("input[name='versPrice']").focus();
        return;
    }
    if (checkNumber($("input[name='versPrice']").val())) {
        var action = "/product/addVersion";
        $('#addVersionForm').attr("action", action).submit();
    } else {
        $("input[name='versPrice']").focus();
    }
}

/**
 * 弹出窗取消按钮
 */
function cancelSava(formId) {
    $('#' + formId).find("input").val("");
    $('#' + formId).find("select").val("");
}

/**
 * 编辑套餐按钮
 * @param version_id
 * @param version_name
 * @param version_price
 */
function editVersion(version_id, version_name, version_price) {
    $('#editVersiontId').val(version_id);
    $('#editVersionName').val(version_name);
    $('#editVersionPrice').val(version_price);
}

/**
 * 编辑套餐保存按钮
 */
function savaVersionUpdate() {
    if ($("#editVersionName").val() == null || $("#editVersionName").val() == "") {
        $("#editVersionName").focus();
        return;
    }
    if (checkNumber($("#editVersionPrice").val())) {
        var action = "/product/updateVersion";
        $('#editVersionForm').attr("action", action).submit();
    } else {
        $("#editVersionPrice").focus();
    }

}