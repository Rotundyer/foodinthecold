package ru.coffeestudio.foodinthecold.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

// Checked ###
data class ActionResp (

    @Expose
    @SerializedName("id")
    var ID: Int
)