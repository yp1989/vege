package com.vcooline.crm.admin.service.impl;

import com.vcooline.crm.admin.service.BaseService;
import com.vcooline.crm.admin.service.CrmProductService;
import com.vcooline.crm.admin.service.CrmProductVersionService;
import com.vcooline.crm.common.mapper.CrmProductMapper;
import com.vcooline.crm.common.mapper.CrmProductVersionMapper;
import com.vcooline.crm.common.model.CrmProduct;
import com.vcooline.crm.common.model.CrmProductVersion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by xinbaojian on 15/7/17.
 */
@Transactional
@Service
public class CrmProductServiceImpl extends BaseService implements CrmProductService {

    @Autowired
    private CrmProductMapper productMapper;

    @Autowired
    private CrmProductVersionService versionService;

    @Autowired
    private CrmProductVersionMapper versionMapper;
    
    /**
	  * @Description:获取产品界面的列表（包含套餐信息）
	  * @return List<CrmProduct>    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年7月29日 下午5:20:01
	  * 上海微客来软件技术有限公司
	 */
    @Override
    public List<CrmProduct> getProductList(){
    	return productMapper.getProductList();
	}
    
    @Override
    public int deleteByPrimaryKey(Long id) {
        return productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CrmProduct record) {
        return productMapper.insert(record);
    }

    @Override
    public int insertSelective(CrmProduct product) {
    	if(product != null){
    		if(product.getProductName() != null && product.getVersName() != null){
    			Date date = new Date();
    			product.setProductPrice(product.getProductPrice());
    			product.setProductStatus((byte)1);
    			product.setIsDel(false);
    			product.setCreateTime(date);
    			product.setUpdateTime(date);
    			//新增产品
    			productMapper.insertSelective(product);
    			//新增标准套餐
    			if(product.getId() != null){
    				CrmProductVersion vers = new CrmProductVersion();
    				vers.setProdId(product.getId());
    				vers.setVersName(product.getVersName());
    				vers.setVersPrice(product.getProductPrice());
    				vers.setVersStatus((byte)1);
    				vers.setIsDel(false);
    				vers.setCreateTime(date);
    				vers.setUpdateTime(date);
    				versionMapper.insertSelective(vers);
    			}
    		}
    	}
        return 0;
    }

    @Override
    public CrmProduct selectByPrimaryKey(Long id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CrmProduct product) {
    	if(product != null && product.getId() != null){
    		product.setUpdateTime(new Date());
    		productMapper.updateByPrimaryKeySelective(product);
    	}
        return 0;
    }

    @Override
    public int updateByPrimaryKey(CrmProduct record) {
        return productMapper.updateByPrimaryKey(record);
    }

    /**
     * 根据相关参数查询产品
     *
     * @param record
     * @return
     */
    @Override
    public List<CrmProduct> selectByParam(CrmProduct record) {
        return productMapper.selectByParam(record);
    }

    /**
     * 获取所有有效的产品信息
     *
     * @return
     */
    @Override
    public List<CrmProduct> getAllProduct() {
        CrmProduct record = new CrmProduct();
        record.setProductStatus((byte)1);
        record.setIsDel(false);
        return selectByParam(record);
    }

    @Override
    public List<CrmProduct> getAllProductAndVersions() {
        List<CrmProduct> productList = getAllProduct();
        for (CrmProduct product : productList) {
            product.setVersionList(versionService.getListByProdId(product.getId()));
        }
        return productList;
    }

    /**
     * 根据线索Id查询预购产品
     *
     * @param clueId
     * @return
     */
    @Override
    public List<CrmProduct> getProductsByClueId(Long clueId) {
        List<CrmProduct> list = productMapper.getProductsByClueId(clueId);
        return list;
    }
    
    /**
     * @Description:获取有效的产品（即状态为正常的且未删除的）
     * @return List<CrmProduct>    返回类型
     * @throws
     * @author caohuan
     * @date 2015年7月29日 下午4:05:42
     * 上海微客来软件技术有限公司
    */
    @Override
    public List<CrmProduct> getValidVersionList(){
	   return productMapper.getValidVersionList();
   }

    @Override
    public List<CrmProduct> getProductsByBusiId(Long busiId) {
        List<CrmProduct> productList = productMapper.getProductsByBusiId(busiId);
        return productList;
    }
}
