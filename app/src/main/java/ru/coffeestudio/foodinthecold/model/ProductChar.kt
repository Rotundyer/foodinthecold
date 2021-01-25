package ru.coffeestudio.food.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductChar(

    @Expose
    @SerializedName("characteristic_id")
    val id: Int?,

    /** Наименование характеристики. */
    @Expose
    @SerializedName("characteristic_title")
    val title: String? = "",

    /** Исходное значение характеристики.*/
    @Expose
    @SerializedName("value")
    val value: String?,

    /** Отформатированное человекпонятное значение характеристики.*/
    @Expose
    @SerializedName("formatted")
    val valueFormatted: String?
): Parcelable