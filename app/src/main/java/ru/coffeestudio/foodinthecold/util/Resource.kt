package ru.coffeestudio.foodinthecold.util

data class Resource<T> (
    val status: Status,
    val data: T? = null,
    val errMessage: String? = null
)

enum class Status {
    OK, ERROR, LOADING
}