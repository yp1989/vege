package com.vcooline.crm.admin.web.controller;

import com.vcooline.crm.admin.service.impl.CrmAdminServiceImpl;
import com.vcooline.crm.common.exception.ServiceProcessException;
import com.vcooline.crm.common.model.CrmAdmin;
import com.vcooline.crm.common.model.CrmAuth;
import com.vcooline.crm.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 管理员登录
 *
 * @author caohuan
 * @ClassName: LoginController
 * @date 2015年7月22日 上午11:26:04
 * 上海微客来软件技术有限公司
 */
@Controller
public class LoginController extends BaseController {

    @Autowired
    private CrmAdminServiceImpl crmAdminServiceImpl;

    /**
     * @return String    返回类型
     * @throws
     * @Description:系统登录页
     * @author caohuan
     * @date 2015年7月22日 上午11:37:48
     * 上海微客来软件技术有限公司
     */
    @RequestMapping("/login")
    public String indexPage() {
        return "html/login";
    }

    @RequestMapping("/err")
    public String errPage() {
        return "err";
    }

    @RequestMapping("rootUrl")
    public String rootUrl() {
        if (getSession().getAttribute("authList") != null) {
            List<CrmAuth> auths = (List<CrmAuth>) getSession().getAttribute("authList");
            if (auths != null && auths.size() > 0) {
                for (CrmAuth auth : auths) {
                    //如果菜单权限下有子菜单，则获取子菜单的第一个
                    if (StringUtils.isEmpty(auth.getAuthUrl()) && auth.getChildren() != null) {
                        for (CrmAuth authChild : auth.getChildren()) {
                            return "redirect:" + authChild.getAuthUrl();
                        }

                    } else {
                        return "redirect:" + auth.getAuthUrl();
                    }
                }
            }
        }
        return "redirect:/login";
    }

    /**
     * @param @param  admin
     * @param @param  request
     * @param @return 设定文件
     * @return String    返回类型
     * @throws
     * @Description:用户登录
     * @author caohuan
     * @date 2015年7月22日 下午2:22:39
     * 上海微客来软件技术有限公司
     */
    @RequestMapping("doLogin")
    public String login(CrmAdmin admin, HttpServletRequest request) {
        String message = null;
        try {
            message = crmAdminServiceImpl.adminLogin(admin);
        } catch (ServiceProcessException e) {
            logger.info("用户登录" + e);
        }
        if ("0".equals(message)) {
            if (getSession().getAttribute("authList") != null) {
                List<CrmAuth> auths = (List<CrmAuth>) getSession().getAttribute("authList");
                if (auths != null && auths.size() > 0) {
                    for (CrmAuth auth : auths) {
                        //如果菜单权限下有子菜单，则获取子菜单的第一个
                        if (StringUtils.isEmpty(auth.getAuthUrl()) && auth.getChildren() != null) {
                            for (CrmAuth authChild : auth.getChildren()) {
                                return "redirect:" + authChild.getAuthUrl();
                            }

                        } else {
                            return "redirect:" + auth.getAuthUrl();
                        }
                    }
                }
            }

        }
        return "redirect:/login";
    }

    /**
     * @param request
     * @param @return 设定文件
     * @return String    返回类型
     * @throws
     * @Description:用户退出
     * @author caohuan
     * @date 2015年7月22日 下午2:22:39
     * 上海微客来软件技术有限公司
     */
    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();

        return "redirect:/login";
    }

    /**
     * @return String    返回类型
     * @throws
     * @Description：修改密码页面
     * @author caohuan
     * @date 2015年7月29日 上午10:01:34
     * 上海微客来软件技术有限公司
     */
    @RequestMapping("updatePasswordPage")
    public String updatePasswordPage() {
        return "html/auth/updatePassword";
    }

    /**
     * @param @param  admin
     * @param @return 设定文件
     * @return String    返回类型
     * @throws
     * @Description:验证用户输入的旧密码
     * @author caohuan
     * @date 2015年7月29日 上午9:42:22
     * 上海微客来软件技术有限公司
     */
    @ResponseBody
    @RequestMapping("checkPassword")
    public Boolean checkPassword(String adminPassword) {
        Boolean flag = crmAdminServiceImpl.checkPassword(adminPassword);
        return flag;
    }

    /**
     * @param admin
     * @return String    返回类型
     * @throws
     * @Description:保存修改密码
     * @author caohuan
     * @date 2015年7月29日 上午10:47:12
     * 上海微客来软件技术有限公司
     */
    @RequestMapping("savaUpdatePassword")
    public String savaUpdatePassword(CrmAdmin admin) {
        crmAdminServiceImpl.savaUpdatePassword(admin);
        return "redirect:/callcenter/index";
    }
}
