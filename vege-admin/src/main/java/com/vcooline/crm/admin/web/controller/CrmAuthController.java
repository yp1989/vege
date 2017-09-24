package com.vcooline.crm.admin.web.controller;

import com.vcooline.crm.admin.service.impl.CrmAdminServiceImpl;
import com.vcooline.crm.admin.service.impl.CrmAuthServiceImpl;
import com.vcooline.crm.admin.service.impl.CrmDepServiceImpl;
import com.vcooline.crm.admin.service.impl.CrmRoleServiceImpl;
import com.vcooline.crm.common.model.*;
import com.vcooline.crm.common.util.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

 /**
   * 权限管理controller
   * @ClassName: CrmAuthController
   * @author caohuan
   * @date 2015年7月16日 下午5:04:16
   * 上海微客来软件技术有限公司
  */
@Controller
@RequestMapping("auth")
public class CrmAuthController extends BaseController{ 
	@Autowired
	private CrmAuthServiceImpl crmAuthServiceImpl;
	
	@Autowired
	private CrmRoleServiceImpl crmRoleServiceImpl;
	 
	@Autowired
	private CrmAdminServiceImpl crmAdminServiceImpl;
	
	@Autowired
	private CrmDepServiceImpl crmDepServiceImpl;
	
	@RequestMapping("authJsp")
	public String authJsp(CrmAuth auth,Model model){
		List<CrmRole> roleList = crmRoleServiceImpl.getRoleList();
		model.addAttribute("roleList", roleList);
		return "html/auth/role";
	}
	
	/**
	  * @Description:获取权限列表
	  * @return List<CrmAuth>    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月21日 上午9:48:57
	  * 上海微客来软件技术有限公司
	 */
	@RequestMapping("getAuthList")
	@ResponseBody
	public List<CrmAuth> getAuth(){
		List<CrmAuth> authList = crmAuthServiceImpl.getAuthList();
		return authList;
	}
	
	/**
	  * @Description:新增权限
	  * @param @param auth
	  * @param @param request
	  * @param @return    设定文件
	  * @return String    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月21日 上午9:50:18
	  * 上海微客来软件技术有限公司
	 */
	@RequestMapping("addAuthForm")
	public String addAuth(CrmAuth auth,HttpServletRequest request){
		crmAuthServiceImpl.addAuth(auth);
		return "index";
	}
	
	
	
	
	/*************角色管理模块****************************************************************/
	
	/**
	  * @Description:跳转到角色添加页面
	  * @throws
	  * @author caohuan
	  * @date 2015年7月20日 下午4:44:27
	  * 上海微客来软件技术有限公司
	 */
	
	@RequestMapping("addRolePage")
	public String addRolePage(Model model){
		List<CrmAuth> authList = crmAuthServiceImpl.getAuthList();
		model.addAttribute("authList", authList);
		return "html/auth/roleAdd";
	}
	
	/**
	  * @Description:根据id获取角色信息
	  * @param @return    设定文件
	  * @return String    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月27日 下午4:32:26
	  * 上海微客来软件技术有限公司
	 */
	@ResponseBody
	@RequestMapping("getRoleById")
	public CrmRole getRoleById(Long id){
		CrmRole role = crmRoleServiceImpl.getRoleById(id);
		return role;
	}
	
	/**
	  * @Description:新增角色(同步函数)
	  * @param  role
	  * @param  model
	  * @return String    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月21日 上午9:51:36
	  * 上海微客来软件技术有限公司
	 */
	@RequestMapping("addRoleForm")
	public String addRoleForm(CrmRole role,Model model){
		try {
			crmRoleServiceImpl.addRole(role);
		} catch (Exception e) {
			logger.info("新增角色接口："+e.getMessage());
		}
		return "redirect:/auth/roleJsp";
	}

	/**
	  * @Description:新增角色(ajax异步函数)
	  * @param     设定文件
	  * @return void    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月21日 下午1:49:08
	  * 上海微客来软件技术有限公司
	 */
	@ResponseBody
	@RequestMapping("addRoleAjax")
	public String addRoleAjax(CrmRole role){
		try {
			crmRoleServiceImpl.addRole(role);
		} catch (Exception e) {
			logger.info("异步新增角色接口："+e.getMessage());
		}
		return "0";
	}
	
