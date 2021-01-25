package ru.coffeestudio.food.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.coffeestudio.foodinthecold.db.entities.ProductEntity

@Dao
interface ProductDao {

    @Query("SELECT * FROM product")
    fun getProductList(): LiveData<List<ProductEntity>>

    @Query("SELECT * FROM product WHERE in_cart = :inCart")
    fun getCartList(inCart: Boolean = true): LiveData<List<ProductEntity>>

    @Query("SELECT * FROM product WHERE liked_list = :liked")
    fun getLikedList(liked: Boolean = true): LiveData<List<ProductEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProduct(product: ProductEntity)

    @Delete
    suspend fun removeProduct(product: ProductEntity)

    @Query("DELETE FROM product")
    suspend fun clear()
}