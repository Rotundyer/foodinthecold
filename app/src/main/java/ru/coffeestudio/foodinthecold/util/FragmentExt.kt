package ru.coffeestudio.foodinthecold.util

import ru.coffeestudio.foodinthecold.BuildConfig
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import ru.coffeestudio.foodinthecold.R

fun Fragment.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}

fun Fragment.initToolbar(toolbar: Toolbar, isBlack: Boolean = false) {
    val act = requireActivity() as AppCompatActivity
    act.setSupportActionBar(toolbar)
    act.supportActionBar?.setDisplayHomeAsUpEnabled(true)

    if(!isBlack)
        act.supportActionBar?.setHomeAsUpIndicator(ContextCompat.getDrawable(requireContext(), R.drawable.ic_arrow_back))
    else
        act.supportActionBar?.setHomeAsUpIndicator(ContextCompat.getDrawable(requireContext(), R.drawable.ic_arrow_back_black))

    toolbar.setNavigationOnClickListener {
        act.onBackPressed()
    }
}

fun Fragment.toastTest(message: String, length: Int = Toast.LENGTH_SHORT) {
    if(BuildConfig.DEBUG)
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}

fun Fragment.snack(message: String, view: View, length: Int = Snackbar.LENGTH_LONG) {
    Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
}