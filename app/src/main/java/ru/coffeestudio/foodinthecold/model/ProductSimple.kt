package ru.coffeestudio.foodinthecold.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

// Checked 05.08.20
data class ProductSimple(

    @Expose
    @SerializedName("id")
    val id: Int,

    /** Наименование товара. */
    @Expose
    @SerializedName("title")
    var title: String,

    /** Описание товара (может содержать HTML-код). */
    @Expose
    @SerializedName("description")
    var description: String? = null,

    /** Список идентификаторов категорий, которым принадлежит товар. */
    @Expose
    @SerializedName("categories")
    var categories: List<Int>? = null,

    /** Идентификатор бренда товара. */
    @Expose
    @SerializedName("brand_id")
    var brandID: Int? = null,

    /** Полный путь к превью изображения товара. */
    @Expose
    @SerializedName("image_preview")
    var imagePreview: String? = "",

    /** Код товара. */
    @Expose
    @SerializedName("extra_code")
    var productCode: String? = null,

    /** Штрихкод товара. */
    @Expose
    @SerializedName("barcode")
    var barcode: String? = null,

    /** Артикул товара. */
    @Expose
    @SerializedName("vendor_code")
    var vendorCode: String? = null,

    /** Текущий остаток товара */
    @Expose
    @SerializedName("quantity")
    var quantity: Int? = null,

    /** Базовая цена (без учёта скидок).
     *  Максимальная длина - 9 цифр, 2 знака после запятой. */
    @Expose
    @SerializedName("base_price")
    var priceBase: BigDecimal?,

    /** Итоговая цена (с учётом скидок).
     *  Максимальная длина - 9 цифр, 2 знака после запятой. */
    @Expose
    @SerializedName("price")
    var price: BigDecimal?,

    /** Размер скидки в процентах. Рассчитывается на основе разницы */
    @Expose
    @SerializedName("discount")
    var discount: Int? = null,

    /** Порядковый номер сортировки. */
    @Expose
    @SerializedName("sort")
    var sort: Int? = null,

    @Expose
    @SerializedName("detail")
    var error: String? = "",

    var liked: Boolean = false,

    var inCart: Boolean = false
)