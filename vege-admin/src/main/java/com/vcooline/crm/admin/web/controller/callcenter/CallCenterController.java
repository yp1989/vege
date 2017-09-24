package com.vcooline.crm.admin.web.controller.callcenter;

import com.alibaba.fastjson.JSONObject;
import com.vcooline.crm.admin.service.*;
import com.vcooline.crm.admin.web.controller.BaseController;
import com.vcooline.crm.common.enumutil.*;
import com.vcooline.crm.common.model.*;
import com.vcooline.crm.common.pojo.ClueAddForm;
import com.vcooline.crm.common.pojo.ResultBean;
import com.vcooline.crm.common.utils.DateUtil;
import com.vcooline.crm.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 呼叫中心首页控制类
 * Created by xinbaojian on 15/7/16.
 */
@Controller
@RequestMapping("/callcenter")
public class CallCenterController extends BaseController{

    @Autowired
    private CrmProductService productService;

    @Autowired
    private CrmClueService clueService;

    @Autowired
    private CrmAdminService adminService;

    @Autowired
    private CrmCustomerService customerService;

    @Autowired
    private CrmCallbackService callbackService;

    @Autowired
    private CrmAllocationLogService allocationLogService;

    @Autowired
    private CrmOptionLogService optionLogService;

    @Value("${api.agents}")
    private String agentsUrl;

    @Value("${api.supplier_applies}")
    private String supplier_applies_url;

    @Value("${api.supplier_applies.update}")
    private String supplier_applies_update;

    @Autowired
    RestTemplate restTemplate;
	
    @RequestMapping("/index")
    public String index(CrmClue clue,Integer pageNo,Integer pageSize,ModelMap modelMap,HttpServletRequest request) {
        CrmAdmin admin = getUser();
        clue.setSearchType((byte) 1);
        clue.setIsDepManager((byte) 0);
        if (admin.getRoleType() != 0 && admin.getRoleType() != 2) {
            clue.setAdminId(admin.getId());
            if (admin.getIsDepManager() != null && admin.getIsDepManager() != 0){
                clue.setIsDepManager(admin.getIsDepManager());
            }
        }

        //判断是否有时间条件查询，如果没有，默认只查2015年的数据 只有超级管理员权限才可以
        if (clue.getCreateTimestart() == null && (admin.getRoleType() == 0 || admin.getRoleType() == 2)){
            clue.setCreateTimestart(DateUtil.strToDate(String.format("%s-01 00:00:00",DateUtil.getCurrentYearMonthStr()),DateUtil.DEFAULT_FORMAT));
        }

        modelMap.addAttribute("clue",clue);
		Page<CrmClue> page = clueService.queryCrmClueForPage(clue,pageNo,pageSize);
		modelMap.addAttribute("page",page);

		//线索来源
		modelMap.addAttribute("ClueSource", ClueSourceEnum.toList());
		//了解方式
		modelMap.addAttribute("ClueKnow", ClueKnowEnum.toList());
		//咨询方式
		modelMap.addAttribute("ClueConsult", ClueConsultEnum.toList());
		//线索类型
		modelMap.addAttribute("ClueType", ClueTypeEnum.toList());
		//获取所有产品类型
		modelMap.addAttribute("products",productService.getAllProduct());
		//成交意向
		modelMap.addAttribute("dealIntention", DealintentionEnum.toList());
		//线索状态
		modelMap.addAttribute("clueStatusOnline",ClueStatusEnum.toList());

		//查询归属人信息
		List<CrmAdmin> adminList = adminService.getOwerList(getUser());
		modelMap.addAttribute("adminList",adminList);
        String msg = request.getParameter("msg");
        if (StringUtils.isNotEmpty(msg)){
            modelMap.addAttribute("msg",msg);
            modelMap.addAttribute("msgcode",request.getParameter("msgcode"));
        }
        return "html/callcenter/callcenter";
    }

    @RequestMapping("/toAddClue")
    public String toAddClue(ModelMap model,HttpServletRequest request){
        //角色
        model.addAttribute("roles", CustRoleEnum.toJson());
        //线索来源
        model.addAttribute("ClueSource", ClueSourceEnum.toList());
        //了解方式
        model.addAttribute("ClueKnow", ClueKnowEnum.toList());
        //咨询方式
        model.addAttribute("ClueConsult", ClueConsultEnum.toList());
        //线索类型
        model.addAttribute("ClueType", ClueTypeEnum.toList());
        //获取所有产品类型
        model.addAttribute("products", productService.getAllProduct());
        String msg = request.getParameter("msg");
        if (StringUtils.isNotEmpty(msg)){
            model.addAttribute("msg",msg);
        }
        return "html/callcenter/clueAdd";
    }

