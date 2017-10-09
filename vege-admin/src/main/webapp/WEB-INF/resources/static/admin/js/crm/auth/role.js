/**
 * 跳转到编辑角色页面
 * @param id
 */
function editRole(id) {
    $.ajax({
        type: 'post',
        url: '/auth/getRoleById?id=' + id,
        dataType: 'json',
        success: function (role) {
            if (role != null) {
                setRoleValue(role);
            }
        }
    });
}

function setRoleValue(role) {
    $("#editRoleId").val(role.id);
    $("#editRoleName").val(role.roleName);
    $("#editRoleDesc").val(role.roleDesc);
    if (role.authRoleList != null) {
        $.each(role.authRoleList, function (i, auth) {
            $("input[name='authIdArray']").each(function () {
                if (auth.authId == $(this).val()) {
                    $(this).attr("checked", "checked");
                }
            });

        })


    }
    //$('input:checkbox').attr('checked', false);

}

function savaEditAdmin() {
    var action = "/auth/editRoleForm";
    $('#editRoleForm').attr("action", action).submit();
    ;
}

function cancelSava() {
    var url = "/auth/roleJsp";
    window.location.href = url;

}

function deleteRole(id) {
    $.ajax({
        type: 'post',
        url: '/auth/deleteRole?id=' + id,
        dataType: 'text',
        success: function (data) {
            if (data != null) {
                if (data == "0") {
                    var url = "/auth/roleJsp";
                    window.location.href = url;
                } else {
                    alert(data);
                }
            }
        }
    });
}