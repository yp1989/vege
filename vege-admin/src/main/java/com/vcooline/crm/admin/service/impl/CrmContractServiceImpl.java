package com.vcooline.crm.admin.service.impl;

import com.vcooline.crm.admin.service.*;
import com.vcooline.crm.common.enumutil.BusinessStatusEnum;
import com.vcooline.crm.common.enumutil.ContractStatusEnum;
import com.vcooline.crm.common.enumutil.ReleTypeEnum;
import com.vcooline.crm.common.mapper.*;
import com.vcooline.crm.common.model.*;
import com.vcooline.crm.common.pojo.ContractForm;
import com.vcooline.crm.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
@Service
public class CrmContractServiceImpl extends BaseService implements CrmContractService {

    @Autowired
    private CrmContractMapper crmContractMapper;

    @Autowired
    private CrmCustomerMapper crmCustomerMapper;

    @Autowired
    private CrmBusinessMapper crmBusinessMapper;

    @Autowired
    private CrmCustomerService customerService;

    @Autowired
    private CrmReleCustService releCustService;

    @Autowired
    private CrmReleVersionMapper releVersionMapper;

    @Autowired
    private CrmContProductService contProductService;

    @Autowired
    private CrmContractFileMapper contractFileMapper;

    /**
     * @return List<CrmContract>    返回类型
     * @throws
     * @Description:获取合同列表
     * @author caohuan
     * @date 2015年7月30日 下午2:45:57
     * 上海微客来软件技术有限公司
     */
    @Override
    public Page<CrmContract> getCrmContractList(Page<CrmContract> page, CrmContract contract) {

        Map<String, Object> params = new HashMap<>();
        CrmAdmin admin = getUser();
        if (admin != null) {
            if (admin.getRoleType() != null && admin.getRoleType() != 0 && admin.getRoleType() != 2) {
                if (admin.getIsDepManager() != null && admin.getIsDepManager() == 1) {
                    params.put("adminDep", admin.getAdminDep());
                    params.put("depManagerId", admin.getId());
                } else {
                    params.put("owner", admin.getId());
                }
            }

        } else {
            return page;
        }
        params.put("custName", contract.getCust());
        params.put("createStartTime", contract.getCreateStartTime());
        params.put("createEndTime", contract.getCreateEndTime());
        params.put("contStatus", contract.getContStatus());
        params.put("ownerName", contract.getOwnerName());
        if (contract.getVersionIds() != null && contract.getVersionIds().length > 0) {
            StringBuffer vers = new StringBuffer();
            for (int i = 0; i < contract.getVersionIds().length; i++) {
                if (i == contract.getVersionIds().length - 1) {
                    vers.append(contract.getVersionIds()[i]);
                } else {
                    vers.append(contract.getVersionIds()[i] + ",");
                }
            }
            params.put("versionIds", vers);
        }
        if (contract.getUncollected() != null) {
            int key = Integer.parseInt(String.valueOf(contract.getUncollected()));
            switch (key) {
                case 1:
                    params.put("contStartUncollected", 0);
                    break;

                case 2:
                    params.put("contStartUncollected", 0);
                    params.put("contEndUncollected", 50000);
                    break;

                case 3:
                    params.put("contStartUncollected", 50000);
                    params.put("contEndUncollected", 100000);
                    break;

                case 4:
                    params.put("contStartUncollected", 100000);
                    break;

                default:
                    break;
            }
        }

        params.put("contType", contract.getContType());
        page.setParams(params);

        List<CrmContract> contractList = crmContractMapper.getCrmContractListPage(page);
        if (contractList != null) {
            page.setResults(contractList);
        }

        return page;
    }

    /**
     * @param contract
     * @return int    返回类型
     * @throws
     * @Description:新增合同
     * @author caohuan
     * @date 2015年7月30日 上午11:19:18
     * 上海微客来软件技术有限公司
     */
    @Override
    public int insertContract(CrmContract contract) {
        if (contract != null) {
            //合同关联的套餐和联系人
            if (contract.getCustomerList() != null && contract.getVersionList() != null) {
                Integer num_code = crmContractMapper.selectMaxNumber();
                if (num_code != null) {
                    contract.setContNumber(StringUtils.generateContactNumber(num_code + 1));
                    contract.setNumCode((num_code + 1));
                } else {
                    contract.setContNumber(StringUtils.generateContactNumber(1));
                    contract.setNumCode(1);
                }
                Date date = new Date();
                contract.setIsDel(false);
                contract.setUpdateTime(date);
                contract.setCreateTime(date);
                //新增合同
                crmContractMapper.insertSelective(contract);

                //添加修改联系人信息
                for (CrmCustomer customer : contract.getCustomerList()) {
                    if (customer.getId() != null) {
                        customer.setUpdateTime(date);

                        //修改联系人
                        crmCustomerMapper.updateByPrimaryKeySelective(customer);
                    } else {
                        customer.setIsDel(false);
                        customer.setCreateTime(date);
                        customer.setUpdateTime(date);

                        //新增联系人
                        crmCustomerMapper.insertSelective(customer);
                    }
                }


            }
        }
        return 0;
    }

    /**
     * @param id
     * @return CrmContract    返回类型
     * @throws
     * @Description:根据id获取合同详细信息
     * @author caohuan
     * @date 2015年8月3日 上午10:31:22
     * 上海微客来软件技术有限公司
     */
    @Override
    public CrmContract selectContractInfoById(Long id) {
        CrmContract contract = crmContractMapper.selectContractInfoById(id);
        return contract;
    }

