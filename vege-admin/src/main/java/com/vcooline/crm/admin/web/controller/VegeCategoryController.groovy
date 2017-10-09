package com.vcooline.crm.admin.web.controller

import com.vcooline.crm.admin.service.IVegeCategoryService
import com.vcooline.crm.common.model.VegeCategory
import com.vcooline.crm.common.pojo.ResultBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/category")
class VegeCategoryController {

    @Autowired
    private IVegeCategoryService vegeCategoryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    ResultBean<VegeCategory> getCategory(){
        List<VegeCategory> categoryList = vegeCategoryService.selectAllCategory(null)
        println categoryList.toString()
    }
}
