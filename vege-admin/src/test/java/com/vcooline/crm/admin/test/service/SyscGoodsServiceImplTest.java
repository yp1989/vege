package com.vcooline.crm.admin.test.service;

import com.vcooline.crm.admin.WebConfig;
import com.vcooline.crm.admin.service.ISyscGoodsService;
import com.vcooline.crm.common.DataSourceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {DataSourceConfig.class, WebConfig.class})
@WebAppConfiguration
@IntegrationTest("server.port:3005")
public class SyscGoodsServiceImplTest {

    @Autowired
    private ISyscGoodsService syscGoodsService;


    @Test
    public void syscGoods() throws Exception {

        syscGoodsService.syscGoods();
    }

}