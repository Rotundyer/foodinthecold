package ru.coffeestudio.foodinthecold.view.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.coffeestudio.foodinthecold.R
import ru.coffeestudio.foodinthecold.view.base.BaseFragment

class CartFragment: BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cart, container, false)
    }
    override fun initView() {}

    override fun getData() {}

    override fun <T> setView(data: T?) {}
}