	@RequestMapping("editRoleForm")
	public String editRoleForm(CrmRole role){
		try {
			crmRoleServiceImpl.updateRole(role);
		} catch (Exception e) {
			logger.info("修改角色接口："+e.getMessage());
		}
		return "redirect:/auth/roleJsp";
	}
	
	/**
	  * @Description:删除角色
	  * @param @return    设定文件
	  * @return String    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月28日 上午11:34:13
	  * 上海微客来软件技术有限公司
	 */
	@ResponseBody
	@RequestMapping("deleteRole")
	public String deleteRole(Long id){
		try {
			crmRoleServiceImpl.deleteRole(id);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return e.getMessage();
		}
		return "0";
	}
	/**
	  * @Description:跳转到角色管理页面
	  * @param @param model
	  * @param @return    设定文件
	  * @return String    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月21日 上午9:52:19
	  * 上海微客来软件技术有限公司
	 */
	@RequestMapping("roleJsp")
	public String roleJsp(Model model) {
		List<CrmRole> roleList = crmRoleServiceImpl.getRoleList();
		List<CrmAuth> authList = crmAuthServiceImpl.getAuthList();
		model.addAttribute("authList", authList);
		model.addAttribute("roleList", roleList);
		return "html/auth/role";
	}
	
	/*********************************管理员**********************************************/
	
	/**
	  * @Description:管理员管理界面
	  * @param @param admin
	  * @param @param model
	  * @param @return    设定文件
	  * @return String    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月22日 上午9:54:34
	  * 上海微客来软件技术有限公司
	 */
	@RequestMapping("adminPage")
	public String adminPage(CrmAdmin admin,Model model,Integer pageNo,Integer pageSize){
		Page<CrmAdmin> page = new Page<CrmAdmin>();
		
		if(pageNo != null){
			page.setPageNo(pageNo);
		}
		if(pageSize != null){
			page.setPageSize(pageSize);
		}
		page = crmAdminServiceImpl.getAdminList(page,admin);
		List<CrmRole> roleList = crmRoleServiceImpl.getRoleList();
		model.addAttribute("page", page);
		model.addAttribute("roleList", roleList);
		model.addAttribute("admin",admin);
		return "html/auth/admin";
	}
	
	/**
	  * @Description:新增管理员界面
	  * @param @param model
	  * @param @return    设定文件
	  * @return String    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月22日 上午9:55:10
	  * 上海微客来软件技术有限公司
	 */
	@RequestMapping("addAdminPage")
	public String addAdminPage(Model model){
		List<CrmRole> roleList = crmRoleServiceImpl.getRoleList();
		List<CrmDep> depList = crmDepServiceImpl.getDepList();
		model.addAttribute("roleList", roleList);
		model.addAttribute("depList", depList);
		return "html/auth/adminAdd";
	}
	
	/**
	  * @Description:新增管理员
	  * @param @param admin
	  * @param @return    设定文件
	  * @return String    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月22日 上午10:37:07
	  * 上海微客来软件技术有限公司
	 */
	@RequestMapping("addAdminForm")
	public String addAdminForm(CrmAdmin admin){
		crmAdminServiceImpl.insertSelective(admin);
		return "redirect:/auth/adminPage";
	}
	
	/**
	  * @Description:修改管理员界面
	  * @param  id
	  * @return String    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月27日 上午11:53:56
	  * 上海微客来软件技术有限公司
	 */
	@ResponseBody
	@RequestMapping("editAdminPage")
	public CrmAdmin editAdminPage(Long id){
		CrmAdmin admin = this.crmAdminServiceImpl.selectAdminById(id);
		return admin;
	}
	
	/**
	  * @Description:修改管理员
	  * @param @param admin
	  * @return String    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月27日 下午1:20:39
	  * 上海微客来软件技术有限公司
	 */
	@RequestMapping("editAdminForm")
	public String editAdminForm(CrmAdmin admin){
		this.crmAdminServiceImpl.updateAdminById(admin);
		return "redirect:/auth/adminPage";
	}
	