    /**
     * @param contract
     * @return int    返回类型
     * @throws
     * @Description:修改合同
     * @author caohuan
     * @date 2015年8月3日 上午11:28:04
     * 上海微客来软件技术有限公司
     */
    public int updateContractById(CrmContract contract) {
        if (contract != null && contract.getId() != null) {
            Date date = new Date();
            contract.setUpdateTime(date);
            //判断合同要操作的状态
            if ("4".equals(String.valueOf(contract.getContStatus()))) {
                contract.setContStatus(ContractStatusEnum.CANCEL.getCode());
                CrmBusiness busi = new CrmBusiness();
                busi.setId(contract.getBusiId());
                busi.setUpdateTime(date);
                busi.setReturnChangeRemark(contract.getReturnChangeRemark());
                busi.setBusiStatus(BusinessStatusEnum.RETURN_CHANGE.getCode());
                crmBusinessMapper.updateByPrimaryKeySelective(busi);
            }
            return crmContractMapper.updateByPrimaryKeySelective(contract);
        }
        return 0;
    }

    @Override
    public Boolean saveContract(ContractForm form) {
        boolean result = true;
        try {
            if (form.getContract() != null) {
                //合同关联的套餐和联系人
                Integer num_code = crmContractMapper.selectMaxNumber();
                if (num_code != null) {
                    form.getContract().setContNumber(StringUtils.generateContactNumber(num_code + 1));
                    form.getContract().setNumCode(num_code + 1);
                } else {
                    form.getContract().setContNumber(StringUtils.generateContactNumber(1));
                    form.getContract().setNumCode(1);
                }
                Date date = new Date();
                form.getContract().setIsDel(false);
                form.getContract().setUpdateTime(date);
                form.getContract().setCreateTime(date);
                form.getContract().setContStatus(ContractStatusEnum.AUDIT.getCode());
                form.getContract().setContSigntime(new Date());
                form.getContract().setContReceivable(form.getContReceivable());
                //新增合同
                crmContractMapper.insertSelective(form.getContract());
                //保存客户联系人信息
                for (CrmCustomer customer : form.getCustomerList()) {
                    if (customer.getId() == null) {
                        customerService.insertSelective(customer);
                        //保存线索 客户联系人关联表
                        CrmReleCust clueCust = new CrmReleCust();
                        clueCust.setTargetId(form.getContract().getId());
                        clueCust.setCustId(customer.getId());
                        clueCust.setReleType(ReleTypeEnum.CONTRACT.getCode());
                        clueCust.setCreateTime(new Date());
                        releCustService.insertSelective(clueCust);
                    } else {
                        customer.setUpdateTime(new Date());
                        customerService.updateByPrimaryKeySelective(customer);
                    }
                }
                CrmReleVersion releVersion = null;
                for (String id : form.getVersionIds().split(",")) {
                    releVersion = new CrmReleVersion();
                    releVersion.setReleType(ReleTypeEnum.CONTRACT.getCode());
                    releVersion.setReleId(form.getContract().getId());
                    releVersion.setVersionId(Long.parseLong(id));
                    releVersion.setCreateTime(new Date());
                    releVersion.setUpdateTime(new Date());
                    releVersionMapper.insertSelective(releVersion);
                }
                //保存套餐
                if (form.getContProducts() != null) {
                    for (CrmContProduct crmContProduct : form.getContProducts()) {
                        if (crmContProduct.getProdId() == null) {
                            continue;
                        }
                        if (crmContProduct.getId() == null) {
                            crmContProduct.setContId(form.getContract().getId());
                            crmContProduct.setIsDel(false);
                            crmContProduct.setCreateTime(new Date());
                            crmContProduct.setUpdateTime(new Date());
                            contProductService.insertSelective(crmContProduct);
                        } else {
                            crmContProduct.setUpdateTime(new Date());
                            contProductService.updateByPrimaryKeySelective(crmContProduct);
                        }
                    }
                }
                //保存附件信息
                if (form.getContractFileList() != null && !form.getContractFileList().isEmpty()) {
                    for (CrmContractFile file : form.getContractFileList()) {
                        file.setTargetId(form.getContract().getId());
                        contractFileMapper.insertSelective(file);
                    }
                }
                //商机修改为已关闭
                CrmBusiness business = new CrmBusiness();
                business.setId(form.getContract().getBusiId());
                business.setBusiStatus(BusinessStatusEnum.CREATE_CONTRACT.getCode());
                crmBusinessMapper.updateByPrimaryKeySelective(business);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    @Override
    public List<CrmContract> selectContractByNumber(String contNumber) {
        return crmContractMapper.selectContractByNumber(contNumber);
    }

    @Override
    public List<String> getContractName(String contNumber) {
        List<CrmContract> list = selectContractByNumber(contNumber);
        List<String> names = new ArrayList<>();
        for (CrmContract contract : list) {
            names.add(contract.getContNumber());
        }
        return names;
    }

    @Override
    public CrmContract getContractByNumber(String contNumber) {
        return crmContractMapper.getContractByNumber(contNumber);
    }

    @Override
    public CrmContract selectByPrimaryKey(Long id) {
        return crmContractMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CrmContract record) {
        return crmContractMapper.updateByPrimaryKeySelective(record);
    }
}
