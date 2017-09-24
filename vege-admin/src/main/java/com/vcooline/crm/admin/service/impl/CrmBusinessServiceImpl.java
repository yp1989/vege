package com.vcooline.crm.admin.service.impl;

import com.vcooline.crm.admin.service.*;
import com.vcooline.crm.common.enumutil.*;
import com.vcooline.crm.common.mapper.CrmBusinessMapper;
import com.vcooline.crm.common.model.*;
import com.vcooline.crm.common.pojo.BusinessForm;
import com.vcooline.crm.common.utils.DateUtil;
import com.vcooline.crm.common.utils.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xinbaojian on 15/7/28.
 */
@Transactional
@Service
public class CrmBusinessServiceImpl  extends BaseService implements CrmBusinessService {

    @Autowired
    private CrmBusinessMapper businessMapper;

    @Autowired
    private CrmClueService clueService;

    @Autowired
    private CrmBusiProductService busiProductService;

    @Autowired
    private CrmProductVersionService versionService;

    @Autowired
    private CrmCustomerService customerService;

    @Autowired
    private CrmReleCustService releCustService;

    @Autowired
    private CrmReleCustService clueCustService;

    @Autowired
    private CrmCallbackService callbackService;

    @Autowired
    private CrmOptionLogService optionLogService;

    @Autowired
    private CrmAllocationLogService allocationLogService;

