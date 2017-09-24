package com.vcooline.crm.admin.service;


import com.vcooline.crm.common.exception.ServiceProcessException;
import com.vcooline.crm.common.model.CrmAdmin;
import com.vcooline.crm.common.model.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
  * 管理员接口类service
  * @ClassName: CrmLoginService
  * @author caohuan
  * @date 2015年7月16日 上午9:26:55
  * 上海微客来软件技术有限公司
 */
public interface CrmAdminService {

	/**
	  * @Description:用户登录接口
	  * @param  adminName 用户名
	  * @param  adminPassword   密码
	  * @return void    返回类型
	  * @author caohuan
	  * @date 2015年7月16日 上午9:35:21
	  * 上海微客来软件技术有限公司
	 */
	String adminLogin(CrmAdmin admin) throws ServiceProcessException;

	/**
	 * 新增用户
	 * @param record
	 * @return
	 */
	int insertSelective(CrmAdmin record);

	List<CrmAdmin> getOwerList(@Param("admin") CrmAdmin admin);
	
	/**
	  * @Description:获取管理员列表
	  * @return List<CrmAdmin>    返回类型
	  * @author caohuan
	  * @date 2015年7月16日 上午9:35:21
	  * 上海微客来软件技术有限公司
	 */
	Page<CrmAdmin> getAdminList(Page<CrmAdmin> page,CrmAdmin admin);
	
	/**
	  * @Description:根据部门id获取管理员列表
	  * @param adminDep 部门id
	  * @return List<CrmAdmin>    返回类型
	  * @author caohuan
	  * @date 2015年7月16日 上午9:35:21
	  * 上海微客来软件技术有限公司
	 */
	Page<CrmAdmin> selectByAdminDep(Page<CrmAdmin> page,String adminDep);
	
	/**
	  * @Description:移动管理员
	  * @param  admin
	  * @return int    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月23日 上午11:44:41
	  * 上海微客来软件技术有限公司
	 */
	void moveAdmin(CrmAdmin admin);
	
	/**
	  * @Description:根据管理员id获取管理员
	  * @param @param id
	  * @param @return    设定文件
	  * @return CrmAdmin    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月27日 上午11:51:30
	  * 上海微客来软件技术有限公司
	 */
	CrmAdmin selectAdminById(Long id);
	
	/**
     * 
      * @Description:修改管理员
      * @return int    返回类型
      * @throws
      * @author caohuan
      * @date 2015年7月27日 下午1:22:15
      * 上海微客来软件技术有限公司
     */
    int updateAdminById(CrmAdmin admin);
    
    /**
      * @Description:根据id修改管理员状态
      * @param admin   
      * @return int    返回类型
      * @throws
      * @author caohuan
      * @date 2015年7月27日 下午2:03:47
      * 上海微客来软件技术有限公司
     */
    int updateAdminStatusById(CrmAdmin admin);
    

    /**
      * @Description:设置部门管理员
      * @param admin    
      * @return int    返回类型
      * @throws
      * @author caohuan
      * @date 2015年7月27日 下午2:29:47
      * 上海微客来软件技术有限公司
     */
	int setIsDepManager(CrmAdmin admin);
	
	/**
	  * @Description:验证密码是否有效
	  * @param  adminPassword
	  * @return CrmAdmin    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月29日 上午9:46:10
	  * 上海微客来软件技术有限公司
	 */
	Boolean checkPassword(String adminPassword);
	
	/**
	  * @Description:保存修改的密码
	  * @param  admin
	  * @return int    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月29日 上午10:50:27
	  * 上海微客来软件技术有限公司
	 */
	int savaUpdatePassword(CrmAdmin admin);

	/**
	 * 根据真实邢敏查询用户(暂不考虑姓名重复)
	 * @param adminRealName
	 * @author baojianxin
	 * @return
	 */
	CrmAdmin selectAdminByRealName(String adminRealName);
}
