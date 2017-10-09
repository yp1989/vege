package com.vcooline.crm.admin.web.controller.cluemanager;

import com.alibaba.fastjson.JSONObject;
import com.vcooline.crm.admin.service.*;
import com.vcooline.crm.admin.web.controller.BaseController;
import com.vcooline.crm.common.enumutil.*;
import com.vcooline.crm.common.model.*;
import com.vcooline.crm.common.pojo.ClueAddForm;
import com.vcooline.crm.common.pojo.ClueCustPojo;
import com.vcooline.crm.common.pojo.ProductVersionForm;
import com.vcooline.crm.common.utils.DateUtil;
import com.vcooline.crm.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 线索管理Controller
 * Created by xinbaojian on 15/7/20.
 */
@Controller
@RequestMapping("/clue")
public class ClueManagerController extends BaseController {

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

    @Autowired
    private CrmBusinessService businessService;

    @RequestMapping("/index")
    public String index(CrmClue clue, Integer pageNo, Integer pageSize, ModelMap modelMap, HttpServletRequest request) {
        CrmAdmin admin = getUser();
        clue.setSearchType((byte) 0);
        if (admin.getRoleType() != 0 && admin.getRoleType() != 2) {
            if (admin.getIsDepManager() == null || admin.getIsDepManager() == 0) {
                clue.setIsDepManager((byte) 0);
            } else {
                clue.setIsDepManager(admin.getIsDepManager());

            }
        }
        //判断是否有时间条件查询，如果没有，默认只查2015年的数据
        if (clue.getCreateTimestart() == null && (admin.getRoleType() == 0 || admin.getRoleType() == 2)) {
            clue.setCreateTimestart(DateUtil.strToDate(String.format("%s-01 00:00:00", DateUtil.getCurrentYearMonthStr()), DateUtil.DEFAULT_FORMAT));
        }

        modelMap.addAttribute("clue", clue);
        Page<CrmClue> page = clueService.queryCrmClueForPage(clue, pageNo, pageSize);
        modelMap.addAttribute("page", page);

        //线索来源
        modelMap.addAttribute("ClueSource", ClueSourceEnum.toList());
        //了解方式
        modelMap.addAttribute("ClueKnow", ClueKnowEnum.toList());
        //咨询方式
        modelMap.addAttribute("ClueConsult", ClueConsultEnum.toList());
        //线索类型
        modelMap.addAttribute("ClueType", ClueTypeEnum.toList());
        //获取所有产品类型
        modelMap.addAttribute("products", productService.getAllProduct());
        //成交意向
        modelMap.addAttribute("dealIntention", DealintentionEnum.toList());
        //线索状态
        modelMap.addAttribute("clueStatusOnline", ClueStatusEnum.toList());

        //查询归属人信息
        List<CrmAdmin> adminList = adminService.getOwerList(admin);
        modelMap.addAttribute("adminList", adminList);
        String msg = request.getParameter("msg");
        if (StringUtils.isNotEmpty(msg)) {
            modelMap.addAttribute("msg", msg);
        }
        return "html/clue/clue";
    }

    @RequestMapping("/toAddClue")
    public String toAddClue(ModelMap model) {
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
        return "html/clue/clueAdd";

    }

    /**
     * 新增线索
     *
     * @param form
     * @param ra
     * @return
     */
    @RequestMapping("/doAddClue")
    public String doAddClue(ClueAddForm form, RedirectAttributes ra, Byte callBargainByte) {
        //设置用户录入人
        CrmAdmin admin = getUser();
        if (form.getClue().getId() == null) {
            form.setIsAllot(true);
            form.getClue().setAdminId(admin.getId());
            form.getClue().setAdminName(admin.getAdminRealName());
            boolean result = clueService.saveClue(form);
            ra.addAttribute("msg", result ? "新增成功！" : "新增失败！");
        } else {
            if (callBargainByte != null) {
                form.getCallback().setCallBargain(callBargainByte);
            }
            boolean result = clueService.updateClue(form);
            ra.addAttribute("msg", result ? "更新成功！" : "更新失败！");
        }

        return "redirect:/clue/index";
    }

