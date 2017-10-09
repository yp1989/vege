package com.vcooline.crm.admin.test.service;

import com.alibaba.fastjson.JSONObject;
import com.vcooline.crm.admin.WebConfig;
import com.vcooline.crm.admin.service.IVegeCategoryService;
import com.vcooline.crm.common.DataSourceConfig;
import com.vcooline.crm.common.model.VegeCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {DataSourceConfig.class, WebConfig.class})
@WebAppConfiguration
@IntegrationTest("server.port:3005")
public class VegeCategoryServiceImplTest {

    @Autowired
    private IVegeCategoryService vegeCategoryService;

    @Test
    public void selectAllCategory() throws Exception {
        List<VegeCategory> categoryList = vegeCategoryService.selectAllCategory(null);
        System.out.println(JSONObject.toJSONString(categoryList));
        System.out.println(categoryList.toString());

    }

}