package com.no.aka.baseprojectkotlin.model

import com.google.gson.annotations.SerializedName

data class ProductSale(
    @SerializedName("title")
    var title: String? = "",

    @SerializedName("price")
    var price: Int? = 0,

    @SerializedName("price_sale")
    var priceSale: Int? = 0,

    @SerializedName("time_sale")
    var timeSale: Long? = 0,

    @SerializedName("image")
    var image: String? = ""
)