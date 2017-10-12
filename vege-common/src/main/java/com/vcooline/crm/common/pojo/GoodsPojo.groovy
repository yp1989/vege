package com.vcooline.crm.common.pojo

import com.google.gson.annotations.SerializedName

class GoodsPojo {

    @SerializedName("category_id")
    private String categoryId

    @SerializedName("caregory_name")
    private String categoryName

    @SerializedName("Number")
    private String number

    @SerializedName("Name")
    private String name

    @SerializedName("barcode")
    String barcode

    @SerializedName("Unit")
    String unit

    @SerializedName("Expr1")
    String price

    @SerializedName("allow_weigh")
    String allowWeigh

    @SerializedName("shop_id")
    String shopId

    @SerializedName("shop_name")
    String shopName

    @SerializedName("seller_id")
    String sellerId

    @SerializedName("seller_name")
    String sellerName

    @SerializedName("creation_time")
    String creationTime

    @SerializedName("update_time")
    String updateTime

    @SerializedName("place_of_origin")
    String placeOfOrigin

    @SerializedName("specification")
    String specification

    @SerializedName("grade")
    String grade

    @SerializedName("promotion_flag")
    String promotionFlag

    @SerializedName("promotion_price")
    String promotionPrice

    @SerializedName("promo_time_from")
    String promoTimeFrom

    @SerializedName("promo_time_to")
    String promoTimeTo

    @SerializedName("trace_code")
    String traceCode


}
