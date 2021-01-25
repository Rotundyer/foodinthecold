package ru.coffeestudio.foodinthecold.view.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharValue(

    /** Исходное значение характеристики. Используется при выполнении
     * фильтрации каталога по динамическим характеристикам. */
    @Expose
    @SerializedName("value")
    var value: Int,

    /** Отформатированное человекпонятное значение характеристики */
    @Expose
    @SerializedName("formatted")
    var formatted: String,

    /** Порядковый номер сортировки значения */
    @Expose
    @SerializedName("sort")
    var sort: Int,

    var selected: Boolean

): Parcelable