    /**
     * 新增线索
     * @param form
     * @param ra
     * @return
     */
    @RequestMapping("/doAddClue")
    public String doAddClue(ClueAddForm form,RedirectAttributes ra,Byte callBargainByte){
        //设置用户录入人
        CrmAdmin admin = getUser();
        form.getClue().setAdminId(admin.getId());
        form.getClue().setAdminName(admin.getAdminRealName());
        if (form.getClue().getId() == null){
            form.setIsAllot(false);
            boolean result = clueService.saveClue(form);
            ra.addAttribute("msg", result ? "新增成功！" : "新增失败！");
            ra.addAttribute("msgcode",result ? "1" : "-1");
        }else {
            if (callBargainByte != null){
                form.getCallback().setCallBargain(callBargainByte);
            }
            boolean result = clueService.updateClue(form);
            ra.addAttribute("msg", result ? "更新成功！" : "更新失败！");
            ra.addAttribute("msgcode",result ? "1" : "-1");
        }

        return "redirect:/callcenter/index";
    }

    /**
     * 编辑线索
     * @return
     */
    @RequestMapping(value = {"/toEditClue","/toShowClue"})
    public String toEditClue(Long clueId,ModelMap modelMap){
        CrmClue clue = clueService.selectByPrimaryKey(clueId);
        //线索来源
        modelMap.addAttribute("ClueSource", ClueSourceEnum.toList());
        //了解方式
        modelMap.addAttribute("ClueKnow", ClueKnowEnum.toList());
        //咨询方式
        modelMap.addAttribute("ClueConsult", ClueConsultEnum.toList());
        //线索类型
        modelMap.addAttribute("ClueType", ClueTypeEnum.toList());
        //获取所有产品类型
        modelMap.addAttribute("products",productService.getAllProduct());
        //成交意向
        modelMap.addAttribute("dealIntention",DealintentionEnum.toList());
        //线索状态
        modelMap.addAttribute("clueStatusOnline",ClueStatusEnum.toList());
        //获取该线索所关联产品
        modelMap.addAttribute("clueProducts",productService.getProductsByClueId(clueId));
        //角色
        modelMap.addAttribute("roles", CustRoleEnum.toList());
        //角色
        modelMap.addAttribute("rolesJson", CustRoleEnum.toJson());
        //查询归属人信息
        List<CrmAdmin> adminList = adminService.getOwerList(getUser());
        modelMap.addAttribute("adminList",adminList);
        modelMap.addAttribute("clue",clue);
        //查询该线索的联系人信息
        List<CrmCustomer> customerList = customerService.getCustlistByClueId(clueId, ReleTypeEnum.CLUE_TYPE.getCode());
        modelMap.addAttribute("customerList", customerList);
        //获取线索回访信息
        List<CrmCallback> callbackList = callbackService.selectCallBackListByClueId(clueId, ReleTypeEnum.CLUE_TYPE.getCode());
        modelMap.addAttribute("callbackList",callbackList);
        //获取线索分配记录
        CrmAllocationLog log = new CrmAllocationLog();
        log.setAlloType(ReleTypeEnum.CLUE_TYPE.getCode());
        log.setTargetId(clueId);
        List<CrmAllocationLog> allocationLogList = allocationLogService.selectListByTargetId(log);
        modelMap.addAttribute("allocationLogList", allocationLogList);
        //获取操作记录
        CrmOptionLog optionLog = new CrmOptionLog();
        optionLog.setAlloType(ReleTypeEnum.CLUE_TYPE.getCode());
        optionLog.setTargetId(clueId);
        List<CrmOptionLog> optionLogList = optionLogService.selectListByTargetId(optionLog);
        modelMap.addAttribute("optionLogList",optionLogList);
        modelMap.addAttribute("admin",getUser());

        String url = getReqUrl();
        if (url.contains("toEditClue")){
            return "html/callcenter/clueEdit";
        }else{
            return "html/callcenter/clueShow";
        }
    }

