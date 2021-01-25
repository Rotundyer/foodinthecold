package ru.coffeestudio.foodinthecold.api

import retrofit2.Call
import retrofit2.http.*
import ru.coffeestudio.food.model.response.CategoryList
import ru.coffeestudio.food.model.response.ProductList
import ru.coffeestudio.foodinthecold.model.Category
import ru.coffeestudio.foodinthecold.model.Product
import ru.coffeestudio.foodinthecold.model.response.ActionResp
import ru.coffeestudio.foodinthecold.model.response.CharList
import ru.coffeestudio.foodinthecold.model.response.ProductListSimple

interface API {

    /** Возвращает список продуктов, отфильтрованный по product_id */
    @GET("products/{id}/")
    fun getProduct(
        @Path("id") ID: Int,
        @Query("access-token") appToken: String
    ): Call<Product>

    @GET("products/simple/")
    fun getProductList(
        @QueryMap params: HashMap<String, String>,
        @QueryMap filters: HashMap<String, String>
    ): Call<ProductListSimple>

    @GET("products/")
    fun getProductDetailedList(
        @QueryMap params: HashMap<String, String>
    ): Call<ProductList>

    @GET("categories/{id}/")
    fun getCategory(
        @Path("id") ID: Int
    ): Call<Category>

    @GET("categories/")
    fun getCategories(
        @QueryMap params: HashMap<String, String>
    ): Call<CategoryList>

    @GET("categories/hierarchy/{id}/")
    fun getCategoriesHierarchyForCategory(
        @Path("id") ID: Int
    ): Call<Category>

    @GET("categories/hierarchy/")
    fun getCategoriesHierarchy(
        @QueryMap params: HashMap<String, String>
    ): Call<CategoryList>

    @GET("characteristics/{id}/")
    fun getCharacteristic(
        @Path("id") ID: Int
    ): Call<Char>

    @GET("characteristics/")
    fun getChars(
        @QueryMap params: HashMap<String, String>
    ): Call<CharList>

    /** **************************************************************** ********************8***/


    // TODO: Test implementation
    @GET("cart/")
    fun getTestProductList(
        @QueryMap params: HashMap<String, String>
    ): Call<ProductList>

    // TODO: Test implementation
    @POST("cart/add")
    @FormUrlEncoded
    fun addTestProduct(
//        @FieldMap params: HashMap<String, String>
        @Field("id") productID: Int
    ): Call<ActionResp>

    // TODO: Test implementation
    @POST("cart/add")
    @FormUrlEncoded
    fun removeTestProduct(
//        @FieldMap params: HashMap<String, String>
        @Field("id") productID: Int
    ): Call<ActionResp>

    // TODO: Test implementation
    @POST("cart/add")
    @FormUrlEncoded
    fun clearTestProductList(
//        @FieldMap params: HashMap<String, String>
        @Field("id") productID: Int
    ): Call<ActionResp>


}