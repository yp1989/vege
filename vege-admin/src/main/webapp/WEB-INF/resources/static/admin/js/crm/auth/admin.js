

function savaAdmin() {
	var flag = true;
	$("#addAdminForm :input").each(function(){
		
		if($(this).val() == ""){
			$(this).focus();
			if($(this).css("display") == "block"){
				flag = false;
			}
			return false;
		}
	});
	
	if(flag  == true){
		var action="/auth/addAdminForm";
		$('#addAdminForm').attr("action", action).submit();
		
	}
	
}

function getBack() {
	var url="/auth/adminPage";
	window.location.href = url;
}

/**
 * 管理员条件查询按钮
 */
function queryAdmin() {
	$('#findForm').submit();;  
} 

/**
 * 编辑管理员按钮
 */
function editAdmin(id) {
	$.ajax({     
        type:'post',         
        url:'/auth/editAdminPage',
        dataType:'json',
        data:{id:id},
        success:function(data){  
        	setEditFormValue(data);
        },
        error: function() {
		}
    });   
	
}

function setEditFormValue(admin) {
	if(admin != null){
		$('#adminId').val(admin.id);
		$('#editAdminRealName').val(admin.adminRealName);
		$('#edit_role_id').val(admin.role_id);
	}
}

function savaEditAdmin() {
	if($("#editAdminRealName").val() == ""){
		$("#editAdminRealName").focus();
		return;
	}
	if($("#edit_role_id").val() == ""){
		$("#edit_role_id").focus();
		return;
	}
	var action="/auth/editAdminForm";
	$('#editAdminForm').attr("action", action).submit();;  
	
}
