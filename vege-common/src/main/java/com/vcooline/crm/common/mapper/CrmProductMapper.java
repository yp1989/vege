package com.vcooline.crm.common.mapper;

import com.vcooline.crm.common.model.CrmProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CrmProductMapper {
    /**
     * @return List<CrmProduct>    返回类型
     * @throws
     * @Description:产品列表界面集合（包含套餐信息）
     * @author caohuan
     * @date 2015年7月29日 下午5:17:51
     * 上海微客来软件技术有限公司
     */
    List<CrmProduct> getProductList();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_product
     *
     * @mbggenerated Thu Jul 16 15:20:21 CST 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_product
     *
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    int insert(CrmProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_product
     *
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    int insertSelective(CrmProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_product
     *
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    CrmProduct selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_product
     *
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    int updateByPrimaryKeySelective(CrmProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_product
     *
     * @mbggenerated Thu Jul 16 15:20:22 CST 2015
     */
    int updateByPrimaryKey(CrmProduct record);

    /**
     * 根据相关参数查询产品
     *
     * @param record
     * @return
     */
    List<CrmProduct> selectByParam(CrmProduct record);

    /**
     * 根据线索Id查询预购产品
     *
     * @param clueId
     * @return
     */
    List<CrmProduct> getProductsByClueId(Long clueId);

    /**
     * 根据商机Id查询预购产品
     *
     * @param busiId
     * @return
     */
    List<CrmProduct> getProductsByBusiId(@Param("busiId") Long busiId);

    /**
     * @return List<CrmProduct>    返回类型
     * @throws
     * @Description:获取有效的产品（即状态为正常的且未删除的）
     * @author caohuan
     * @date 2015年7月29日 下午4:05:42
     * 上海微客来软件技术有限公司
     */
    List<CrmProduct> getValidVersionList();
}