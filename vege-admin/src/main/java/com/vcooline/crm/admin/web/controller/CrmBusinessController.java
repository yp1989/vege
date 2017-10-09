package com.vcooline.crm.admin.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.vcooline.crm.admin.service.*;
import com.vcooline.crm.common.enumutil.*;
import com.vcooline.crm.common.model.*;
import com.vcooline.crm.common.pojo.BusinessForm;
import com.vcooline.crm.common.pojo.ContractForm;
import com.vcooline.crm.common.pojo.ResultBean;
import com.vcooline.crm.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 商机管理
 * Created by xinbaojian on 15/7/28.
 */
@Controller
@RequestMapping("/business")
public class CrmBusinessController extends BaseController {

    @Autowired
    private CrmAdminService adminService;

    @Autowired
    private CrmProductVersionService productVersionService;

    @Autowired
    private CrmBusinessService businessService;

    @Autowired
    private CrmCustomerService customerService;

    @Autowired
    private CrmClueService clueService;

    @Autowired
    private CrmProductService productService;

    @Autowired
    private CrmCallbackService callbackService;

    @Autowired
    private CrmAllocationLogService allocationLogService;

    @Autowired
    private CrmOptionLogService optionLogService;

    @Autowired
    private CrmContractService contractService;

    @Value("${file.upload.path}")
    private String filePath;


    @RequestMapping("/index")
    public String toIndex(CrmBusiness business, Integer pageNo, Integer pageSize, ModelMap modelMap) {
        CrmAdmin admin = getUser();
        business.setIsDepManager((byte) 0);
        if (admin.getRoleType() != 0 && admin.getRoleType() != 2) {
            business.setOwner(getUserId());
            if (admin.getIsDepManager() != null && admin.getIsDepManager() != 0) {
                business.setIsDepManager(admin.getIsDepManager());
            }
        }
        Page page = businessService.queryBusinessByPage(business, pageNo, pageSize);
        modelMap.addAttribute("page", page);

        //商机状态
        modelMap.addAttribute("businessStatus", BusinessStatusEnum.toList());
        //商机来源
        modelMap.addAttribute("businessSource", ClueSourceEnum.toList());
        //商机类型
        modelMap.addAttribute("businessType", BusinessTypeEnum.toList());
        //查询所有套餐
        modelMap.addAttribute("productVersions", productVersionService.getList(null));

        //查询归属人信息
        List<CrmAdmin> adminList = adminService.getOwerList(admin);
        modelMap.addAttribute("adminList", adminList);
        modelMap.addAttribute("busi", business);
        String msg = getRequest().getParameter("msg");
        if (msg != null && StringUtils.isNotEmpty(msg)) {
            modelMap.addAttribute("msg", msg);
        }
        return "html/business/business";
    }

