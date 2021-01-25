package ru.coffeestudio.foodinthecold.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.coffeestudio.food.model.ProductChar
import ru.coffeestudio.food.model.ProductImage
import java.math.BigDecimal

data class Product(

    @Expose
    @SerializedName("id")
    val id: Int,

    /** Наименование товара. */
    @Expose
    @SerializedName("title")
    var title: String = "",

    /** Описание товара (может содержать HTML-код). */
    @Expose
    @SerializedName("description")
    var description: String? = "",

    /** Список идентификаторов категорий, которым принадлежит товар. */
    @Expose
    @SerializedName("categories")
    var categories: List<Int>? = listOf(),

    /** Идентификатор бренда товара. */
    @Expose
    @SerializedName("brand_id")
    var brandID: Int? = null,

    /** Полный путь к исходному изображению товара. */
    @Expose
    @SerializedName("image")
    var image: String? = null,

    /** Полный путь к превью изображения товара. */
    @Expose
    @SerializedName("image_preview")
    var imagePreview: String? = null,

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




    /** Вес товара. */
    @Expose
    @SerializedName("weight")
    var weight: Double? = 0.0,

    /** Длина товара. */
    @Expose
    @SerializedName("length")
    var length: Double? = 0.0,

    /** Ширина товара. */
    @Expose
    @SerializedName("width")
    var width: Double? = 0.0,

    /** Высота товара. */
    @Expose
    @SerializedName("height")
    var height: Double? = 0.0,

    /** Объем товара. */
    @Expose
    @SerializedName("volume")
    var volume: Double? = 0.0,

    /** Текущий остаток товара */
    @Expose
    @SerializedName("quantity")
    var quantity: Int? = 0,

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
    var discount: Int?,

    /** Порядковый номер сортировки. */
    @Expose
    @SerializedName("sort")
    var sort: Int? = 0,

    @Expose
    @SerializedName("images")
    var images: List<ProductImage>? = listOf(),

    @Expose
    @SerializedName("values")
    var characteristics: List<ProductChar>? = listOf(),

    var liked: Boolean = false,

    var inCart: Boolean = false,

    @Expose
    @SerializedName("detail")
    var error: String? = ""
)