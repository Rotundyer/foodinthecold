package ru.coffeestudio.foodinthecold.view.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BannerItem(

    @Expose
    @SerializedName("banner_id")
    val id: Int,

    @Expose
    @SerializedName("title")
    val title: String? = "",

    @Expose
    @SerializedName("image")
    val image: Int
)