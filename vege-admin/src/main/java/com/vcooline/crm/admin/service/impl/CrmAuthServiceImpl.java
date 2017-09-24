package com.vcooline.crm.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vcooline.crm.admin.service.CrmAuthService;
import com.vcooline.crm.common.mapper.CrmAuthMapper;
import com.vcooline.crm.common.model.CrmAuth;
import com.vcooline.crm.common.util.TreeUtil;
@Transactional
@Service
public class CrmAuthServiceImpl implements CrmAuthService{

	@Autowired
	private CrmAuthMapper crmAuthMapper;
	
	/**
	  * @Description:查询系统所有权限
	  * @return List<CrmAuth>  权限List
	  * @throws
	  * @author caohuan
	  * @date 2015年7月16日 上午9:48:28
	  * 上海微客来软件技术有限公司
	 */
	@Override
	public List<CrmAuth> getAuthList() {
		List<CrmAuth> authList = crmAuthMapper.getAllAuthList();
		if(authList != null && authList.size() != 0){
			authList = TreeUtil.createTree(authList);
		}
		return authList;
	}

	/**
	  * @Description:新增权限
	  * @param auth  权限对象
	  * @return void 返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月16日 上午9:50:21
	  * 上海微客来软件技术有限公司
	 */
	@Override
	public void addAuth(CrmAuth auth) {
		if(auth != null && !"".equals(auth.getAuthName())){
			auth.setIsDel(false);
			auth.setCreateTime(new Date());
			auth.setUpdateTime(new Date());
			crmAuthMapper.insertSelective(auth);
		}
		
	}

}
