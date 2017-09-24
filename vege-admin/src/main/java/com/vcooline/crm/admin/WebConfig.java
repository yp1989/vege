package com.vcooline.crm.admin;

import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;



import com.vcooline.crm.admin.web.filter.AppFilter;
import com.vcooline.crm.admin.web.filter.AuthUrlFilter;
import com.vcooline.crm.common.AbstractWebConfig;

@Configuration
@ComponentScan("com.vcooline.crm")
@EnableScheduling
public class WebConfig extends AbstractWebConfig {

    @Value("${app.static.cachePeriod}")
	private int cachePeriod;

	@Bean
	public FilterRegistrationBean appFilter() {
		FilterRegistrationBean reg = new FilterRegistrationBean();
		reg.setFilter(new AppFilter());
		reg.addUrlPatterns("/*");
		return reg;
	}

	@Bean
	public FilterRegistrationBean meshFilter() {
		//添加Sitemech Filter
		FilterRegistrationBean mesh = new FilterRegistrationBean();
		mesh.setFilter(new ConfigurableSiteMeshFilter());
		mesh.addUrlPatterns("/*");
		return mesh;
	}

	/**
	  * @Description:crm访问路径过滤
	  * @param @return    设定文件
	  * @return FilterRegistrationBean    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年8月4日 下午3:29:40
	  * 上海微客来软件技术有限公司
	 */
	@Bean
	public FilterRegistrationBean authUrlFilter(){
		FilterRegistrationBean authUrl = new FilterRegistrationBean();
		authUrl.setFilter(new AuthUrlFilter());
		authUrl.addUrlPatterns("/*");
		return authUrl;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("/WEB-INF/resources/").setCachePeriod(cachePeriod);
	}
}
