package ru.coffeestudio.foodinthecold.view.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.coffeestudio.foodinthecold.R
import ru.coffeestudio.foodinthecold.view.base.BaseFragment

class ProductFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.product, container, false)
    }

    override fun initView() {}

    override fun getData() {}

    override fun <T> setView(data: T?) {}
}