package com.vcooline.crm.admin.service.impl;

import com.vcooline.crm.admin.service.BaseService;
import com.vcooline.crm.admin.service.CrmProductVersionService;
import com.vcooline.crm.common.mapper.CrmProductVersionMapper;
import com.vcooline.crm.common.model.CrmProductVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by xinbaojian on 15/7/28.
 */
@Transactional
@Service
public class CrmProductVersionServiceImpl extends BaseService implements CrmProductVersionService {

    @Autowired
    private CrmProductVersionMapper productVersionMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return productVersionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CrmProductVersion record) {
        return productVersionMapper.insert(record);
    }

    @Override
    public int insertSelective(CrmProductVersion version) {

        if (version != null && version.getProdId() != null) {
            Date date = new Date();
            version.setVersStatus((byte) 1);
            version.setIsDel(false);
            version.setCreateTime(date);
            version.setUpdateTime(date);
            return productVersionMapper.insertSelective(version);
        }
        return 0;
    }

    @Override
    public CrmProductVersion selectByPrimaryKey(Long id) {
        return productVersionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CrmProductVersion version) {
        if (version != null && version.getId() != null) {
            version.setUpdateTime(new Date());
            productVersionMapper.updateByPrimaryKeySelective(version);
        }
        return 0;
    }

    @Override
    public int updateByPrimaryKey(CrmProductVersion record) {
        return productVersionMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<CrmProductVersion> getList(CrmProductVersion record) {
        List<CrmProductVersion> versionList = productVersionMapper.getList(record);
        return versionList;
    }

    @Override
    public List<CrmProductVersion> getListByProdId(Long prodId) {
        CrmProductVersion version = new CrmProductVersion();
        version.setProdId(prodId);
        version.setIsDel(false);
        version.setVersStatus((byte) 1);//套餐状态
        return getList(version);
    }

    /**
     * @return List<CrmProductVersion>    返回类型
     * @throws
     * @Description:获取所有套餐列表
     * @author caohuan
     * @date 2015年7月29日 下午3:39:33
     * 上海微客来软件技术有限公司
     */
    public List<CrmProductVersion> getVersionList() {
        return productVersionMapper.getVersionList();
    }

    @Override
    public List<CrmProductVersion> getVersionListByBusiId(Long busiId) {
        return productVersionMapper.getVersionListByBusiId(busiId);
    }
}
