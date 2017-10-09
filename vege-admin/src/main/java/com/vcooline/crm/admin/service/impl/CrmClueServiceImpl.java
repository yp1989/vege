package com.vcooline.crm.admin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.vcooline.crm.admin.service.*;
import com.vcooline.crm.common.enumutil.ClueStatusEnum;
import com.vcooline.crm.common.enumutil.DealintentionEnum;
import com.vcooline.crm.common.enumutil.OptionTypeEnum;
import com.vcooline.crm.common.enumutil.ReleTypeEnum;
import com.vcooline.crm.common.mapper.CrmClueMapper;
import com.vcooline.crm.common.model.*;
import com.vcooline.crm.common.pojo.ClueAddForm;
import com.vcooline.crm.common.utils.DateUtil;
import com.vcooline.crm.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 线索业务实现类
 * Created by xinbaojian on 15/7/17.
 */
@Transactional
@Service
public class CrmClueServiceImpl extends BaseService implements CrmClueService {

    @Autowired
    private CrmClueMapper crmClueMapper;

    @Autowired
    private CrmCustomerService customerService;

    @Autowired
    private CrmReleCustService clueCustService;

    @Autowired
    private CrmClueProductService clueProductService;

    @Autowired
    private CrmCallbackService callbackService;

    @Autowired
    private CrmOptionLogService optionLogService;

    @Autowired
    private CrmProductService productService;

