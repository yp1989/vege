package com.vcooline.crm.admin.service;


import com.vcooline.crm.common.exception.ServiceProcessException;
import com.vcooline.crm.common.model.CrmAdmin;
import com.vcooline.crm.common.model.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 管理员接口类service
 *
 * @author caohuan
 * @ClassName: CrmLoginService
 * @date 2015年7月16日 上午9:26:55
 * 上海微客来软件技术有限公司
 */
public interface CrmAdminService {

    /**
     * @param adminName     用户名
     * @param adminPassword 密码
     * @return void    返回类型
     * @Description:用户登录接口
     * @author caohuan
     * @date 2015年7月16日 上午9:35:21
     * 上海微客来软件技术有限公司
     */
    String adminLogin(CrmAdmin admin) throws ServiceProcessException;

    /**
     * 新增用户
     *
     * @param record
     * @return
     */
    int insertSelective(CrmAdmin record);

    List<CrmAdmin> getOwerList(@Param("admin") CrmAdmin admin);

    /**
     * @return List<CrmAdmin>    返回类型
     * @Description:获取管理员列表
     * @author caohuan
     * @date 2015年7月16日 上午9:35:21
     * 上海微客来软件技术有限公司
     */
    Page<CrmAdmin> getAdminList(Page<CrmAdmin> page, CrmAdmin admin);

    /**
     * @param adminDep 部门id
     * @return List<CrmAdmin>    返回类型
     * @Description:根据部门id获取管理员列表
     * @author caohuan
     * @date 2015年7月16日 上午9:35:21
     * 上海微客来软件技术有限公司
     */
    Page<CrmAdmin> selectByAdminDep(Page<CrmAdmin> page, String adminDep);

    /**
     * @param admin
     * @return int    返回类型
     * @throws
     * @Description:移动管理员
     * @author caohuan
     * @date 2015年7月23日 上午11:44:41
     * 上海微客来软件技术有限公司
     */
    void moveAdmin(CrmAdmin admin);

    /**
     * @param @param  id
     * @param @return 设定文件
     * @return CrmAdmin    返回类型
     * @throws
     * @Description:根据管理员id获取管理员
     * @author caohuan
     * @date 2015年7月27日 上午11:51:30
     * 上海微客来软件技术有限公司
     */
    CrmAdmin selectAdminById(Long id);

    /**
     * @return int    返回类型
     * @throws
     * @Description:修改管理员
     * @author caohuan
     * @date 2015年7月27日 下午1:22:15
     * 上海微客来软件技术有限公司
     */
    int updateAdminById(CrmAdmin admin);

    /**
     * @param admin
     * @return int    返回类型
     * @throws
     * @Description:根据id修改管理员状态
     * @author caohuan
     * @date 2015年7月27日 下午2:03:47
     * 上海微客来软件技术有限公司
     */
    int updateAdminStatusById(CrmAdmin admin);


    /**
     * @param admin
     * @return int    返回类型
     * @throws
     * @Description:设置部门管理员
     * @author caohuan
     * @date 2015年7月27日 下午2:29:47
     * 上海微客来软件技术有限公司
     */
    int setIsDepManager(CrmAdmin admin);

    /**
     * @param adminPassword
     * @return CrmAdmin    返回类型
     * @throws
     * @Description:验证密码是否有效
     * @author caohuan
     * @date 2015年7月29日 上午9:46:10
     * 上海微客来软件技术有限公司
     */
    Boolean checkPassword(String adminPassword);

    /**
     * @param admin
     * @return int    返回类型
     * @throws
     * @Description:保存修改的密码
     * @author caohuan
     * @date 2015年7月29日 上午10:50:27
     * 上海微客来软件技术有限公司
     */
    int savaUpdatePassword(CrmAdmin admin);

    /**
     * 根据真实邢敏查询用户(暂不考虑姓名重复)
     *
     * @param adminRealName
     * @return
     * @author baojianxin
     */
    CrmAdmin selectAdminByRealName(String adminRealName);
}
