package com.vcooline.crm.admin.service;

import com.vcooline.crm.common.model.CrmContract;
import com.vcooline.crm.common.model.Page;
import com.vcooline.crm.common.pojo.ContractForm;

import java.util.List;

public interface CrmContractService {

    /**
     * @return List<CrmContract>    返回类型
     * @throws
     * @Description:获取合同列表
     * @author caohuan
     * @date 2015年7月30日 下午2:45:57
     * 上海微客来软件技术有限公司
     */
    Page<CrmContract> getCrmContractList(Page<CrmContract> page, CrmContract contract);

    /**
     * @param contract
     * @return int    返回类型
     * @throws
     * @Description:新增合同
     * @author caohuan
     * @date 2015年7月30日 上午11:19:18
     * 上海微客来软件技术有限公司
     */
    int insertContract(CrmContract contract);

    /**
     * @param id
     * @return CrmContract    返回类型
     * @throws
     * @Description:根据id获取合同详细信息
     * @author caohuan
     * @date 2015年8月3日 上午10:31:22
     * 上海微客来软件技术有限公司
     */
    CrmContract selectContractInfoById(Long id);

    /**
     * @param contract
     * @return int    返回类型
     * @throws
     * @Description:修改合同
     * @author caohuan
     * @date 2015年8月3日 上午11:28:04
     * 上海微客来软件技术有限公司
     */
    int updateContractById(CrmContract contract);

    /**
     * 生成合同
     *
     * @param form
     * @return
     */
    Boolean saveContract(ContractForm form);

    /**
     * 根据合同编号查询
     *
     * @param contNumber
     * @return
     */
    List<CrmContract> selectContractByNumber(String contNumber);


    /**
     * 得到合同编号列表
     *
     * @param contNumber
     * @return
     */
    List<String> getContractName(String contNumber);

    CrmContract getContractByNumber(String contNumber);

    CrmContract selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CrmContract record);
}
