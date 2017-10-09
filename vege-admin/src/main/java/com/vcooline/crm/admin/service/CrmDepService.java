package com.vcooline.crm.admin.service;

import com.vcooline.crm.common.model.CrmDep;
import com.vcooline.crm.common.util.Tree;

import java.util.List;

/**
 * 部门接口service
 *
 * @author caohuan
 * @ClassName: CrmDepService
 * @date 2015年7月17日 上午10:41:48
 * 上海微客来软件技术有限公司
 */
public interface CrmDepService {

    /**
     * @return List<CrmDep>    返回类型
     * @throws
     * @Description:获取部门列表
     * @author caohuan
     * @date 2015年7月17日 上午10:45:24
     * 上海微客来软件技术有限公司
     */
    List<CrmDep> getDepList();

    /**
     * @param @return 设定文件
     * @return List<CrmDep>    返回类型
     * @throws
     * @Description:获取树状部门数据
     * @author caohuan
     * @date 2015年7月23日 下午3:42:35
     * 上海微客来软件技术有限公司
     */
    List<Tree> getTreeDepList(Long id);

    /**
     * @param dep 部门对象
     * @return 返回类型
     * @throws
     * @Description:新增部门
     * @author caohuan
     * @date 2015年7月17日 上午10:46:02
     * 上海微客来软件技术有限公司
     */
    CrmDep addDep(CrmDep dep);

    /**
     * @param dep
     * @return int 返回类型 0失败
     * @throws
     * @Description:修改部门信息
     * @author caohuan
     * @date 2015年7月17日 上午10:47:18
     * 上海微客来软件技术有限公司
     */
    int updateDep(CrmDep dep);

    /**
     * @param depList
     * @param 设定文件
     * @return int 返回类型 0 失败
     * @throws
     * @Description:删除部门，支持批量删除
     * @author caohuan
     * @date 2015年7月17日 上午10:48:18
     * 上海微客来软件技术有限公司
     */
    int deleteDep(Long id);

}