    /**
     * 编辑线索
     *
     * @return
     */
    @RequestMapping(value = {"/toEditClue", "/toShowClue"})
    public String toEditClue(Long clueId, ModelMap modelMap) {
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
        modelMap.addAttribute("products", productService.getAllProduct());
        //成交意向
        modelMap.addAttribute("dealIntention", DealintentionEnum.toList());
        //线索状态
        modelMap.addAttribute("clueStatusOnline", ClueStatusEnum.toList());

        //获取该线索所关联产品
        modelMap.addAttribute("clueProducts", productService.getProductsByClueId(clueId));
        //角色
        modelMap.addAttribute("roles", CustRoleEnum.toList());
        //角色
        modelMap.addAttribute("rolesJson", CustRoleEnum.toJson());
        //查询归属人信息
        List<CrmAdmin> adminList = adminService.getOwerList(getUser());
        modelMap.addAttribute("adminList", adminList);
        modelMap.addAttribute("clue", clue);
        //查询该线索的联系人信息
        List<CrmCustomer> customerList = customerService.getCustlistByClueId(clueId, ReleTypeEnum.CLUE_TYPE.getCode());
        modelMap.addAttribute("customerList", customerList);
        //获取线索回访信息
        List<CrmCallback> callbackList = callbackService.selectCallBackListByClueId(clueId, ReleTypeEnum.CLUE_TYPE.getCode());
        modelMap.addAttribute("callbackList", callbackList);
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
        modelMap.addAttribute("optionLogList", optionLogList);
        modelMap.addAttribute("admin", getUser());

        String url = getReqUrl();
        System.out.println(url);
        if (url.contains("toEditClue")) {
            if (callbackList != null && callbackList.size() > 0) {
                modelMap.addAttribute("lastCallBargain", callbackList.get(callbackList.size() - 1).getCallBargain());
            }
            return "html/clue/clueEdit";
        } else {
            return "html/clue/clueShow";
        }
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
        admin = getUser();
        List<CrmAdmin> adminList = adminService.getOwerList(admin);
        return adminList;
    }

    /**
     * 分配线索
     *
     * @return
     */
    @RequestMapping("/distribution")
    public String Distributionleads(CrmClue clue, String cluds) {
        CrmAdmin user = getUser();
        String[] cludss = cluds.split(",");
        for (String s : cludss) {
//            CrmClue oldClue = clueService.selectByPrimaryKey(Long.parseLong(s));
            clue.setId(Long.parseLong(s));
            clue.setAllotTime(new Date());
            clue.setClueStatusOnline(ClueStatusEnum.ALLOCATED.getCode());
            clueService.updateByPrimaryKeySelective(clue);
            //保存分配记录
            CrmAllocationLog allocationLog = new CrmAllocationLog();
            allocationLog.setAlloAdmin(user.getId());
            allocationLog.setAlloOwner(clue.getOwner());
            allocationLog.setAlloType(ReleTypeEnum.CLUE_TYPE.getCode());
            allocationLog.setTargetId(Long.parseLong(s));
            if (clue.getOwner() != null) {
                allocationLog.setAlloSource(clue.getOwner());
            }
            allocationLogService.insertSelective(allocationLog);

        }
        return "redirect:/clue/index";
    }

    /**
     * 关闭线索
     *
     * @param clueId 要关闭的线索ID
     * @return
     */
    @RequestMapping("/close")
    @ResponseBody
    public String closeClue(Long clueId, RedirectAttributes ra) {
        String msg = "关闭失败";
        if (clueService.closeClue(clueId) == 1) {
            msg = "关闭成功";
        }
        return String.format("{\"msg\":\"%s\"}", msg);
    }

    /**
     * 根据手机号查询关联线索
     *
     * @param phone
     * @return
     */
    @RequestMapping("/queryByPhone")
    @ResponseBody
    public List<CrmClue> queryCrmClueByPhone(String phone) {
        List<CrmClue> clueList = clueService.queryCrmClueByPhone(phone);
        return clueList;
    }

