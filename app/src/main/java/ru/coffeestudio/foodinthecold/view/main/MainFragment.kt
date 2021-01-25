package ru.coffeestudio.foodinthecold.view.main

import android.os.Bundle
import android.view.*
import android.widget.Toolbar
import kotlinx.android.synthetic.main.main.*
import kotlinx.android.synthetic.main.toolbar.*
import ru.coffeestudio.foodinthecold.R
import ru.coffeestudio.foodinthecold.adapter.main.SliderPagerAdapter
import ru.coffeestudio.foodinthecold.model.Category
import ru.coffeestudio.foodinthecold.util.CategoryListener
import ru.coffeestudio.foodinthecold.view.base.BaseFragment
import ru.coffeestudio.foodinthecold.view.model.BannerItem

class MainFragment: BaseFragment(), CategoryListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.main, container, false)
    }
    override fun initView() {}

    override fun getData() {
        setView(null)
    }

    override fun <T> setView(data: T?) {

        val data = ArrayList<BannerItem>()
        data.add(BannerItem(3, "Товар номер 3", R.drawable.picslider1))
        data.add(BannerItem(4, "Товар номер 4", R.drawable.picslider2))
        data.add(BannerItem(5, "Товар номер 5", R.drawable.picslider3))
        data.add(BannerItem(6, "Товар номер 6", R.drawable.picslider2))
        data.add(BannerItem(7, "Товар номер 7", R.drawable.picslider1))

        main_slider.adapter = SliderPagerAdapter(data, requireContext(), this)
        main_pager_dots.setupWithViewPager(main_slider)
    }

    override fun onCategorySelect(category: Category) {}

}