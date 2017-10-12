package com.vcooline.crm.admin.service.impl

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.vcooline.crm.admin.service.ISyscGoodsService
import com.vcooline.crm.admin.service.IVegeCategoryService
import com.vcooline.crm.admin.service.IVegeProductService
import com.vcooline.crm.common.model.VegeCategory
import com.vcooline.crm.common.model.VegeProdect
import com.vcooline.crm.common.model.VegeProdectWithBLOBs
import com.vcooline.crm.common.pojo.GoodsPojo
import com.vcooline.crm.common.utils.DateUtil
import com.vcooline.crm.common.utils.HttpRequestUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class SyscGoodsServiceImpl implements ISyscGoodsService{

    @Value('${sysc.goods.url}')
    private String url

    @Autowired
    private IVegeCategoryService vegeCategoryService

    @Autowired
    private IVegeProductService vegeProductService

    @Override
    void syscGoods() {
        println "this is sysc goods test.."
        println url
        String jsonData = HttpRequestUtil.sendGet(url, null)
        Gson gson = new Gson()
        List<GoodsPojo> goodsPojoList = gson.fromJson(jsonData, new TypeToken<List<GoodsPojo>>(){}.getType())
        VegeCategory category
        VegeProdectWithBLOBs product
        for (GoodsPojo pojo : goodsPojoList) {
            category = new VegeCategory()
            category.categoryName = pojo.categoryName
            category.setSysCompanyId(1)//TODO companyId
            vegeCategoryService.saveOrUpdate(category)

            product = convertFromGoodsPojo(pojo)
            product.categoryId = category.id
            println category.id
            vegeProductService.saveOrUpdate(product)
        }
    }


    private VegeProdectWithBLOBs convertFromGoodsPojo(GoodsPojo pojo){
        VegeProdectWithBLOBs product = new VegeProdectWithBLOBs()
        product.caregoryName = pojo.categoryName
        product.number = pojo.number
        product.name = pojo.name
        product.barcode = pojo.barcode
        product.unit = pojo.unit
        product.price = Double.parseDouble(pojo.price)
        product.allowWeigh = pojo.allowWeigh
        product.shopId = pojo.shopName
        product.sellerId = pojo.sellerId
        product.sellerName = pojo.sellerName
        product.creationTime = DateUtil.strToDate(pojo.creationTime, DateUtil.DEFAULT_T_FORMAT)
        product.updateTime = DateUtil.strToDate(pojo.updateTime, DateUtil.DEFAULT_T_FORMAT)
        product.placeOfOrigin = pojo.placeOfOrigin
        product.specification = pojo.specification
        product.grade = pojo.grade
        product.promotionFlag = pojo.promotionFlag
        product.promotionPrice = pojo.promotionPrice
        product.promoTimeFrom = DateUtil.strToDate(pojo.promoTimeFrom, DateUtil.DEFAULT_T_FORMAT)
        product.promoTimeTo = DateUtil.strToDate(pojo.promoTimeTo, DateUtil.DEFAULT_T_FORMAT)
        product.traceCode = pojo.traceCode
        product
    }

}
