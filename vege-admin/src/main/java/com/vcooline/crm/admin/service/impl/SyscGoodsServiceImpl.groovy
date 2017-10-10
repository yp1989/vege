package com.vcooline.crm.admin.service.impl

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.vcooline.crm.admin.service.ISyscGoodsService
import com.vcooline.crm.admin.service.IVegeCategoryService
import com.vcooline.crm.common.model.VegeCategory
import com.vcooline.crm.common.pojo.GoodsPojo
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
    private IVegeCategoryService vegeCategoryService;

    @Override
    void syscGoods() {
        println "this is sysc goods test.."
        println url
        String jsonData = HttpRequestUtil.sendGet(url, null)
        Gson gson = new Gson()
        List<GoodsPojo> goodsPojoList = gson.fromJson(jsonData, new TypeToken<List<GoodsPojo>>(){}.getType())
        VegeCategory category = null
        for (GoodsPojo pojo : goodsPojoList) {
            category = new VegeCategory()
            category.categoryName = pojo.categoryName
            category.setSysCompanyId(1)
            vegeCategoryService.saveOrUpdate(category)
        }
    }
}
