package com.vcooline.crm.admin.service;

import com.vcooline.crm.common.model.CrmAuth;

import java.util.List;

/**
 * 权限管理接口类
 *
 * @author caohuan
 * @ClassName: CrmAuthService
 * @date 2015年7月16日 上午9:45:32
 * 上海微客来软件技术有限公司
 */
public interface CrmAuthService {

    /**
     * @return List<CrmAuth>  权限List
     * @throws
     * @Description:查询系统所有权限
     * @author caohuan
     * @date 2015年7月16日 上午9:48:28
     * 上海微客来软件技术有限公司
     */
    List<CrmAuth> getAuthList();

    /**
     * @param auth 权限对象
     * @return void 返回类型
     * @throws
     * @Description:新增权限
     * @author caohuan
     * @date 2015年7月16日 上午9:50:21
     * 上海微客来软件技术有限公司
     */
    void addAuth(CrmAuth auth);
}
