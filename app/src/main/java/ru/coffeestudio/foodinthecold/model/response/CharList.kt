package ru.coffeestudio.foodinthecold.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CharList(

    @Expose
    @SerializedName("results")
    val results: List<Char>?,

    @Expose
    @SerializedName("count")
    val quantity: Int?,

    @Expose
    @SerializedName("extra")
    val extra: ExtraRespData?,

//    @Expose
    @SerializedName("detail")
    val error: String?
)