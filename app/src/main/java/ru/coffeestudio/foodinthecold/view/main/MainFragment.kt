package ru.coffeestudio.foodinthecold.view.main

import android.os.Bundle
import android.view.*
import kotlinx.android.synthetic.main.main.*
import ru.coffeestudio.foodinthecold.R
import ru.coffeestudio.foodinthecold.view.MainActivity
import ru.coffeestudio.foodinthecold.view.base.BaseFragment

class MainFragment: BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.main, container, false)
    }
    override fun initView() {}

    override fun getData() {

    }

    override fun <T> setView(data: T?) {}

}