package com.vcooline.crm.common.utils;

import com.vcooline.crm.common.constant.GlobalConstants;
import com.vcooline.crm.common.model.CrmAdmin;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xinbaojian on 15/7/23.
 */
public class SessionUtils {

    public static CrmAdmin getUser(HttpServletRequest request){
        return (CrmAdmin)request.getSession().getAttribute(GlobalConstants.USER);
    }
}
