package com.vcooline.crm.admin.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.vcooline.crm.admin.service.CrmAdminService;
import com.vcooline.crm.admin.service.CrmContractService;
import com.vcooline.crm.admin.service.CrmGatheringService;
import com.vcooline.crm.common.constant.GlobalConstants;
import com.vcooline.crm.common.enumutil.ContractTypeEnum;
import com.vcooline.crm.common.model.CrmAdmin;
import com.vcooline.crm.common.model.CrmContract;
import com.vcooline.crm.common.model.CrmGathering;
import com.vcooline.crm.common.model.Page;
import com.vcooline.crm.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 收款管理
 * Created by xinbaojian on 15/8/5.
 */
@Controller
@RequestMapping("/gather")
public class GatherController extends BaseController{

    @Autowired
    private CrmAdminService adminService;

    @Autowired
    private CrmGatheringService gatheringService;

    @Autowired
    private CrmContractService contractService;


    @RequestMapping("/index")
    public String index(ModelMap modelMap,CrmGathering gathering,Integer pageNo,Integer pageSize){
        Page<CrmGathering> page = gatheringService.queryGatherForPage(gathering, pageNo, pageSize);
        modelMap.addAttribute("page", page);
        //合同类型
        modelMap.addAttribute("contractType", ContractTypeEnum.toList());
        //查询归属人信息
        List<CrmAdmin> adminList = adminService.getOwerList(getUser());
        modelMap.addAttribute("adminList", adminList);

        List<String> contractNames = contractService.getContractName(null);
        modelMap.addAttribute("contractNames", JSONObject.toJSONString(contractNames));
        modelMap.addAttribute("gath", gathering);
        String msg = getRequest().getParameter("msg");
        if (StringUtils.isNotEmpty(msg)){
            modelMap.addAttribute("msg",msg);
        }
        return "html/gathering/gathering";
    }

    /**
     * 新增收款
     * @param gathering
     * @param modelMap
     * @param ra
     * @return
     */
    @RequestMapping("/doGather")
    public String doAddGather(CrmGathering gathering,ModelMap modelMap,RedirectAttributes ra){
        CrmAdmin admin = getUser();
        gathering.setRegisterId(admin.getId());
        gathering.setRegisterName(admin.getAdminRealName());
        int result = 0;
        if (gathering.getId() == null){
            result = gatheringService.saveGathering(gathering);
            if (result == 1){
                ra.addAttribute("msg","新增收款成功！");
            }else{
                ra.addAttribute("msg","新增收款失败！");
            }
        }else{
            result = gatheringService.updateGathering(gathering);
            if (result == 1){
                ra.addAttribute("msg","编辑收款成功！");
            }else{
                ra.addAttribute("msg","编辑收款失败！");
            }
        }


        return "redirect:/gather/index";
    }

    /**
     * 编辑收款管理
     * @param id
     * @param contNumber
     * @return
     */
    @RequestMapping("/toEdit")
    @ResponseBody
    public Map<String,Object> toEdit(Long id,String contNumber){
        Map<String,Object> map = new HashMap<>();
        CrmGathering gathering = gatheringService.selectByPrimaryKey(id);
        CrmContract contract = contractService.getContractByNumber(contNumber);
        map.put("gathering",gathering);
        map.put("contract",contract);
        return map;
    }

    /**
     * 确认开通账户
     * @return
     */
    @RequestMapping("/confirm")
    public String confirmOpen(Long contId,RedirectAttributes ra){
        CrmContract contract = new CrmContract();
        contract.setId(contId);
        contract.setAccStatus((byte)1);//开通成功
        int result = contractService.updateByPrimaryKeySelective(contract);
        if (result == 1){
            ra.addAttribute("msg","开通成功！");
        }else{
            ra.addAttribute("msg","开通失败！");
        }
        return "redirect:/gather/index";
    }

}
