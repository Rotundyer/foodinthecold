package ru.coffeestudio.food.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.coffeestudio.foodinthecold.model.Category

data class CategoryList(

    @Expose
    @SerializedName("results")
    val results: List<Category>,

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