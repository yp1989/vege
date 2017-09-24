package com.vcooline.crm.admin.service;

import java.util.List;


import com.vcooline.crm.common.model.CrmAuth;

/**
  * 权限管理接口类
  * @ClassName: CrmAuthService
  * @author caohuan
  * @date 2015年7月16日 上午9:45:32
  * 上海微客来软件技术有限公司
 */
public interface CrmAuthService {

	/**
	  * @Description:查询系统所有权限
	  * @return List<CrmAuth>  权限List
	  * @throws
	  * @author caohuan
	  * @date 2015年7月16日 上午9:48:28
	  * 上海微客来软件技术有限公司
	 */
	List<CrmAuth> getAuthList();
	
	/**
	  * @Description:新增权限
	  * @param auth  权限对象
	  * @return void 返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月16日 上午9:50:21
	  * 上海微客来软件技术有限公司
	 */
	void addAuth(CrmAuth auth);
}
