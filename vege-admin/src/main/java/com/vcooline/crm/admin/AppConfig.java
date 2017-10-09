package com.vcooline.crm.admin;

import com.vcooline.crm.common.DataSourceConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;


@Configuration
@EnableAutoConfiguration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Import({DataSourceConfig.class, WebConfig.class, SecureConfig.class})
public class AppConfig {

}
