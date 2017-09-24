
/**
 * 添加产品保存按钮
 */
function savaProductAdd() {
	if($("input[name='productName']").val() ==null || $("input[name='productName']").val() == ""){
		$("input[name='productName']").focus();
		return;
	}
	if($("input[name='versName']").val() ==null || $("input[name='versName']").val() == ""){
		$("input[name='versName']").focus();
		return;
	}
	if($("input[name='productPrice']").val() ==null || $("input[name='productPrice']").val() == ""){
		$("input[name='productPrice']").focus();
		return;
	}
	if(checkNumber($("input[name='productPrice']").val())){
		var action="/product/addProduct";
		$('#addProductForm').attr("action", action).submit(); 
	}else{
		$("input[name='productPrice']").focus();
	}
	
}

/**
 * 弹出窗取消按钮
 */
function cancelSava(formId) {
	$('#'+formId).find("input").val("");
}

/**
 * 编辑产品按钮
 * @param product_id
 */
function editProduct(product_id,product_name) {
	$('#editProductId').val(product_id);
	$('#editProductName').val(product_name);
}

function savaProductUpdate() {
	if($("#editProductName").val() ==null || $("#editProductName").val() == ""){
		$("#editProductName").focus();
		return;
	}
	var action="/product/updateProduct";
	$('#editProductForm').attr("action", action).submit();
}