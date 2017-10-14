package com.vcooline.crm.admin.web.api

import com.vcooline.crm.admin.service.IVegeProductService
import com.vcooline.crm.common.model.VegeProdectWithBLOBs
import com.vcooline.crm.common.pojo.ResultBean
import groovy.json.JsonBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/api')
class VegeProductController extends BaseApiController{

    @Autowired
    private IVegeProductService productService

    @RequestMapping(value = '/category/{id}/products')
    String getProductListByCategoryId(@PathVariable("id") Integer categoryId){
        println categoryId
        List<VegeProdectWithBLOBs> productWithBLOBs = productService.getAllListByCategoryId(categoryId)
        ResultBean<List<VegeProdectWithBLOBs>> resultBean = new ResultBean<>()
        new JsonBuilder(resultBean.success(productWithBLOBs)).toPrettyString()
    }
}