    @Autowired
    private CrmProductService crmProductService;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return businessMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CrmBusiness record) {
        return businessMapper.insert(record);
    }

    @Override
    public int insertSelective(CrmBusiness record) {
        return businessMapper.insertSelective(record);
    }

    @Override
    public CrmBusiness selectByPrimaryKey(Long id) {
        return businessMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CrmBusiness record) {
        return businessMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CrmBusiness record) {
        return businessMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer getMaxNumCode() {
        Integer numCode = businessMapper.getMaxNumCode();
        if (numCode == null)
            numCode = 0;
        Integer num = numCode + 1;
        return num;
    }

    @Override
    public int convertBusinessFormClue(Long clueId,List<CrmBusiProduct> busiProducts) {
        CrmAdmin admin = getUser();
        //第一步，线索转换商机
        CrmClue clue = clueService.selectByPrimaryKey(clueId);
        Integer numCode = getMaxNumCode();
        CrmBusiness business = new CrmBusiness();
        business.setClueId(clueId);
        business.setBusiNumber(StringUtils.generateBusiNumber(numCode));
        business.setNumCode(numCode);
        business.setBusiRegitime(new Date());
        business.setBusiStatus(BusinessStatusEnum.AUDIT.getCode());
        business.setBusiSource(clue.getClueSource());
        business.setOwner(clue.getOwner());
        business.setOwnerName(clue.getOwnerName());
        business.setRemark(clue.getRemark());
        //若为系统分单，则显示线索的录入人，否则为当前录入者
        if (ClueSourceEnum.SYS_SPLIT.getCode().equals(clue.getClueSource())){//是系统分单
            business.setAdminId(clue.getAdminId());
            business.setAdminName(clue.getAdminName());
        }else{
            business.setAdminId(admin.getId());
            business.setAdminName(admin.getAdminName());
        }
        business.setBusiType(clue.getClueType());
        business.setCreateTime(new Date());
        business.setAllotTime(new Date());
        int result = insertSelective(business);
        if (result ==1){
            CrmClue newclue = new CrmClue();
            newclue.setId(clue.getId());
            //修改原线索的状态为已关闭 @Deprecated
            //修改原线索的状态为删除 @Deprecated 15-08-07
            //修改原线索的状态为生成商机关闭 15-08-11
            newclue.setIsDel(false);
            newclue.setClueStatusOnline(ClueStatusEnum.DONE_CLOSED.getCode());
            clueService.updateByPrimaryKeySelective(newclue);
            logger.info(String.format("线索ID：%s 转换商机成功！",clue.getId().toString()));
        }
        //第二步，关联联系人
        List<CrmCustomer> customerList = customerService.getCustlistByClueId(clue.getId(), ReleTypeEnum.CLUE_TYPE.getCode());
        CrmReleCust releCust = null;
        for (CrmCustomer customer : customerList) {
            releCust = new CrmReleCust();
            releCust.setTargetId(business.getId());
            releCust.setReleType(ReleTypeEnum.BUSINESS_TYPE.getCode());
            releCust.setCreateTime(new Date());
            releCust.setCustId(customer.getId());
            releCustService.insertSelective(releCust);
        }
        //第三步，更新商机所关联套餐
        if(busiProducts == null || busiProducts.size() == 0){
        	List<CrmProduct> products = crmProductService.getProductsByClueId(clueId);
        	if(products != null && products.size() != 0){
        		CrmBusiProduct bProduct = null;
        		for(CrmProduct product: products){
        			bProduct = new CrmBusiProduct();
        			bProduct.setBusiId(product.getId());
        			bProduct.setCreateTime(new Date());
        			bProduct.setUpdateTime(new Date());
                    busiProductService.insertSelective(bProduct);
        		}
        	}
        }else{
        	for (CrmBusiProduct busiProduct : busiProducts) {
                if (busiProduct.getProdVersionId() != null){
                    busiProduct.setBusiId(business.getId());
                    busiProduct.setCreateTime(new Date());
                    busiProduct.setUpdateTime(new Date());
                    busiProductService.insertSelective(busiProduct);
                }
            }
        }
        
        //获取线索回访信息
        List<CrmCallback> callbackList = callbackService.selectCallBackListByClueId(clueId, ReleTypeEnum.CLUE_TYPE.getCode());
        for (CrmCallback callback : callbackList) {
            callback.setId(null);
            callback.setReleType(ReleTypeEnum.BUSINESS_TYPE.getCode());
            callback.setTargetId(business.getId());
            callbackService.insertSelective(callback);
        }
        //获取线索分配记录
        CrmAllocationLog log = new CrmAllocationLog();
        log.setAlloType(ReleTypeEnum.CLUE_TYPE.getCode());
        log.setTargetId(clueId);
        List<CrmAllocationLog> allocationLogList = allocationLogService.selectListByTargetId(log);
        for (CrmAllocationLog allocationLog : allocationLogList) {
            allocationLog.setId(null);
            allocationLog.setAlloType(ReleTypeEnum.BUSINESS_TYPE.getCode());
            allocationLog.setTargetId(business.getId());
            allocationLogService.insertSelective(allocationLog);
        }
        //获取操作记录
        CrmOptionLog optionLog = new CrmOptionLog();
        optionLog.setAlloType(ReleTypeEnum.CLUE_TYPE.getCode());
        optionLog.setTargetId(clueId);
        List<CrmOptionLog> optionLogList = optionLogService.selectListByTargetId(optionLog);
        for (CrmOptionLog crmOptionLog : optionLogList) {
            crmOptionLog.setId(null);
            crmOptionLog.setAlloType(ReleTypeEnum.BUSINESS_TYPE.getCode());
            crmOptionLog.setTargetId(business.getId());
            optionLogService.insertSelective(crmOptionLog);
        }
        return result;
    }

    @Override
    public Page<CrmBusiness> queryBusinessByPage(CrmBusiness business, Integer pageNo, Integer pageSize) {
        Page<CrmBusiness> page = new Page<>();
        Map<String, Object> params = new HashMap<>();
        params.put("custName",StringUtils.isEmpty(business.getCustName()) ? null : business.getCustName());
        params.put("createTimestart", business.getCreateTimestart());
        params.put("createTimeend",business.getCreateTimeend() == null ? null : DateUtil.covertEndDate(business.getCreateTimeend()));
        params.put("busiStatus",business.getBusiStatus());
        params.put("busiSource",business.getBusiSource());
        params.put("owner",business.getOwner());
        params.put("busiType",business.getBusiType());
        params.put("callBargain",business.getCallBargain());
        params.put("isDepManager",business.getIsDepManager());
        if (pageNo != null) page.setPageNo(pageNo);
        if (pageSize != null) page.setPageSize(pageSize);
        page.setParams(params);
        List<CrmBusiness> businessList = businessMapper.queryCrmBusieForPage(page);
        for (CrmBusiness busi : businessList) {
            busi.setBusiStatusStr(busi.getBusiStatus() == null ? "" : BusinessStatusEnum.getByCode(busi.getBusiStatus()).getDesc());
            busi.setBusiSourceStr(busi.getBusiSource() == null ? "" : ClueSourceEnum.getByCode(busi.getBusiSource()).getDesc());
            busi.setBusiTypeStr(busi.getBusiType() == null ? "" : BusinessTypeEnum.getByCode(busi.getBusiType()).getDesc());
            busi.setProductVersionList(versionService.getVersionListByBusiId(busi.getId()));
        }
        page.setResults(businessList);
        return page;
    }

    @Override
    public int updateBusiness(BusinessForm form) {
        CrmAdmin admin = getUser();
        int result = 1;
        try {
            //保存或更新商机
            form.getBusiness().setUpdateTime(new Date());
            updateByPrimaryKeySelective(form.getBusiness());
            //更新商机联系人（联系人不能删除，修改，只能新增）
            for (CrmCustomer customer : form.getCustomerList()) {
                if (customer.getId() == null){
                    //只有新增的才插入
                    customerService.insertSelective(customer);
                    //保存线索 客户联系人关联表
                    CrmReleCust clueCust = new CrmReleCust();
                    clueCust.setTargetId(form.getBusiness().getId());
                    clueCust.setCustId(customer.getId());
                    clueCust.setReleType(ReleTypeEnum.BUSINESS_TYPE.getCode());
                    clueCust.setCreateTime(new Date());
                    clueCustService.insertSelective(clueCust);
                }
            }
            //保存产品套餐信息begin
            busiProductService.deleteByBusiId(form.getBusiness().getId());
            CrmBusiProduct busiProduct = null;
            for (String id : form.getVersionIds().split(",")) {
                busiProduct = new CrmBusiProduct();
                busiProduct.setBusiId(form.getBusiness().getId());
                busiProduct.setProdVersionId(Long.parseLong(id));
                busiProduct.setCreateTime(new Date());
                busiProduct.setUpdateTime(new Date());
                busiProductService.insertSelective(busiProduct);
            }
            //保存回访信息begin
            if (!StringUtils.isEmpty(form.getCallback().getCallContent()) || form.getCallback().getCallNextTime() != null) {
                form.getCallback().setTargetId(form.getBusiness().getId());
                form.getCallback().setReleType(ReleTypeEnum.BUSINESS_TYPE.getCode());
                form.getCallback().setAdminId(admin.getId());
                form.getCallback().setCallTime(new Date());
                form.getCallback().setCreateTime(new Date());
                callbackService.insertSelective(form.getCallback());
            }
            //保存回访信息end
            //记录操作记录
            optionLogService.saveOptionLog(ReleTypeEnum.BUSINESS_TYPE.getCode(),form.getBusiness().getId(),admin.getId(), OptionTypeEnum.EDIT.getCode());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            logger.error("更新商机出错了,商机ID：%s", form.getBusiness().getId());
            result = 0;
        }
        return result;
    }

    @Override
    public Boolean auditingBusiness(Long busiId, Boolean pass, String remark) {
        CrmBusiness business = selectByPrimaryKey(busiId);
        boolean result = true;
        try {
            if (pass){
                //审核通过
                business.setBusiStatus(BusinessStatusEnum.ACTIVE.getCode());
                updateByPrimaryKeySelective(business);
            }else{
                business.setBusiStatus(BusinessStatusEnum.RETURN_CHANGE.getCode());
                business.setIsDel(true);
                updateByPrimaryKeySelective(business);
                CrmClue clue = new CrmClue();
                clue.setId(business.getClueId());
                clue.setClueStatusOnline(ClueStatusEnum.RETURN_CHANGE.getCode());
                clue.setReturnChangeRemark(remark);
                clue.setUpdateTime(new Date());
                clue.setIsDel(false);
                clueService.updateByPrimaryKeySelective(clue);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("审核商机失败了！",e);
            return false;
        }
        return result;
    }
}
