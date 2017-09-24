package com.vcooline.crm.admin.web.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vcooline.crm.common.constant.GlobalConstants;
import com.vcooline.crm.common.constant.WebUrlConstants;
import com.vcooline.crm.common.model.CrmAdmin;
import com.vcooline.crm.common.model.CrmAuth;

public class AuthUrlFilter implements Filter{

	private static final Logger logger = LoggerFactory.getLogger(AuthUrlFilter.class);
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		 HttpServletRequest req = (HttpServletRequest) request;
         HttpServletResponse res = (HttpServletResponse)response;
         String requestURI = req.getRequestURI();
         String contextPath = req.getContextPath();
         String path = requestURI.substring(contextPath.length());
         
         CrmAdmin admin = (CrmAdmin)req.getSession().getAttribute(GlobalConstants.USER);
         
         if(admin != null  && !path.contains("views")  && !path.contains("/static/admin")){
        	 List<CrmAuth> auths = (List<CrmAuth>)req.getSession().getAttribute(GlobalConstants.AUTH_URL_LIST);
        	 if("/".equals(path)){
        		 res.sendRedirect("/rootUrl");
        		 return;
     		 }
        	 if(isFreePage(path,auths)){
            	 chain.doFilter(request, response);
             }else{
            	 res.sendRedirect("/err");
            	 return;
             }
         }else{
        	 chain.doFilter(request, response);
         }
         
         
	}

	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	private Boolean isFreePage(String path,List<CrmAuth> auths){
		logger.info(path);
		if(auths != null && auths.size() != 0){
			for(CrmAuth auth: auths){
				if(auth.getAuthUrl() != null && !"".equals(auth.getAuthUrl()) 
						&& path.toLowerCase().contains(auth.getAuthUrl().toLowerCase())){
					 return true;
				}
				/*if(auth.getChildren() != null && auth.getChildren().size() != 0){
					for(CrmAuth authCh: auth.getChildren()){
						if(authCh.getAuthUrl() != null && !"".equals(authCh.getAuthUrl()) 
								&& path.toLowerCase().contains(authCh.getAuthUrl().toLowerCase())){
							 return true;
						}
					}
				}else{
					if(auth.getAuthUrl() != null && !"".equals(auth.getAuthUrl()) 
							&& path.toLowerCase().contains(auth.getAuthUrl().toLowerCase())){
						 return true;
					}
				}*/
				
			}
		}
		if (path.contains("druid")){
			return true;
		}
		return false;
		
	}
}
