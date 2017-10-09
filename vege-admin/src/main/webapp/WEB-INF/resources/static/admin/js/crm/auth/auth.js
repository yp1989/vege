/**
 * 权限、角色页面
 */
$(document).ready(function () {

    // 角色添加保存按钮
    $("#savaBtn").on("click", function () {
        var action = "/auth/addRoleForm";
        $('#addRoleForm').attr("action", action).submit();
        ;

    });

    // 角色保存并新增按钮
    $("#savaAddBtn").on("click", function () {
        $.ajax({
            type: 'post',
            url: '/auth/addRoleAjax',
            dataType: 'text',
            data: $('#addRoleForm').serialize(),
            success: function (data) {
                $("#reset").click();
            },
            error: function () {
            }
        });


    });
});