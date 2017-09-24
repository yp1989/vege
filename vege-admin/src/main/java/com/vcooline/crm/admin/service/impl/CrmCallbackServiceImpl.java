package com.vcooline.crm.admin.service.impl;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.vcooline.crm.admin.service.CrmBusinessService;
import com.vcooline.crm.common.enumutil.ClueStatusEnum;
import com.vcooline.crm.common.enumutil.ReleTypeEnum;
import com.vcooline.crm.common.model.CrmAdmin;
import com.vcooline.crm.common.model.CrmBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vcooline.crm.admin.service.BaseService;
import com.vcooline.crm.admin.service.CrmCallbackService;
import com.vcooline.crm.common.enumutil.DealintentionEnum;
import com.vcooline.crm.common.mapper.CrmCallbackMapper;
import com.vcooline.crm.common.model.CrmCallback;

/**
 *
 * Created by xinbaojian on 15/7/24.
 */
@Transactional
@Service
public class CrmCallbackServiceImpl extends BaseService implements CrmCallbackService {


    @Autowired
    private CrmCallbackMapper callbackMapper;

    @Autowired
    private CrmBusinessService businessService;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return callbackMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CrmCallback record) {
        return callbackMapper.insert(record);
    }

    @Override
    public int insertSelective(CrmCallback record) {
        return callbackMapper.insertSelective(record);
    }

    @Override
    public CrmCallback selectByPrimaryKey(Long id) {
        return callbackMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CrmCallback record) {
        return callbackMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CrmCallback record) {
        return callbackMapper.updateByPrimaryKey(record);
    }

    @Override
    public CrmCallback selectLastCallback(Long clueId) {
        return callbackMapper.selectLastCallback(clueId);
    }

    @Override
    public List<CrmCallback> selectCallBackListByClueId(Long clueId, Byte releType) {
        List<CrmCallback> list = callbackMapper.selectCallBackListByTarget(clueId,releType);
        for (CrmCallback callback : list) {
            if (callback.getCallBargain() != null){
                callback.setCallBargainStr(DealintentionEnum.getByCode(callback.getCallBargain()).getDesc());
            }
        }
        return list;
    }


    @Override
    public boolean addFinshedStatus(Long busiId) {
        CrmBusiness business = businessService.selectByPrimaryKey(busiId);
        logger.info("查询回访人是否存在");
        CrmCallback callback = new CrmCallback();
        callback.setAdminId(1l);
        callback.setCallBargain(DealintentionEnum.DEALT.getCode());
        callback.setTargetId(business.getClueId());
        callback.setReleType(ReleTypeEnum.CLUE_TYPE.getCode());
        callback.setCallContent("系统自动生成");
        callback.setCreateTime(new Date());
        logger.info(String.format("插入回访记录：%s", JSONObject.toJSONString(callback)));
        return insertSelective(callback) == 1;
    }
}