    /**
     * 商机编辑
     *
     * @param modelMap
     * @return
     */
    @RequestMapping(value = {"/edit", "/show"})
    public String toEdit(ModelMap modelMap, Long busiId, HttpServletRequest request) {
        CrmBusiness business = businessService.selectByPrimaryKey(busiId);
        business.setProductVersionList(productVersionService.getVersionListByBusiId(busiId));
        modelMap.addAttribute("business", business);
        CrmClue clue = clueService.selectByPrimaryKey(business.getClueId());
        modelMap.addAttribute("clue", clue);
        //角色
        modelMap.addAttribute("roles", CustRoleEnum.toList());
        //角色
        modelMap.addAttribute("rolesJson", CustRoleEnum.toJson());
        //商机来源
        modelMap.addAttribute("ClueSource", ClueSourceEnum.toList());
        //商机类型
        modelMap.addAttribute("businessType", BusinessTypeEnum.toList());
        //查询所有产品及套餐
        List<CrmProduct> productList = productService.getAllProductAndVersions();
        modelMap.addAttribute("productList", productList);
        //查询该线索的联系人信息
        List<CrmCustomer> customerList = customerService.getCustlistByClueId(business.getId(), ReleTypeEnum.BUSINESS_TYPE.getCode());
        modelMap.addAttribute("customerList", customerList);
        //获取线索回访信息
        List<CrmCallback> callbackList = callbackService.selectCallBackListByClueId(busiId, ReleTypeEnum.BUSINESS_TYPE.getCode());
        modelMap.addAttribute("callbackList", callbackList);
        //获取线索分配记录
        CrmAllocationLog log = new CrmAllocationLog();
        log.setAlloType(ReleTypeEnum.BUSINESS_TYPE.getCode());
        log.setTargetId(busiId);
        List<CrmAllocationLog> allocationLogList = allocationLogService.selectListByTargetId(log);
        modelMap.addAttribute("allocationLogList", allocationLogList);
        //获取操作记录
        CrmOptionLog optionLog = new CrmOptionLog();
        optionLog.setAlloType(ReleTypeEnum.BUSINESS_TYPE.getCode());
        optionLog.setTargetId(busiId);
        List<CrmOptionLog> optionLogList = optionLogService.selectListByTargetId(optionLog);
        modelMap.addAttribute("optionLogList", optionLogList);

        String msg = request.getParameter("msg");
        if (StringUtils.isNotEmpty(msg)) {
            modelMap.addAttribute("msg", msg);
        }
        String url = getReqUrl();
        if (url.contains("edit")) {
            return "html/business/businessEdit";
        } else {
            return "html/business/businessShow";
        }
    }

    @RequestMapping("/doEdit")
    public String doEdit(BusinessForm form, ModelMap modelMap, RedirectAttributes ra, Byte callBargainByte) {
        if (callBargainByte != null) {
            form.getCallback().setCallBargain(callBargainByte);
        }
        int result = businessService.updateBusiness(form);
        ra.addAttribute("msg", result == 1 ? "更新成功！" : "更新失败！");
        ra.addAttribute("busiId", form.getBusiness().getId());
        return "redirect:/business/index";
    }

