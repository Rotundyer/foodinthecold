package ru.coffeestudio.foodinthecold.view.catalog

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.category_list.*
import ru.coffeestudio.foodinthecold.R
import ru.coffeestudio.foodinthecold.adapter.catalog.CategoryListAdapter
import ru.coffeestudio.foodinthecold.model.Category
import ru.coffeestudio.foodinthecold.util.CategoryListener
import ru.coffeestudio.foodinthecold.view.base.BaseFragment

class CategoryListFragment: BaseFragment(), CategoryListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.category_list, container, false)
    }
    override fun initView() {}

    override fun getData() {
        setView(null)
    }

    override fun <T> setView(data: T?) {

        val data = ArrayList<Category>()
        data.add(Category(3, "Товар номер 3"))
        data.add(Category(4, "Товар номер 4"))
        data.add(Category(5, "Товар номер 5"))
        data.add(Category(6, "Товар номер 6"))
        data.add(Category(7, "Товар номер 7"))

        Log.e("Category", "1")
        Log.e("Category", data.toString())

        category_top_list.layoutManager = LinearLayoutManager(requireContext())
        category_top_list.adapter = CategoryListAdapter(data, this)
    }

    override fun onCategorySelect(category: Category) {

    }
}