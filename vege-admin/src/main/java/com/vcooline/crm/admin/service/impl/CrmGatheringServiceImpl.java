package com.vcooline.crm.admin.service.impl;

import com.vcooline.crm.admin.service.BaseService;
import com.vcooline.crm.admin.service.CrmContractService;
import com.vcooline.crm.admin.service.CrmGatheringService;
import com.vcooline.crm.common.enumutil.ContractTypeEnum;
import com.vcooline.crm.common.mapper.CrmGatheringMapper;
import com.vcooline.crm.common.model.CrmContract;
import com.vcooline.crm.common.model.CrmGathering;
import com.vcooline.crm.common.model.Page;
import com.vcooline.crm.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xinbaojian on 15/8/5.
 */
@Transactional
@Service
public class CrmGatheringServiceImpl extends BaseService implements CrmGatheringService {

    @Autowired
    private CrmGatheringMapper gatheringMapper;

    @Autowired
    private CrmContractService contractService;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return gatheringMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CrmGathering record) {
        return gatheringMapper.insert(record);
    }

    @Override
    public int insertSelective(CrmGathering record) {
        return gatheringMapper.insertSelective(record);
    }

    @Override
    public CrmGathering selectByPrimaryKey(Long id) {
        return gatheringMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CrmGathering record) {
        return gatheringMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CrmGathering record) {
        return gatheringMapper.updateByPrimaryKey(record);
    }


    @Override
    public int saveGathering(CrmGathering gathering) {

        int result = insertSelective(gathering);
        if (result == 1) {
            //更新合同数据
            CrmContract contract = contractService.selectByPrimaryKey(gathering.getContId());
            contract.setId(gathering.getContId());
            if (contract.getContCollected() == null) {
                contract.setContCollected(0l);
            }
            contract.setContCollected(contract.getContCollected() + gathering.getGathMoney());//已收款
            contract.setContUncollected(contract.getContReceivable() - contract.getContCollected());//重新计算未收款
            result = contractService.updateByPrimaryKeySelective(contract);
        }
        return result;
    }

    @Override
    public int updateGathering(CrmGathering gathering) {
        CrmGathering oldGather = gatheringMapper.selectByPrimaryKey(gathering.getId());
        int result = updateByPrimaryKeySelective(gathering);
        if (result == 1) {
            //更新合同数据
            CrmContract contract = contractService.selectByPrimaryKey(oldGather.getContId());
            contract.setId(oldGather.getContId());
            Long beicnAmount = gathering.getGathMoney() - oldGather.getGathMoney();
            contract.setContCollected(contract.getContCollected() + beicnAmount);//已收款
            contract.setContUncollected(contract.getContUncollected() - beicnAmount);//重新计算未收款
            result = contractService.updateByPrimaryKeySelective(contract);
        }
        return result;
    }

    @Override
    public Page<CrmGathering> queryGatherForPage(CrmGathering gathering, Integer pageNo, Integer pageSize) {
        Page<CrmGathering> page = new Page<>();
        Map<String, Object> params = new HashMap<>();
        params.put("custName", StringUtils.isNotEmpty(gathering.getCustName()) ? gathering.getCustName() : null);
        params.put("contNumber", StringUtils.isNotEmpty(gathering.getContNumber()) ? gathering.getContNumber() : null);
        params.put("owner", StringUtils.isNotEmpty(gathering.getOwner()) ? gathering.getOwner() : null);
        params.put("contType", gathering.getContType());
        params.put("gathTimestart", gathering.getGathTimestart());
        params.put("gathTimeend", gathering.getGathTimeend());

        if (pageNo != null) page.setPageNo(pageNo);
        if (pageSize != null) page.setPageSize(pageSize);
        page.setParams(params);
        List<CrmGathering> gatheringList = gatheringMapper.queryGatherForPage(page);
        for (CrmGathering gath : gatheringList) {
            gath.setContTypeStr(ContractTypeEnum.getByCode(gath.getContType()).getDesc());
        }
        page.setResults(gatheringList);
        return page;
    }


}
