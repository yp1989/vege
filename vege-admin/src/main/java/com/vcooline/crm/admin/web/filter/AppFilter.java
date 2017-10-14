package com.vcooline.crm.admin.web.filter;

import com.vcooline.crm.common.constant.GlobalConstants;
import com.vcooline.crm.common.model.CrmAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AppFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(AppFilter.class);

    @Override
    public void destroy() {
        // TODO
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String requestURI = req.getRequestURI();
        String contextPath = req.getContextPath();
        String path = requestURI.substring(contextPath.length());
        logger.info("request path:" + path);
        CrmAdmin admin = (CrmAdmin) req.getSession().getAttribute(GlobalConstants.USER);

        if (!path.contains("/api/") && admin == null && !path.toLowerCase().contains("login")
                && !path.contains("/static/admin")
                && !path.toLowerCase().contains("import")) {
            res.sendRedirect("/login");
            return;
        } else {
            chain.doFilter(request, response);
            return;
        }

    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        //TODO
    }
}