    /**
     * 获取分配人员列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/allot")
    public List<CrmAdmin> showClueAllot(CrmAdmin admin) {
        //查询归属人信息
        List<CrmAdmin> adminList = adminService.getOwerList(admin);
        return adminList;
    }

    /**
     * 分配线索
     *
     * @return
     */
    @RequestMapping("/distribution")
    @ResponseBody
    public String Distributionleads(CrmBusiness business, String cluds) {
        CrmAdmin user = getUser();
        ResultBean bean = new ResultBean();
        bean.setCode(1);
        bean.setMsg("分配成功！");
        try {
            String[] cludss = cluds.split(",");
            for (String s : cludss) {
                business.setId(Long.parseLong(s));
                business.setAllotTime(new Date());
                businessService.updateByPrimaryKeySelective(business);
                //保存分配记录
                CrmAllocationLog allocationLog = new CrmAllocationLog();
                allocationLog.setAlloAdmin(user.getId());
                allocationLog.setAlloOwner(business.getOwner());
                allocationLog.setAlloType(ReleTypeEnum.BUSINESS_TYPE.getCode());
                allocationLog.setTargetId(Long.parseLong(s));
                if (business.getOwner() != null) {
                    allocationLog.setAlloSource(business.getOwner());
                }
                allocationLogService.insertSelective(allocationLog);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            logger.error("分配商机时出错了！", e);
            bean.setCode(0);
            bean.setMsg("分配失败！");
        }
        return JSONObject.toJSONString(bean);
//        return "redirect:/business/index";
    }

    /**
     * 关闭商机
     *
     * @param busiId 要关闭的商机ID
     * @return
     */
    @RequestMapping("/close")
    public String closeClue(Long busiId, RedirectAttributes ra) {
        CrmBusiness business = new CrmBusiness();
        business.setId(busiId);
        business.setUpdateTime(new Date());
        business.setBusiStatus(BusinessStatusEnum.CLOSED.getCode());
        if (businessService.updateByPrimaryKeySelective(business) == 1) {
            ra.addAttribute("msg", "关闭成功");
        } else {
            ra.addAttribute("msg", "关闭失败");
        }

        return "redirect:/business/index";
    }

    /**
     * 审核商机
     *
     * @param busiId 要审核的商机ID
     * @param pass
     */
    @RequestMapping("/auditing")
    @ResponseBody
    public String auditingBusiness(Long busiId, Boolean pass, String remark) {
        boolean result = businessService.auditingBusiness(busiId, pass, remark);
        ResultBean resultBean = new ResultBean();
        if (result) {
            resultBean.setMsg("审核成功！");
            resultBean.setCode(1);
        } else {
            resultBean.setMsg("审核失败！");
            resultBean.setCode(0);
        }
        return JSONObject.toJSONString(resultBean);
    }

    /**
     * 生成产品合同
     *
     * @return
     */
    @RequestMapping(value = {"/productsContract", "/agentContract"})
    public String generateContract(Long busiId, ModelMap modelMap) {
        //查询商机信息
        CrmBusiness business = businessService.selectByPrimaryKey(busiId);
        if (getRequest().getRequestURI().contains("productsContract")) {
            business.setProductVersionList(productVersionService.getVersionListByBusiId(busiId));
        } else {
            business.setProductList(productService.getProductsByBusiId(busiId));
        }

        modelMap.addAttribute("business", business);
        CrmClue clue = clueService.selectByPrimaryKey(business.getClueId());
        modelMap.addAttribute("clue", clue);
        //查询该商机的联系人信息
        List<CrmCustomer> customerList = customerService.getCustlistByClueId(business.getId(), ReleTypeEnum.BUSINESS_TYPE.getCode());
        modelMap.addAttribute("customerList", customerList);

        //查询所有产品及套餐
        List<CrmProduct> productList = productService.getAllProductAndVersions();
        modelMap.addAttribute("productList", productList);
        //代理合同所用 begin
        //服务级别
        modelMap.addAttribute("serviceLevel", ServiceLevelEnum.toList());
        //类别
        modelMap.addAttribute("category", AgentCategoryEnum.toList());
        //代理商级别
        modelMap.addAttribute("agentLevel", AgentLevelEnum.toList());

        //代理合同所用 end

        modelMap.addAttribute("busiId", busiId);
        modelMap.addAttribute("currentDate", new Date());
        String url = getRequest().getRequestURI();
        return "html" + url.replace("C", "_c");
    }

    /**
     * 保存产品合同
     *
     * @return
     */
    @RequestMapping("/doProductsContract")
    public String doGenerateContract(@RequestParam(value = "file", required = false) MultipartFile[] files, ContractForm form, RedirectAttributes ra) {
        if (files != null && files.length > 0) {
            for (MultipartFile file : files) {
                logger.info(String.format("该文件名字为:%s,大小为:%s", file.getName(), getFileMB(file.getSize())));
                saveFile(form, file);
            }
        }


//        form.getContract().setContAccessoryName(fileName);
        boolean result = contractService.saveContract(form);
        if (result) {
            //生成合同成功时，该线索成交意向改为已完成
            logger.info("生成合同，系统自动关闭该源线索");
            callbackService.addFinshedStatus(form.getContract().getBusiId());
            ra.addAttribute("msg", "生成合同成功！");
        } else {
            ra.addAttribute("msg", "生成合同失败！");
        }

        return "redirect:/business/index";
    }

    private String getFileMB(long byteFile) {
        if (byteFile == 0)
            return "0MB";
        long mb = 1024 * 1024;
        return "" + byteFile / mb + "MB";
    }

    private void saveFile(ContractForm form, MultipartFile file) {
        CrmContractFile contractFile;
        contractFile = new CrmContractFile();
        String fileName = file.getOriginalFilename();
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        targetFile = new File(filePath + File.separator + fileName);
        try {
            file.transferTo(targetFile);
            contractFile.setFileName(fileName);
            contractFile.setFileType(FileTypeEnum.CONTRACT_FILE.getCode());
            contractFile.setCreatedAt(new Date());
            contractFile.setUpdatedAt(new Date());
            form.getContractFileList().add(contractFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
