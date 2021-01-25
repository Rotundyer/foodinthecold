package ru.coffeestudio.food.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProductImage(

    /** Заголовок изорбражения. */
    @Expose
    @SerializedName("title")
    val title: String?,

    /** Описание изображения. */
    @Expose
    @SerializedName("description")
    val description: String? = "",

    /** Полный путь к исходному изображению товара.*/
    @Expose
    @SerializedName("image")
    val image: String?,

    /** Полный путь к превью изображения товара.*/
    @Expose
    @SerializedName("image_preview")
    val imagePreview: String?,

    /** Порядковый номер сортировки.*/
    @Expose
    @SerializedName("sort")
    val sort: String?
)