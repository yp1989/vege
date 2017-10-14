package com.vcooline.crm.admin.web.api

import com.vcooline.crm.admin.service.IVegeCategoryService
import com.vcooline.crm.common.model.VegeCategory
import com.vcooline.crm.common.pojo.ResultBean
import groovy.json.JsonBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/category")
class VegeCategoryController {

    @Autowired
    private IVegeCategoryService vegeCategoryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String getCategory(){
        ResultBean<List<VegeCategory>> resultBean = new ResultBean<>();
        List<VegeCategory> categoryList = vegeCategoryService.selectAllCategory(null)
        new JsonBuilder(resultBean.success(categoryList)).toPrettyString()
    }
}
