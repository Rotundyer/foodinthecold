package ru.coffeestudio.foodinthecold.view.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.coffeestudio.foodinthecold.R
import ru.coffeestudio.foodinthecold.view.MainActivity
import ru.coffeestudio.foodinthecold.view.base.BaseFragment

class ProfileFragment: BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.profile, container, false)
    }
    override fun initView() {}

    override fun getData() {

    }

    override fun <T> setView(data: T?) {}
}