package ru.coffeestudio.foodinthecold.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import ru.coffeestudio.foodinthecold.db.converter.BigDecimalDoubleTypeConverter
import java.math.BigDecimal

@TypeConverters(BigDecimalDoubleTypeConverter::class)
@Entity(tableName = "product")
data class ProductEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "title")
    var title: String = "",

    @ColumnInfo(name = "description")
    var description: String? = "",

//    @Expose
//    @SerializedName("categories")
//    var categories: List<Int>? = listOf(),

    @ColumnInfo(name = "image")
    var image: String? = "",

    @ColumnInfo(name = "image_preview")
    var imagePreview: String? = "",

    @ColumnInfo(name = "extra_code")
    var productCode: String? = "",

    @ColumnInfo(name = "bar_code")
    var barcode: String? = "",

    @ColumnInfo(name = "vendor_code")
    var vendorCode: String? = "",

    @ColumnInfo(name = "weight")
    var weight: Double? = 0.0,

    @ColumnInfo(name = "length")
    var length: Double? = 0.0,

    @ColumnInfo(name = "width")
    var width: Double? = 0.0,

    @ColumnInfo(name = "height")
    var height: Double? = 0.0,

    @ColumnInfo(name = "volume")
    var volume: Double? = 0.0,

    @ColumnInfo(name = "quantity")
    var quantity: Int? = 0,

    @ColumnInfo(name = "base_price")
    var priceBase: BigDecimal? = null,

    @ColumnInfo(name = "price")
    var price: BigDecimal? = null,

    @ColumnInfo(name = "discount")
    var discount: Int? = null,

    @ColumnInfo(name = "sort")
    var sort: Int? = 0,

    @ColumnInfo(name = "liked_list")
    var liked: Boolean = false,

    @ColumnInfo(name = "in_cart")
    var inCart: Boolean? = false
)