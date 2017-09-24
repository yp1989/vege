package com.vcooline.crm.admin.service;

import com.vcooline.crm.common.model.CrmAdmin;
import com.vcooline.crm.common.model.CrmClue;
import com.vcooline.crm.common.model.Page;
import com.vcooline.crm.common.pojo.ClueAddForm;

import java.util.List;

/**
 * 线索接口类
 * Created by xinbaojian on 15/7/17.
 */
public interface CrmClueService {

    int deleteByPrimaryKey(Long id);

    int insert(CrmClue record);

    int insertSelective(CrmClue record);

    CrmClue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CrmClue record);


    int updateByPrimaryKey(CrmClue record);

    /**
     * 获取当前自增码最大值
     * @return
     */
    Integer getMaxNumCode();

    Boolean saveClue(ClueAddForm form);
    Boolean saveClueImport(ClueAddForm form,CrmAdmin admin);
    Boolean updateClue(ClueAddForm form);

    /**
     * 分页查询
     * @param clue
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page<CrmClue> queryCrmClueForPage(CrmClue clue,Integer pageNo,Integer pageSize);

    /**
     * 关闭线索
     * @param clueId 要关闭的线索ID
     * @return
     */
    int closeClue(Long clueId);

    /**
     * 根据手机号查询所关联线索
     * @param phone
     * @return
     */
    List<CrmClue> queryCrmClueByPhone(String phone);

    /**
     * 根据客户名称查询所关联线索
     * @param custName
     * @return
     */
    List<CrmClue> queryCrmClueByCustName(String custName);

    /**
     * 根据老Admin线索ID查询该线索是否存在
     * @param clueId
     * @return
     */
    CrmClue selectByClueId(Long clueId);
}
