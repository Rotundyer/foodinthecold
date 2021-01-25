package ru.coffeestudio.foodinthecold.db.converter

import androidx.room.TypeConverter
import java.math.BigDecimal

/** Используется только для одной валюты(рубль). В случае добавления новых валют
 * необходимо конвертировать BigDecimal в String.
 * Это не позволит использовать SUM, TOTAL и т.д.? , но добавит вариативности
 * при использовании валют с любым расположением разделительной точки */
class BigDecimalDoubleTypeConverter {

    @TypeConverter
    fun bigDecimalToDouble(input: BigDecimal?): Double {
        return input?.toDouble() ?: 0.0
    }

    @TypeConverter
    fun stringToBigDecimal(input: Double?): BigDecimal {
        if (input == null) return BigDecimal.ZERO
        return BigDecimal.valueOf(input) ?: BigDecimal.ZERO
    }
}

//class BigDecimalStringTypeConverter {
//
//    @TypeConverter
//    fun bigDecimalToString(input: BigDecimal?): String {
//        return input?.toPlainString() ?: ""
//    }
//
//    @TypeConverter
//    fun stringToBigDecimal(input: String?): BigDecimal {
//        if (input.isNullOrBlank()) return BigDecimal.valueOf(0.0)
//        return input.toBigDecimalOrNull() ?: BigDecimal.valueOf(0.0)
//    }
//}