    /**
     * 查询所有套餐
     *
     * @return
     */
    @RequestMapping("/queryProdVers")
    @ResponseBody
    public List<CrmProduct> queryPorductAndVersion() {
        List<CrmProduct> productList = productService.getAllProductAndVersions();
        return productList;
    }

    /**
     * 生成商机
     *
     * @return
     */
    @RequestMapping("/convertBusiness")
    public String convertBusinessFormClue(ProductVersionForm versionForm, RedirectAttributes ra) {
        int result = businessService.convertBusinessFormClue(versionForm.getClueId(), versionForm.getBusiProducts());
        if (result == 1) {
            ra.addAttribute("msg", "生成商机成功！");
        } else {
            ra.addAttribute("msg", "生成商机失败！");
        }
        return "redirect:/clue/index";
    }

    @RequestMapping("/import")
    @ResponseBody
    public String importClue(ClueCustPojo pojo) {
        CrmAdmin admin = new CrmAdmin();
        admin.setId(1l);
        admin.setAdminRealName("amdin");
        ClueAddForm form = new ClueAddForm();
        String msg = "导入成功!";
        Integer code = 1;

        if (pojo == null || StringUtils.isEmpty(pojo.getCustName())) {
            msg = "数据错误!";
            code = 0;
        }
        if (code == 1) {
            //设置线索默认数据
            Integer numCode = clueService.getMaxNumCode();
            form.setClue(new CrmClue());
            form.getClue().setClueNumber(StringUtils.generateClueNumber(numCode));
            form.getClue().setNumCode(numCode);
            form.getClue().setClueSource(ClueSourceEnum.SYS_SPLIT.getCode());
            form.getClue().setCustAddr(StringUtils.isEmpty(pojo.getCustAddr()) ? null : pojo.getCustAddr());
            form.getClue().setCustProvince(pojo.getCustProvince() == null ? null : pojo.getCustProvince());
            form.getClue().setCustCity(pojo.getCustCity() == null ? null : pojo.getCustCity());
            form.getClue().setCustArea(pojo.getCustArea() == null ? null : pojo.getCustArea());
            form.getClue().setCustName(StringUtils.isEmpty(pojo.getCustName()) ? null : pojo.getCustName());

            if (pojo.getClueKnow() == null) {
                form.getClue().setClueKnow(ClueKnowEnum.PC.getCode());
            } else {
                form.getClue().setClueKnow(pojo.getClueKnow());
            }

            if (pojo.getClueType() == null) {
                form.getClue().setClueType(ClueTypeEnum.PRODUCT.getCode());
            } else {
                form.getClue().setClueType(pojo.getClueType());
            }
            form.getClue().setAdminId(admin.getId());
            form.getClue().setAdminName(admin.getAdminRealName());
            form.getClue().setCreateTime(new Date());
            CrmCustomer customer = new CrmCustomer();
            List<CrmCustomer> list = new ArrayList<>();
            list.add(customer);
            form.setCustomerList(list);
            customer.setCustName(StringUtils.isEmpty(pojo.getUserName()) ? null : pojo.getUserName());
            customer.setCustRole((byte) 1);
            customer.setCustPhone(StringUtils.isEmpty(pojo.getCustPhone()) ? null : pojo.getCustPhone());
            customer.setCustQq(StringUtils.isEmpty(pojo.getCustQq()) ? null : pojo.getCustQq());
            customer.setCustEmail(StringUtils.isEmpty(pojo.getCustEmail()) ? null : pojo.getCustEmail());
            form.setProductIds(pojo.getProductIds());

            form.setCallback(new CrmCallback());
            //设置成交意向
            if (pojo.getCallBargain() != null) {
                form.getCallback().setCallBargain(pojo.getCallBargain());
            }

            if (!clueService.saveClueImport(form, admin)) {
                msg = "保存线索出错了！";
                code = 0;
            }

        }
        return String.format("{\"msg\":\"%s\",\"code\":%s}", msg, code);
    }