    /**
     * 获取分配人员列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/allot")
    public List<CrmAdmin> showClueAllot(CrmAdmin admin){
        //查询归属人信息
        if (getUser().getRoleType() == 0) {
            admin.setId(null);
        }
        List<CrmAdmin> adminList = adminService.getOwerList(admin);
        return adminList;
    }

    /**
     * 分配线索
     * @return
     */
    @RequestMapping("/distribution")
    @ResponseBody
    public String Distributionleads(CrmClue clue,String cluds){
        CrmAdmin user = getUser();
        String [] cludss = cluds.split(",");
        try {
            for (String s : cludss) {
                CrmClue oldClue = clueService.selectByPrimaryKey(Long.parseLong(s));

                if (oldClue.getOwnerType().equals(ClueOwnerTypeEnum.AGENT.getCode())){
                    allotToAgent(oldClue,null,null,ClueOwnerTypeEnum.AGENT.getCode().toString());
                }

                clue.setId(Long.parseLong(s));
                clue.setAllotTime(new Date());
                clue.setOwnerName(adminService.selectAdminById(clue.getOwner()).getAdminRealName());
                clue.setClueStatusOnline(ClueStatusEnum.ALLOCATED.getCode());
                clue.setOwnerType(ClueOwnerTypeEnum.USER.getCode());
                clueService.updateByPrimaryKeySelective(clue);
                //保存分配记录
                CrmAllocationLog allocationLog = new CrmAllocationLog();
                allocationLog.setAlloAdmin(user.getId());
                allocationLog.setAlloOwner(clue.getOwner());
                allocationLog.setAlloType(ReleTypeEnum.CLUE_TYPE.getCode());
                allocationLog.setTargetId(Long.parseLong(s));
                if (clue.getOwner() != null){
                    allocationLog.setAlloSource(clue.getOwner());
                }
                allocationLogService.insertSelective(allocationLog);

            }
        } catch (NumberFormatException e) {
            logger.info("分配线索出错了！",e);
            return "0";
        }
        return "1";
//        return "redirect:/callcenter/index";
    }

    /**
     * 关闭线索
     * @param clueId 要关闭的线索ID
     * @return
     */
    @RequestMapping("/close")
    @ResponseBody
    public String closeClue(Long clueId,RedirectAttributes ra){
        String msg = "关闭失败";
        Integer code = 0;
        if (clueService.closeClue(clueId) == 1){
            ra.addAttribute("msg","");
            msg = "关闭成功";
            code = 1;
        }
        return String.format("{\"msg\":\"%s\",\"code\":%d}",msg,code);
    }

    @RequestMapping("/getAgent")
    @ResponseBody
    public String getAgentList(String query,String page,String pageSize){
        String ebdoorresult = restTemplate.getForObject(String.format(agentsUrl,query,page,pageSize), String.class);
        return ebdoorresult;
    }

    /**
     * 给代理商分配线索
     * @return
     */
    @RequestMapping("/addClueToAgent")
    @ResponseBody
    public String addSupplierApplies(String clueIds,Long agentId,String agentName,RedirectAttributes ra){
        Map<String, Object> map = new HashMap<>();
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(1);
        resultBean.setMsg("失败！");
        if (StringUtils.isEmpty(clueIds)){
            return "redirect:/callcenter/index";

        }
        try {
            for (String clueId : clueIds.split(",")) {
                String[] clueParams = clueId.split("!");
                CrmClue clue = clueService.selectByPrimaryKey(Long.parseLong(clueParams[0]));
                map = allotToAgent(clue,agentId,agentName,clueParams[1]);
                if (map.get("errcode").toString().equals("0")){
                    //接口调用成功，修改本地
                    clue.setOwnerType(ClueOwnerTypeEnum.AGENT.getCode());
                    clue.setOwnerName(agentName);
                    clue.setOwner(Long.parseLong(map.get("id").toString()));
                    clue.setAllotTime(new Date());
                    clue.setClueStatusOnline(ClueStatusEnum.ALLOCATED.getCode());
                    clue.setClueId(Long.parseLong(map.get("id").toString()));
                    if (clueService.updateByPrimaryKeySelective(clue) == 1){
                        resultBean.setCode(1);
                        resultBean.setMsg("分配成功");
                    }else {
                        resultBean.setCode(-1);
                        resultBean.setMsg(String.format("线索:%s 分配失败,%s",clue.getCustName(),map.get("errmsg")));
                        break;
                    }
                }else{
                    resultBean.setCode(-1);
                    resultBean.setMsg(String.format("线索:%s 分配失败,%s",clue.getCustName(),map.get("errmsg")));
                    break;
                }
            }
        } catch (Exception e) {
            logger.error("分配代理商出错了",e);
            resultBean.setCode(-1);
            resultBean.setMsg(String.format("线索分配失败"));
            return JSONObject.toJSONString(resultBean);
        }

        return JSONObject.toJSONString(resultBean);
//        return "redirect:/callcenter/index";
    }

