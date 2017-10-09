package com.vcooline.crm.admin.service.impl;

import com.vcooline.crm.admin.service.BaseService;
import com.vcooline.crm.admin.service.CrmOptionLogService;
import com.vcooline.crm.common.enumutil.OptionTypeEnum;
import com.vcooline.crm.common.mapper.CrmOptionLogMapper;
import com.vcooline.crm.common.model.CrmOptionLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xinbaojian on 15/7/24.
 */
@Transactional
@Service
public class CrmOptionLogServiceImpl extends BaseService implements CrmOptionLogService {

    @Autowired
    private CrmOptionLogMapper optionLogMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return optionLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CrmOptionLog record) {
        return optionLogMapper.insert(record);
    }

    @Override
    public int insertSelective(CrmOptionLog record) {
        return optionLogMapper.insertSelective(record);
    }

    @Override
    public CrmOptionLog selectByPrimaryKey(Long id) {
        return optionLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CrmOptionLog record) {
        return optionLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CrmOptionLog record) {
        return optionLogMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<CrmOptionLog> selectListByTargetId(CrmOptionLog record) {
        List<CrmOptionLog> optionLogList = optionLogMapper.selectListByTargetId(record);
        for (CrmOptionLog log : optionLogList) {
            if (log.getOption() != null) {
                log.setOptionStr(OptionTypeEnum.getByCode(log.getOption()).getDesc());
            }
        }
        return optionLogList;
    }

    /**
     * 保存操作记录
     *
     * @param alloType  那种操作记录
     * @param targetId  目标ID
     * @param alloAdmin 操作人
     * @param option    操作
     * @return
     */
    @Override
    public int saveOptionLog(Byte alloType, Long targetId, Long alloAdmin, Byte option) {
        CrmOptionLog optionLog = new CrmOptionLog();
        optionLog.setAlloType(alloType);
        optionLog.setTargetId(targetId);
        optionLog.setAlloAdmin(alloAdmin);
        optionLog.setOption(option);
        return insertSelective(optionLog);
    }
}
