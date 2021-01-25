package ru.coffeestudio.foodinthecold.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.coffeestudio.foodinthecold.model.ProductSimple

data class ProductListSimple(

    @Expose
    @SerializedName("results")
    val results: List<ProductSimple>?,

    @Expose
    @SerializedName("count")
    val quantity: Int?,

    @Expose
    @SerializedName("next")
    val next: String?,

    @Expose
    @SerializedName("previous")
    val prev: String?,

    @Expose
    @SerializedName("detail")
    val error: String?
)