    @RequestMapping("/importbatch")
    @ResponseBody
    public String importCluebatch(ClueCustPojo pojo) {
        logger.info(String.format("接收到的参数为:%s", JSONObject.toJSONString(pojo)));
        //判断线索是否存在
        if (clueService.selectByClueId(pojo.getId()) != null) {
            return String.format("{\"msg\":\"%s\",\"code\":%s}", "已存在此线索", "0");
        }
        CrmAdmin admin = new CrmAdmin();
        admin.setId(1l);
        admin.setAdminRealName("amdin");
        ClueAddForm form = new ClueAddForm();
        String msg = "导入成功!";
        Integer code = 1;
        if (pojo == null) {
            msg = "数据错误!";
            code = 0;
        }
        if (code == 1) {
            //设置线索默认数据
            Integer numCode = clueService.getMaxNumCode();
            form.setClue(new CrmClue());
            form.getClue().setClueId(pojo.getId());
            form.getClue().setClueNumber(StringUtils.generateClueNumber(numCode));
            form.getClue().setNumCode(numCode);
            form.getClue().setClueSource(ClueSourceEnum.SYS_SPLIT.getCode());
            form.getClue().setCustAddr(StringUtils.isEmpty(pojo.getCustAddr()) ? null : pojo.getCustAddr());
            form.getClue().setCustProvince(pojo.getCustProvince() == null ? null : pojo.getCustProvince());
            form.getClue().setCustCity(pojo.getCustCity() == null ? null : pojo.getCustCity());
            form.getClue().setCustArea(pojo.getCustArea() == null ? null : pojo.getCustArea());
            form.getClue().setCustName(StringUtils.isEmpty(pojo.getCustName()) ? null : pojo.getCustName());
            form.getClue().setCreateTime(pojo.getCreateTime());
            if (StringUtils.isNotEmpty(pojo.getOwnerName())) {
                //根据真实姓名查询归属人
                CrmAdmin ownerName = adminService.selectAdminByRealName(pojo.getOwnerName().trim());
                if (ownerName != null) {
                    form.getClue().setOwner(ownerName.getId());
                    form.getClue().setOwnerName(ownerName.getAdminRealName());
                } else {
                    form.getClue().setOwner(admin.getId());
                    form.getClue().setOwnerName(admin.getAdminRealName());
                }
                form.getClue().setAllotTime(new Date());
                form.getClue().setClueStatusOnline(ClueStatusEnum.ALLOCATED.getCode());
            } else {
                form.getClue().setClueStatusOnline(ClueStatusEnum.NOT_ALLOCATED.getCode());
            }

            if (pojo.getClueKnow() == null) {
                form.getClue().setClueKnow(ClueKnowEnum.PC.getCode());
            } else {
                form.getClue().setClueKnow(pojo.getClueKnow());
            }

            if (pojo.getClueType() == null) {
                form.getClue().setClueType(ClueTypeEnum.PRODUCT.getCode());
            } else {
                form.getClue().setClueType(pojo.getClueType());
            }

            CrmCustomer customer = new CrmCustomer();
            List<CrmCustomer> list = new ArrayList<>();
            list.add(customer);
            form.setCustomerList(list);
            customer.setCustName(StringUtils.isEmpty(pojo.getUserName()) ? null : pojo.getUserName());
            customer.setCustRole((byte) 1);
            customer.setCustPhone(StringUtils.isEmpty(pojo.getCustPhone()) ? null : pojo.getCustPhone());
            customer.setCustQq(StringUtils.isEmpty(pojo.getCustQq()) ? null : pojo.getCustQq());
            customer.setCustEmail(StringUtils.isEmpty(pojo.getCustEmail()) ? null : pojo.getCustEmail());
            form.setProductIds(pojo.getProductIds());

            form.setCallback(new CrmCallback());
            form.setCallbackList(pojo.getCallbackList());
            //设置成交意向
            if (pojo.getCallBargain() != null && DealintentionEnum.getByCode(pojo.getCallBargain()) != null && form.getCallback() != null) {
                form.getCallback().setCallBargain(pojo.getCallBargain());
            }
            if (!clueService.saveClueImport(form, admin)) {
                msg = "保存线索出错了！";
                code = 0;
            }
        }
        return String.format("{\"msg\":\"%s\",\"code\":%s}", msg, code);
    }

}
