package com.vcooline.crm.admin.web.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vcooline.crm.admin.service.impl.CrmProductServiceImpl;
import com.vcooline.crm.admin.service.impl.CrmProductVersionServiceImpl;
import com.vcooline.crm.admin.web.controller.BaseController;
import com.vcooline.crm.common.model.CrmProduct;
import com.vcooline.crm.common.model.CrmProductVersion;

@RequestMapping("product")
@Controller
public class CrmProductController extends BaseController {
	
	@Autowired
	private CrmProductServiceImpl crmProductServiceImpl;

	@Autowired
	private CrmProductVersionServiceImpl crmProductVersionServiceImpl;
	/**
	  * @Description:产品线管理界面
	  * @return String    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月29日 下午1:34:06
	  * 上海微客来软件技术有限公司
	 */
	@RequestMapping("productPage")
	public String productPage(Model model){
		List<CrmProduct> productList = crmProductServiceImpl.getProductList();
		model.addAttribute("productList", productList);
		return "html/product/product";
	}
	
	/**
	  * @Description:添加产品
	  * @param  product
	  * @return String    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月29日 下午2:34:38
	  * 上海微客来软件技术有限公司
	 */
	@RequestMapping("addProduct")
	public String addProduct(CrmProduct product){
		crmProductServiceImpl.insertSelective(product);
		return "redirect:/product/productPage";
	}
	
	/**
	  * @Description:修改产品
	  * @param product
	  * @return String    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月29日 下午2:38:12
	  * 上海微客来软件技术有限公司
	 */
	@RequestMapping("updateProduct")
	public String updateProduct(CrmProduct product){
		crmProductServiceImpl.updateByPrimaryKeySelective(product);
		return "redirect:/product/productPage";
	}
	
	/**
	  * @Description:冻结产品
	  * @param product
	  * @return String    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月29日 下午2:38:12
	  * 上海微客来软件技术有限公司
	 */
	@RequestMapping("freezeProduct")
	public String freezeProduct(CrmProduct product){
		crmProductServiceImpl.updateByPrimaryKeySelective(product);
		return "redirect:/product/productPage";
	}
	
	/**************************套餐管理*****************************************************/
	
	@RequestMapping("versionPage")
	public String versionPage(Model model){ 
		model.addAttribute("versionList", crmProductVersionServiceImpl.getVersionList());
		model.addAttribute("productList", crmProductServiceImpl.getValidVersionList());
		return "html/product/version";
	}
	
	/**
	  * @Description:新增套餐
	  * @param  Version
	  * @return String    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月29日 下午4:25:09
	  * 上海微客来软件技术有限公司
	 */
	@RequestMapping("addVersion")
	public String addVersion(CrmProductVersion Version){
		crmProductVersionServiceImpl.insertSelective(Version);
		return "redirect:/product/versionPage";
	}
	
	/**
	  * @Description:修改套餐
	  * @param  Version
	  * @return String    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月29日 下午4:34:55
	  * 上海微客来软件技术有限公司
	 */
	@RequestMapping("updateVersion")
	public String updateVersion(CrmProductVersion Version){
		crmProductVersionServiceImpl.updateByPrimaryKeySelective(Version);
		return "redirect:/product/versionPage";
	}
	
	/**
	  * @Description:冻结套餐
	  * @param Version
	  * @return String    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月29日 下午2:38:12
	  * 上海微客来软件技术有限公司
	 */
	@RequestMapping("freezeVersion")
	public String freezeVersion(CrmProductVersion Version){
		crmProductVersionServiceImpl.updateByPrimaryKeySelective(Version);
		return "redirect:/product/versionPage";
	}
}
