/**
 * js表单验证工具类 
 *@author caohuan
 *@date 2015/8/10
 */

/**
 * 验证是否为数字类型
 * @param number
 */
function checkNumber(number) {
	var userreg=/^[0-9]+([.]{1}[0-9]{1,2})?$/; 

	if(userreg.test(number)){
		return true;
	}
	
	return false;
}