	/**
	  * @Description:根据管理员id修改管理员状态
	  * @param admin
	  * @param @return    设定文件
	  * @return String    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月27日 下午2:01:12
	  * 上海微客来软件技术有限公司
	 */
	@RequestMapping("closeAdmin")
	public String closeAdmin(CrmAdmin admin){
		this.crmAdminServiceImpl.updateAdminStatusById(admin);
		return "redirect:/auth/adminPage";
	}
	/***********************部门管理******************************************/
	
	@RequestMapping("depPage")
	public String depPage(Model model,String adminDep,Integer pageNo,Integer pageSize){
		Page<CrmAdmin> page = new Page<CrmAdmin>();
		if(pageNo != null){
			page.setPageNo(pageNo);
		}
		if(pageSize != null){
			page.setPageSize(pageSize);
		}
		
		List<CrmDep> depList = crmDepServiceImpl.getDepList();
		if(adminDep != null && !"".equals(adminDep)){
			page = crmAdminServiceImpl.selectByAdminDep(page, adminDep);
		}else{
			if(depList != null && depList.size() != 0){
				page = crmAdminServiceImpl.selectByAdminDep(page, String.valueOf(depList.get(0).getId()));//String.valueOf(depList.get(0).getId())
			}
			
		}
		
		model.addAttribute("page", page);
		model.addAttribute("depList", depList);
		return "html/auth/dep";
	}
	
	@ResponseBody
	@RequestMapping("getAdminByDep")
	public Page<CrmAdmin> getAdminByDep(String adminDep,Integer pageNo,Integer pageSize){
		Page<CrmAdmin> page = new Page<CrmAdmin>();
		page = crmAdminServiceImpl.selectByAdminDep(page, adminDep);
		return page;
	}
	
	@ResponseBody
	@RequestMapping("getTreeDepList")
	public List<Tree> getTreeDepList(Long id){
		List<Tree> depList = crmDepServiceImpl.getTreeDepList(id);
		//System.out.println(JSONObject.toJSONString(depList));
		return depList; 
	} 
	
	/**
	  * @Description:移动管理员
	  * @param @param adminId
	  * @param @param adminDep
	  * @return String    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月23日 上午11:54:35
	  * 上海微客来软件技术有限公司
	 */
	@RequestMapping("moveAdmin")
	public String moveAdmin(Long adminId,Long adminDep){
		CrmAdmin admin = new CrmAdmin();
		admin.setId(adminId);
		admin.setAdminDep(adminDep);
		crmAdminServiceImpl.moveAdmin(admin);
		return "redirect:/auth/depPage";
	}

	/**
	  * @Description:新增部门
	  * @param  dep
	  * @return String    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月24日 下午2:07:09
	  * 上海微客来软件技术有限公司
	 */
	@ResponseBody
	@RequestMapping("savaAddDep")
	public CrmDep savaAddDep(CrmDep dep){
		dep = this.crmDepServiceImpl.addDep(dep);
		return dep;
	}
	
	/**
	  * @Description:修改部门
	  * @param  dep
	  * @return String  返回类型
	  * @author caohuan
	  * @date 2015年7月24日 下午2:07:09
	  * 上海微客来软件技术有限公司
	 */
	@ResponseBody
	@RequestMapping("savaUpdateDep")
	public String savaUpdateDep(CrmDep dep){
		int count = this.crmDepServiceImpl.updateDep(dep);
		return String.valueOf(count);
	}
	
	/**
	  * @Description:删除部门
	  * @param  id
	  * @return String    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月24日 下午3:51:15
	  * 上海微客来软件技术有限公司
	 */
	@ResponseBody
	@RequestMapping("deleteDep")
	public String deleteDep(Long id){
		int count = crmDepServiceImpl.deleteDep(id);
		return String.valueOf(count);
	}
	
	/**
	  * @Description:设置部门管理员
	  * @param @param admin
	  * @param @return    设定文件
	  * @return String    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月27日 下午2:40:20
	  * 上海微客来软件技术有限公司
	 */
	@ResponseBody
	@RequestMapping("setIsDepManager")
	public String setIsDepManager(CrmAdmin admin){
		crmAdminServiceImpl.setIsDepManager(admin);
		return "0";
	}
	
}
