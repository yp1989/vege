package com.vcooline.crm.common.pojo

import com.google.gson.annotations.SerializedName

class GoodsPojo {

    @SerializedName("category_id")
    private String categoryId;

    @SerializedName("caregory_name")
    private String categoryName;

    @SerializedName("Number")
    private String number;

    @SerializedName("Name")
    private String name;

    @SerializedName("barcode")
    private String barcode;

    @SerializedName("Unit")
    private String unit;

    @SerializedName("Expr1")
    private String price;

    @SerializedName("allow_weigh")
    private String allowWeigh;

    @SerializedName("shop_id")
    private String shopId;

    @SerializedName("shop_name")
    private String shopName;

    @SerializedName("seller_id")
    private String sellerId;

    @SerializedName("seller_name")
    private String sellerName;

    @SerializedName("creation_time")
    private String creationTime;

    @SerializedName("update_time")
    private String updateTime;

    @SerializedName("place_of_origin")
    private String placeOfOrigin;

    @SerializedName("specification")
    private String specification;

    @SerializedName("grade")
    private String grade;

    @SerializedName("promotion_flag")
    private String promotionFlag;

    @SerializedName("promotion_price")
    private String promotionPrice;

    @SerializedName("promo_time_from")
    private String promoTimeFrom;

    @SerializedName("promo_time_to")
    private String promoTimeTo;

    @SerializedName("trace_code")
    private String traceCode;

}
