

/**
 * 验证旧密码
 */
function checkPassword() {
	var adminPassword = $("#oldPassword").val();
	if(adminPassword != null && $.trim(adminPassword) != ""){
		$.ajax({     
	        type:'post',         
	        url:'/checkPassword?adminPassword='+adminPassword,
	        dataType:'text',
	        success:function(data){ 
	        	if(data != null){
	        		if(data == "true"){
	        			$('#checkPasswordSpan').html("");
	        			$('#newPassword').attr("disabled",false);
	        			$('#surePassword').attr("disabled",false);
	        		}else{
	        			$('#checkPasswordSpan').html("输入的密码不正确");
	        			$('#newPassword').val("").attr("disabled",true);
	        			$('#surePassword').val("").attr("disabled",true);
	        		}
	        	}
	        }     
	    });    
	}
	
} 

/**
 * 修改密码保存按钮
 */
function sava() {
	var newPassword = $('#newPassword').val();
	var surePassword = $('#surePassword').val();
	if($('#newPassword').val() == null || $('#newPassword').val().length < 6){
		$('#newPassword').focus();
		return;
	}
	if($('#surePassword').val() == null || $('#surePassword').val().length < 6){
		$('#surePassword').focus();
		return;
	}
	if(newPassword != null && $.trim(newPassword) != ""){
		if(newPassword == surePassword){
			var action="/savaUpdatePassword";
			$('#updatePasswordForm').attr("action", action).submit(); 
		}else{
			$('#surePasswordSpan').show();
		}
	}
	
}