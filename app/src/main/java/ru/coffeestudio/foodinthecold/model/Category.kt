package ru.coffeestudio.foodinthecold.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Category(

    @Expose
    @SerializedName("id")
    val ID: Int,

    /** Наименование категории. */
    @Expose
    @SerializedName("title")
    val title: String = "",

    /** Идентификатор родителя категории.*/
    @Expose
    @SerializedName("parent_id")
    val parentID: Int? = null,

    /** Полный путь к исходному изображению категории. */
    @Expose
    @SerializedName("image")
    val image: String? = null,



    /** Возвращает «true», если категория является дочерним узлом,
     *  т.е. имеет хотя бы одного родителя (иначе «false»). */
    @Expose
    @SerializedName("is_child_node")
    val isChild: Boolean = false,

    /** Возвращает «true», если категория является конечным узлом,
     *  т.е. не имеет дочерних элементов (иначе «false»). */
    @Expose
    @SerializedName("is_leaf_node")
    val isLeaf: Boolean = false,

    /** Возвращает «true», если категория является корневым узлом,
     *  т.е. не имеет родительских элементов (иначе «false»). */
    @Expose
    @SerializedName("is_root_node")
    val isRoot: Boolean = false,




    /** Порядковый номер сортировки */
    @Expose
    @SerializedName("sort")
    val sort: Int? = null,

    @Expose
    @SerializedName("children")
    val children: List<Category>? = null
)