    private Map<String, Object> allotToAgent(CrmClue clue, Long agentId, String agentName,String type) {
        Map<String,Object> map = new HashMap<>();
        //TODO 测试过后记得删除
        System.out.println("================="+ReleTypeEnum.CLUE_TYPE.getCode());
        List<CrmCustomer> customerList = customerService.getCustlistByClueId(clue.getId(), ReleTypeEnum.CLUE_TYPE.getCode());
        CrmCustomer customer = customerList.get(0);
        List<CrmProduct> productList = productService.getProductsByClueId(clue.getId());
        CrmProduct product = productList.get(0);
        List<CrmCallback> callbackList = callbackService.selectCallBackListByClueId(clue.getId(), ReleTypeEnum.CLUE_TYPE.getCode());
        CrmCallback callback = callbackList != null && !callbackList.isEmpty() && callbackList.size() != 0 ? callbackList.get(0) : null;
        //验证
        if (clue.getClueType() == null){
            map.put("errcode",-1);
            map.put("errmsg","线索类型不能为空");
            return  map;
        }
        if (clue.getClueKnow() == null){
            map.put("errcode",-1);
            map.put("errmsg","线索来源不能为空");
            return  map;
        }

        if (clue.getCustProvince() == null){
            map.put("errcode",-1);
            map.put("errmsg","联系人省份不能为空");
            return  map;
        }
        if (clue.getCustCity() == null){
            map.put("errcode",-1);
            map.put("errmsg","联系人城市不能为空");
            return  map;
        }
        if (clue.getCustArea() == null) {
            map.put("errcode",-1);
            map.put("errmsg","联系人区域不能为空");
            return  map;
        }
        //rquest ruby api
        Map<String, Object> applyParam = new HashMap<>();
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", clue.getCustName());
        params.put("contact", customer.getCustName());
        params.put("tel", customer.getCustPhone());
        params.put("qq", customer.getCustQq());
        params.put("deal_status", callback == null ? "1" : callback.getCallBargain() == null ? "1" : callback.getCallBargain().toString());
        params.put("product_agent_type", product.getId().toString());
        params.put("business_type", clue.getClueType().toString());
        params.put("apply_type", "0");
        params.put("source_type", clue.getClueKnow().toString());
        params.put("creator_name", clue.getAdminName());
        params.put("owner_name", clue.getOwnerName());
        params.put("agent_id", agentId == null ? "" : agentId.toString());
        params.put("province_id", clue.getCustProvince().toString());
        params.put("city_id", clue.getCustCity().toString());
        params.put("district_id", clue.getCustArea().toString());
        params.put("address", clue.getCustAddr());
        params.put("description", clue.getRemark());
        params.put("created_at", DateUtil.dateToStr(clue.getCreateTime()));
        params.put("status", "0"); //线索状态，默认为0
        params.put("is_sync", "1");//默认就是已同步到crm系统
        params.put("last_assign_at", DateUtil.dateToStr(new Date()));//默认就是已同步到crm系统


        applyParam.put("supplier_apply", params);
        if (!type.equals("0") && clue.getClueId() != null){
            applyParam.put("id",clue.getClueId());
        }


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity requestentity = new HttpEntity(applyParam, headers);


        logger.info(JSONObject.toJSONString(applyParam));
        if (type.equals("0") && clue.getClueId() == null){
            logger.info(String.format("线索 id:%s;custName:%s 分配代理商-%s，%s %s",clue.getId().toString(),clue.getCustName(),agentName,clue.getOwner(),clue.getOwnerName()));
            map = restTemplate.postForObject(supplier_applies_url, requestentity, Map.class);
        } else if (clue.getClueId() != null){
            logger.info(String.format("线索 clue_id:%s;custName:%s 更换代理商-%s，%s %s", clue.getClueId().toString(), clue.getCustName(), agentName,clue.getOwner(),clue.getOwnerName()));
            map = restTemplate.postForObject(supplier_applies_update.replace(":id",clue.getClueId().toString()), requestentity, Map.class);
        }else  if (type.equals("1")){
            logger.info(String.format("线索 id:%s;custName:%s 更换代理商-%s，%s %s", clue.getOwner().toString(), clue.getCustName(), agentName,clue.getOwner(),clue.getOwnerName()));
            map = restTemplate.postForObject(supplier_applies_update.replace(":id",clue.getOwner().toString()), requestentity, Map.class);
        }
        return map;
    }

}
