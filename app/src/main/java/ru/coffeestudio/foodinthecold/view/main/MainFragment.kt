package ru.coffeestudio.foodinthecold.view.main

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.appcompat.widget.ActionBarContainer
import kotlinx.android.synthetic.main.main.*
import ru.coffeestudio.foodinthecold.R
import ru.coffeestudio.foodinthecold.view.base.BaseFragment

class MainFragment: BaseFragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.main, container, false)
    }
    override fun initView() {}

    override fun getData() {

    }

    override fun <T> setView(data: T?) {}

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.search_menu, menu)
//        val searchItem = menu.findItem(R.id.menu_search)
//        val searchView: SearchView = searchItem.actionView as SearchView
//
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                return false
//            }
//
//        })
//
//        super.onCreateOptionsMenu(menu, inflater)
//    }
}