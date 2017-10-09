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
    private String barcode

    @SerializedName("Unit")
    private String unit

    @SerializedName("Expr1")
    private String price

    @SerializedName("allow_weigh")
    private String allowWeigh

    @SerializedName("shop_id")
    private String shopId

    @SerializedName("shop_name")
    private String shopName

    @SerializedName("seller_id")
    private String sellerId

    @SerializedName("seller_name")
    private String sellerName

    @SerializedName("creation_time")
    private String creationTime

    @SerializedName("update_time")
    private String updateTime

    @SerializedName("place_of_origin")
    private String placeOfOrigin

    @SerializedName("specification")
    private String specification

    @SerializedName("grade")
    private String grade

    @SerializedName("promotion_flag")
    private String promotionFlag

    @SerializedName("promotion_price")
    private String promotionPrice

    @SerializedName("promo_time_from")
    private String promoTimeFrom

    @SerializedName("promo_time_to")
    private String promoTimeTo

    @SerializedName("trace_code")

    private String traceCode

    String getCategoryId() {
        return categoryId
    }

    void setCategoryId(String categoryId) {
        this.categoryId = categoryId
    }

    String getCategoryName() {
        return categoryName
    }

    void setCategoryName(String categoryName) {
        this.categoryName = categoryName
    }

    String getNumber() {
        return number
    }

    void setNumber(String number) {
        this.number = number
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    String getBarcode() {
        return barcode
    }

    void setBarcode(String barcode) {
        this.barcode = barcode
    }

    String getUnit() {
        return unit
    }

    void setUnit(String unit) {
        this.unit = unit
    }

    String getPrice() {
        return price
    }

    void setPrice(String price) {
        this.price = price
    }

    String getAllowWeigh() {
        return allowWeigh
    }

    void setAllowWeigh(String allowWeigh) {
        this.allowWeigh = allowWeigh
    }

    String getShopId() {
        return shopId
    }

    void setShopId(String shopId) {
        this.shopId = shopId
    }

    String getShopName() {
        return shopName
    }

    void setShopName(String shopName) {
        this.shopName = shopName
    }

    String getSellerId() {
        return sellerId
    }

    void setSellerId(String sellerId) {
        this.sellerId = sellerId
    }

    String getSellerName() {
        return sellerName
    }

    void setSellerName(String sellerName) {
        this.sellerName = sellerName
    }

    String getCreationTime() {
        return creationTime
    }

    void setCreationTime(String creationTime) {
        this.creationTime = creationTime
    }

    String getUpdateTime() {
        return updateTime
    }

    void setUpdateTime(String updateTime) {
        this.updateTime = updateTime
    }

    String getPlaceOfOrigin() {
        return placeOfOrigin
    }

    void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin
    }

    String getSpecification() {
        return specification
    }

    void setSpecification(String specification) {
        this.specification = specification
    }

    String getGrade() {
        return grade
    }

    void setGrade(String grade) {
        this.grade = grade
    }

    String getPromotionFlag() {
        return promotionFlag
    }

    void setPromotionFlag(String promotionFlag) {
        this.promotionFlag = promotionFlag
    }

    String getPromotionPrice() {
        return promotionPrice
    }

    void setPromotionPrice(String promotionPrice) {
        this.promotionPrice = promotionPrice
    }

    String getPromoTimeFrom() {
        return promoTimeFrom
    }

    void setPromoTimeFrom(String promoTimeFrom) {
        this.promoTimeFrom = promoTimeFrom
    }

    String getPromoTimeTo() {
        return promoTimeTo
    }

    void setPromoTimeTo(String promoTimeTo) {
        this.promoTimeTo = promoTimeTo
    }

    String getTraceCode() {
        return traceCode
    }

    void setTraceCode(String traceCode) {
        this.traceCode = traceCode
    }
}
