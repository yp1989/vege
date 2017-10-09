package com.vcooline.crm.admin.test.controller;

import com.vcooline.crm.admin.WebConfig;
import com.vcooline.crm.common.DataSourceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {DataSourceConfig.class, WebConfig.class})
@WebAppConfiguration
@IntegrationTest("server.port:3005")
public class VegeCategoryControllerTest {
    @Test
    public void getCategory() throws Exception {

    }

}