    @Autowired
    private CrmAdminService adminService;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return crmClueMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CrmClue record) {
        if (record.getCreateTime() != null) {
            record.setCreateTimeLong(DateUtil.getTime(record.getCreateTime()));
        }
        return crmClueMapper.insert(record);
    }

    @Override
    public int insertSelective(CrmClue record) {
        if (record.getCreateTime() != null) {
            record.setCreateTimeLong(DateUtil.getTime(record.getCreateTime()));
        }
        return crmClueMapper.insertSelective(record);
    }

    @Override
    public CrmClue selectByPrimaryKey(Long id) {
        return crmClueMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CrmClue record) {
        return crmClueMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CrmClue record) {
        return crmClueMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer getMaxNumCode() {
        Integer numCode = crmClueMapper.getMaxNumCode();
        if (numCode == null)
            numCode = 0;
        Integer num = numCode + 1;
        return num;
    }

    /**
     * 保存线索
     *
     * @param form
     */
    @Override
    public Boolean saveClue(ClueAddForm form) {
        //完善线索信息
        CrmAdmin admin = getUser();
        try {
            Integer numCode = getMaxNumCode();
            form.getClue().setNumCode(numCode);
            form.getClue().setClueNumber(StringUtils.generateClueNumber(numCode));
            form.getClue().setCreateTime(new Date());

            form.getClue().setAdminId(admin.getId());
            form.getClue().setAdminName(admin.getAdminRealName());
            if (form.getIsAllot()) {
                form.getClue().setOwner(admin.getId());
                form.getClue().setOwnerName(admin.getAdminRealName());
                form.getClue().setClueStatusOnline(ClueStatusEnum.ALLOCATED.getCode());
                form.getClue().setAllotTime(new Date());
            }
            int clueResult = 0;

            if (form.getClue().getId() == null) {
                clueResult = insertSelective(form.getClue());//保存线索
            } else {
                clueResult = updateByPrimaryKeySelective(form.getClue());//更新线索
            }
            if (clueResult == 1) {
                //保存客户联系人信息
                for (CrmCustomer customer : form.getCustomerList()) {
                    if (customer.getId() == null) {
                        customerService.insertSelective(customer);
                        //保存线索 客户联系人关联表
                        CrmReleCust clueCust = new CrmReleCust();
                        clueCust.setTargetId(form.getClue().getId());
                        clueCust.setCustId(customer.getId());
                        clueCust.setReleType(ReleTypeEnum.CLUE_TYPE.getCode());
                        clueCust.setCreateTime(new Date());
                        clueCustService.insertSelective(clueCust);
                    } else {
                        customerService.updateByPrimaryKeySelective(customer);
                    }
                }
                //保存产品信息begin
                for (Long aLong : form.getProductIds()) {
                    CrmClueProduct product = clueProductService.selectByPrimaryKey(aLong);
                    if (product == null) {
                        CrmClueProduct clueProduct = new CrmClueProduct();
                        clueProduct.setClueId(form.getClue().getId());
                        clueProduct.setProductId(aLong);
                        clueProductService.insertSelective(clueProduct);
                    } else {
                        clueProductService.deleteByPrimaryKey(aLong);
                    }

                }
                //保存产品信息end

                //保存回访信息begin 导入接口时会用到
                if (form.getCallback() != null && form.getCallback().getCallBargain() != null) {
                    form.getCallback().setTargetId(form.getClue().getId());
                    form.getCallback().setReleType(ReleTypeEnum.CLUE_TYPE.getCode());
                    form.getCallback().setAdminId(admin.getId());
                    form.getCallback().setCallTime(new Date());
                    form.getCallback().setCreateTime(new Date());
                    callbackService.insertSelective(form.getCallback());
                }
                //保存回访信息end
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return false;
        }
    }

    /**
     * 保存线索
     *
     * @param form
     */
    @Override
    public Boolean saveClueImport(ClueAddForm form, CrmAdmin admin) {
        //完善线索信息
        try {
            Integer numCode = getMaxNumCode();
            form.getClue().setNumCode(numCode);
            form.getClue().setClueNumber(StringUtils.generateClueNumber(numCode));

            form.getClue().setAdminId(admin.getId());
            form.getClue().setAdminName(admin.getAdminRealName());
            if (form.getIsAllot()) {
                form.getClue().setOwner(admin.getId());
                form.getClue().setOwnerName(admin.getAdminRealName());
                form.getClue().setClueStatusOnline(ClueStatusEnum.ALLOCATED.getCode());
                form.getClue().setAllotTime(new Date());
            }
            int clueResult = 0;

            if (form.getClue().getId() == null) {
                clueResult = insertSelective(form.getClue());//保存线索
            } else {
                clueResult = updateByPrimaryKeySelective(form.getClue());//更新线索
            }
            if (clueResult == 1) {
                //保存客户联系人信息
                for (CrmCustomer customer : form.getCustomerList()) {
                    if (customer.getId() == null) {
                        customerService.insertSelective(customer);
                        //保存线索 客户联系人关联表
                        CrmReleCust clueCust = new CrmReleCust();
                        clueCust.setTargetId(form.getClue().getId());
                        clueCust.setCustId(customer.getId());
                        clueCust.setReleType(ReleTypeEnum.CLUE_TYPE.getCode());
                        clueCust.setCreateTime(new Date());
                        clueCustService.insertSelective(clueCust);
                    } else {
                        customerService.updateByPrimaryKeySelective(customer);
                    }
                }
                //保存产品信息begin
                for (Long aLong : form.getProductIds()) {
                    CrmClueProduct product = clueProductService.selectByPrimaryKey(aLong);
                    if (product == null) {
                        CrmClueProduct clueProduct = new CrmClueProduct();
                        clueProduct.setClueId(form.getClue().getId());
                        clueProduct.setProductId(aLong);
                        clueProductService.insertSelective(clueProduct);
                    } else {
                        clueProductService.deleteByPrimaryKey(aLong);
                    }

                }
                //保存产品信息end

                //保存回访信息begin 导入接口时会用到
                if (form.getCallbackList() != null && !form.getCallbackList().isEmpty()) {
                    try {
                        for (CrmCallback callback : form.getCallbackList()) {
                            //根据真实姓名查询归属人
                            logger.info("判断回访人姓名是否为空:callback.getAdminName()" + callback.getAdminName());
                            if (StringUtils.isNotEmpty(callback.getAdminName())) {
                                logger.info("查询回访人是否存在");
                                CrmAdmin ownerName = adminService.selectAdminByRealName(callback.getAdminName());
                                if (ownerName != null) {
                                    callback.setAdminId(ownerName.getId());
                                } else {
                                    callback.setAdminId(admin.getId());
                                }
                                callback.setCallBargain(form.getCallback().getCallBargain());
                                callback.setTargetId(form.getClue().getId());
                                callback.setReleType(ReleTypeEnum.CLUE_TYPE.getCode());
                                callback.setCreateTime(new Date());
                                logger.info(String.format("插入回访记录：%s", JSONObject.toJSONString(callback)));
                                callbackService.insertSelective(callback);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                //保存回访信息end
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return false;
        }
    }

    /**
     * 保存线索
     *
     * @param form
     */
    @Override
    public Boolean updateClue(ClueAddForm form) {
        //完善线索信息
        try {
            CrmAdmin admin = getUser();
            form.getClue().setUpdateTime(new Date());
            int clueResult = updateByPrimaryKeySelective(form.getClue());//更新线索
            if (clueResult == 1) {
                //保存客户联系人信息
                for (CrmCustomer customer : form.getCustomerList()) {
                    if (customer.getId() == null) {
                        customerService.insertSelective(customer);
                        //保存线索 客户联系人关联表
                        CrmReleCust clueCust = new CrmReleCust();
                        clueCust.setTargetId(form.getClue().getId());
                        clueCust.setCustId(customer.getId());
                        clueCust.setReleType(ReleTypeEnum.CLUE_TYPE.getCode());
                        clueCust.setCreateTime(new Date());
                        clueCustService.insertSelective(clueCust);
                    } else {
                        customerService.updateByPrimaryKeySelective(customer);
                    }
                }
                //保存产品信息begin
                clueProductService.deleteByClueId(form.getClue().getId());
                for (Long aLong : form.getProductIds()) {
                    CrmClueProduct clueProduct = new CrmClueProduct();
                    clueProduct.setClueId(form.getClue().getId());
                    clueProduct.setProductId(aLong);
                    clueProductService.insertSelective(clueProduct);


                }
                //保存产品信息end
                //保存回访信息begin
                if (!StringUtils.isEmpty(form.getCallback().getCallContent()) || form.getCallback().getCallNextTime() != null) {
                    form.getCallback().setTargetId(form.getClue().getId());
                    form.getCallback().setReleType(ReleTypeEnum.CLUE_TYPE.getCode());
                    form.getCallback().setAdminId(admin.getId());
                    form.getCallback().setCallTime(new Date());
                    form.getCallback().setCreateTime(new Date());
                    callbackService.insertSelective(form.getCallback());
                }
                //保存回访信息end
            }
            //记录操作记录
            optionLogService.saveOptionLog(ReleTypeEnum.CLUE_TYPE.getCode(), form.getClue().getId(), admin.getId(), OptionTypeEnum.EDIT.getCode());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return false;
        }
    }

    /**
     * 分页查询
     *
     * @param clue
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public Page<CrmClue> queryCrmClueForPage(CrmClue clue, Integer pageNo, Integer pageSize) {
        Page<CrmClue> page = new Page<>();
        if (clue.getSearchType() == 1) {
            page.setPageSize(20);
        }
        Map<String, Object> params = new HashMap<>();
        params.put("contacts", StringUtils.isNotEmpty(clue.getContacts()) ? clue.getContacts() : null);
        params.put("contactsPhone", StringUtils.isNotEmpty(clue.getContactsPhone()) ? clue.getContactsPhone() : null);
        params.put("custName", StringUtils.isNotEmpty(clue.getCustName()) ? clue.getCustName() : null);
        params.put("clueStatusOnline", clue.getClueStatusOnline());
        params.put("custProvince", clue.getCustProvince());
        params.put("custCity", clue.getCustCity());
        params.put("clueType", clue.getClueType());
        params.put("clueSource", clue.getClueSource());
        params.put("owner", clue.getOwner());
        params.put("ownerName", StringUtils.isNotEmpty(clue.getOwnerName()) && StringUtils.isNotEmpty(clue.getOwnerName().trim()) ? clue.getOwnerName() : null);
        params.put("userId", getUser().getId());//当前登录用户ID
        params.put("roleType", getUser().getRoleType());//当前登录用户ID
        params.put("adminId", clue.getAdminId());
        params.put("productId", clue.getProductId());
        params.put("callBargain", clue.getCallBargain());
        params.put("clueKnow", clue.getClueKnow());
        params.put("createTimestart", clue.getCreateTimestart());
        params.put("createTimeend", clue.getCreateTimeend());
        params.put("nextTimestart", clue.getNextTimestart());
        params.put("nextTimeend", clue.getNextTimeend());
        params.put("allotTimestart", clue.getAllotTimestart());
        params.put("allotTimeend", clue.getAllotTimeend());
        params.put("searchType", clue.getSearchType());
        params.put("isDepManager", clue.getIsDepManager());
        params.put("optionStatus", clue.getOptionStatus());
        params.put("contactsQQ", clue.getContactsQQ());
        params.put("callTimestart", clue.getCallTimestart());
        params.put("callTimeend", clue.getCallTimeend());
        if (clue.getIsDepManager() != null && clue.getIsDepManager() == 1) {
            List<CrmAdmin> adminList = adminService.getOwerList(getUser());
            List<Long> ownersList = new ArrayList<>();
            for (CrmAdmin admin : adminList) {
                ownersList.add(admin.getId());
            }
            params.put("ownersList", ownersList);
        }


        if (pageNo != null) page.setPageNo(pageNo);
        if (pageSize != null) page.setPageSize(pageSize);
        page.setParams(params);
        page.setUseDefaultSql(true);
        List<CrmClue> clueList = crmClueMapper.queryCrmClueForPage(page);

        for (CrmClue cle : clueList) {
            if (cle.getCallBargain() != null) {
                cle.setCallBargainStr(DealintentionEnum.getByCode(cle.getCallBargain()) == null ? "" : DealintentionEnum.getByCode(cle.getCallBargain()).getDesc());
            }

        }

        page.setResults(clueList);
        return page;
    }

    @Override
    public int closeClue(Long clueId) {
        CrmClue clue = new CrmClue();
        clue.setId(clueId);
        clue.setClueStatusOnline(ClueStatusEnum.CLOSED.getCode());
        return crmClueMapper.updateByPrimaryKeySelective(clue);
    }

    @Override
    public List<CrmClue> queryCrmClueByPhone(String phone) {
        List<CrmClue> clueList = crmClueMapper.queryCrmClueByPhone(phone);
        for (CrmClue clue : clueList) {
            clue.setProductList(productService.getProductsByClueId(clue.getId()));
        }
        return clueList;
    }

    @Override
    public List<CrmClue> queryCrmClueByCustName(String custName) {
        return crmClueMapper.queryCrmClueByCustName(custName);
    }

    @Override
    public CrmClue selectByClueId(Long clueId) {
        return crmClueMapper.selectByClueId(clueId);
    }
}
