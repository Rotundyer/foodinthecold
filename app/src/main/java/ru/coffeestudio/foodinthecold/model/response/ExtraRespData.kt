package ru.coffeestudio.foodinthecold.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class ExtraRespData(

    @Expose
    @SerializedName("price_min")
    val priceMin: BigDecimal? = null,

    @Expose
    @SerializedName("price_max")
    val priceMax: BigDecimal? = null
)