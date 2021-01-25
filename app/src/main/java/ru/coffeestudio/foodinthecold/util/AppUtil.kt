package ru.coffeestudio.food.util

import android.content.Context
import android.os.Build
import android.util.Base64
import android.view.HapticFeedbackConstants
import android.view.HapticFeedbackConstants.CONTEXT_CLICK
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.request.RequestOptions
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.coffeestudio.foodinthecold.R
import ru.coffeestudio.foodinthecold.api.API
import ru.coffeestudio.foodinthecold.api.BasicAuthInterceptor
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*



/** Для кабелей */
//const val BASE_URL: String = "http://coffeeshop.servertest.pro/api/"
//const val BASE_URL_MEDIA: String = "http://test.servertest.pro"
//const val APP_TOKEN: String = "TOBTMPNY4DZU6SNB"

/** Для corco */
const val APP_TOKEN: String = "VHCYILFS29Q0K7Z2"
const val BASE_URL: String = "http://zoo-terra.servertest.pro/api/"
const val BASE_URL_MEDIA: String = "http://zoo-terra.servertest.pro"

const val APP_PREFERENCES: String = "ru.coffeestudio.store.preferences"
const val USER_TOKEN_PREFS: String = "ru.coffeestudio.store.user_token"

fun initApi(): API {
    return RetroFactory.getAPI()
}

object RetroFactory {
    fun getAPI(): API {

        val gson = GsonBuilder()
            .setDateFormat(DateFormat.FULL, DateFormat.FULL)
            .excludeFieldsWithoutExposeAnnotation()
            .setLenient()
            .create()

        val client = OkHttpClient.Builder()
            .addInterceptor(BasicAuthInterceptor("coffee", "coffee"))
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit.create(API::class.java)
    }
}

// TODO: 01.07.2020 Not implemented
fun isAuth():Boolean = true

fun showKeyboard(view: View) {
    view.post {
        val inputManager
                = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
    }
}

fun hideKeyboard(view: View) {
    view.post {
        val inputManager
                = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

fun formatDate(date: Date, pattern: String = "dd MMMM yyyy") : String {
    val dateFormat = SimpleDateFormat(pattern, Locale.getDefault())
    return dateFormat.format(date)
}

//TEST_IMPLEMENTATION
fun formatTime(date: Date, pattern: String = "hh:mm") : String {
    val dateFormat = SimpleDateFormat(pattern, Locale.getDefault())
    return dateFormat.format(date)
}

fun glideDebugInit(image: String): GlideUrl {
    val credentials = "coffee:coffee"
    val auth = "Basic " + Base64.encodeToString(
        credentials.toByteArray(),
        Base64.NO_WRAP
    )

    return GlideUrl(
        image, LazyHeaders.Builder()
            .addHeader("Content-Type", "application/json")
            .addHeader("Authorization", auth)
            .build()
    )
}

fun setPhoto(photoPath: String?, imageView: ImageView, isRound: Boolean = false) {
//    val imagePath = BASE_URL_MEDIA + photoPath

//    if(photoPath.isNullOrBlank())
    val ro = RequestOptions()
//    ro.placeholder(R.drawable.no_image)
    ro.error(R.drawable.no_image)

    if(isRound)
        ro.circleCrop()

    if(photoPath != null)
        Glide.with(imageView.context)
            .applyDefaultRequestOptions(ro)
            .load(glideDebugInit(photoPath))
            .into(imageView)
}

fun setPhotoItem(photoPath: String?, imageView: ImageView, isRound: Boolean = false) {
//    val imagePath = BASE_URL_MEDIA + photoPath

    val ro = RequestOptions()
    ro.placeholder(R.drawable.no_image_item)
    ro.error(R.drawable.no_image_item)

    if (isRound)
        ro.circleCrop()

    if (photoPath != null)
        Glide.with(imageView.context)
            .applyDefaultRequestOptions(ro)
            .load(glideDebugInit(photoPath))
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(imageView)
}

fun setPhotoItemTest(photoPath: Int?, imageView: ImageView, isRound: Boolean = false) {
    val ro = RequestOptions()

    if (isRound)
        ro.circleCrop()

    Glide.with(imageView.context)
        .applyDefaultRequestOptions(ro)
        .load(photoPath)
        .into(imageView)
}

fun isAuth(context: Context): Boolean {
    val prefs = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
    val userToken = prefs.getString(USER_TOKEN_PREFS, "")

    return !userToken.isNullOrBlank()
}

fun haptic(view: View, type: Int = CONTEXT_CLICK) {
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        view.performHapticFeedback(type, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING)
}

class AppErrors {
    companion object {
        const val SERVER_ERROR = "Ошибка сервера"
        const val CLIENT_ERROR = "Ошибка"
        const val NO_TOKEN_ERROR = "Токен пользователя отсутствует"
    }
}