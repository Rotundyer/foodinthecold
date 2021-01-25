package ru.coffeestudio.foodinthecold.util

import ru.coffeestudio.foodinthecold.db.entities.ProductEntity
import ru.coffeestudio.foodinthecold.model.Category
import ru.coffeestudio.foodinthecold.model.CharValue

interface ClickableItem {
    fun onItemClick(itemID: Int)
}

interface ClickableCharItem {
    fun onItemClick(char: Char)
}

interface CheckableItem {
    fun onItemChecked(itemID: Int)
    fun onItemUnchecked(itemID: Int)
}

interface CheckableFilterItem {
    fun onItemChecked(char: Char)
    fun onItemUnchecked(char: Char)
}

interface CheckableValueItem {
    fun onItemChecked(value: CharValue)
    fun onItemUnchecked(value: CharValue)
}

interface LikableItem {
//    fun onItemLiked(itemID: Int)
    fun onItemLiked(product: ProductEntity)
}

// TODO: 11.06.2020 LOl. It's not a production name, obviously
// TODO: 11.06.2020 Заменить на что-то подходящее по смыслу
interface CartableItem {
//    fun onItemCarted(itemID: Int)
    fun onItemCarted(product: ProductEntity)
}

interface CountableItem {
    fun onItemPlus(itemID: Int)
    fun onItemMinus(itemID: Int)
}

interface DeletableItem {
    fun onItemDeleted(product: ProductEntity)
//    fun onItemDeleted(itemID: Int)
}

interface CategoryListener {
    fun onCategorySelect(category: Category)
}

interface LikedItem : ClickableItem, CartableItem, DeletableItem

interface CartedItem : ClickableItem, LikableItem, DeletableItem, CountableItem