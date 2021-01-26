package ru.coffeestudio.foodinthecold.view.main

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.GridLayout
import android.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.main.*
import kotlinx.android.synthetic.main.toolbar.*
import ru.coffeestudio.foodinthecold.R
import ru.coffeestudio.foodinthecold.adapter.catalog.ProductListAdapter
import ru.coffeestudio.foodinthecold.adapter.catalog.RecipesListAdapter
import ru.coffeestudio.foodinthecold.adapter.main.SliderPagerAdapter
import ru.coffeestudio.foodinthecold.db.entities.ProductEntity
import ru.coffeestudio.foodinthecold.model.Category
import ru.coffeestudio.foodinthecold.model.ProductSimple
import ru.coffeestudio.foodinthecold.util.CartableItem
import ru.coffeestudio.foodinthecold.util.CategoryListener
import ru.coffeestudio.foodinthecold.util.ClickableItem
import ru.coffeestudio.foodinthecold.util.LikableItem
import ru.coffeestudio.foodinthecold.view.base.BaseFragment
import ru.coffeestudio.foodinthecold.view.model.BannerItem
import java.math.BigDecimal

class MainFragment : BaseFragment(), ClickableItem, CartableItem, LikableItem, CategoryListener {

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

        val data2 = ArrayList<ProductSimple>()
        data2.add(
            ProductSimple(
                1,
                "Колбаса крутая совсем из мяса",
                priceBase = BigDecimal(15000),
                price = BigDecimal(10000)
            )
        )
        data2.add(
            ProductSimple(
                2,
                "Колбаса",
                priceBase = BigDecimal(15000),
                price = BigDecimal(10000)
            )
        )

        recyclerNews.layoutManager = GridLayoutManager(context, 2)
        recyclerNews.adapter = ProductListAdapter(data2, true, this, this, this)

        recyclerBestsellers.layoutManager = GridLayoutManager(context, 2)
        recyclerBestsellers.adapter = ProductListAdapter(data2, true, this, this, this)


        val data3 = ArrayList<ProductSimple>()
        data3.add(
            ProductSimple(
                1,
                "Запеканка «Итальянское наваждение»",
                priceBase = BigDecimal(15000),
                price = BigDecimal(7600)
            )
        )
        data3.add(
            ProductSimple(
                2,
                "Запеканка «Итальянское наваждение»",
                priceBase = BigDecimal(15000),
                price = BigDecimal(7600)
            )
        )
        recyclerRecipes.layoutManager = GridLayoutManager(context, 2)
        recyclerRecipes.adapter = RecipesListAdapter(data3, true, this, this, this)
    }

    override fun onCategorySelect(category: Category) {}
    override fun onItemClick(itemID: Int) {}
    override fun onItemLiked(product: ProductEntity) {}
    override fun onItemCarted(product: ProductEntity) {}
}