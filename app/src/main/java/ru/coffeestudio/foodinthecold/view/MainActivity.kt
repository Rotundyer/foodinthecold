package ru.coffeestudio.foodinthecold.view

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main.*
import ru.coffeestudio.foodinthecold.R
import ru.coffeestudio.foodinthecold.adapter.SearchAdapter
import ru.coffeestudio.foodinthecold.util.TabManager


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private val tabManager: TabManager by lazy { TabManager(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.nav_main_fragment)

        bottom_navigation_view.setOnNavigationItemSelectedListener(this)

        if (savedInstanceState == null)
            tabManager.currentController = tabManager.navMainController

        supportActionBar?.elevation = 0F
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        tabManager.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        tabManager.onRestoreInstanceState(savedInstanceState)
    }

    override fun supportNavigateUpTo(upIntent: Intent) {
        tabManager.supportNavigateUpTo(upIntent)
    }

    override fun onBackPressed() {
        tabManager.onBackPressed()
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        tabManager.switchTab(menuItem.itemId)
        return true
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.search_menu, menu)
//
//        val searchItem = menu!!.findItem(R.id.menu_search)
//        val searchView: SearchView = searchItem.actionView as SearchView
//
//        val open_sans = Typeface.createFromAsset(assets, "fonts/open_sans.ttf")
//        val open_sans_semibold = Typeface.createFromAsset(assets, "fonts/open_sans_semibold.ttf")
//        val searchText = searchView.findViewById(R.id.search_src_text) as TextView
//
//        searchText.apply {
//            typeface = open_sans
//            setTextColor(Color.WHITE)
//            setTextSize(1,20F)
//        }
//
//        recyclerSearch.setHasFixedSize(true)
//        recyclerSearch.layoutManager = LinearLayoutManager(this@MainActivity)
//
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                recyclerSearch.adapter = SearchAdapter(setList().filter { newText != "" })
//                return false
//            }
//
//        })
//        return super.onCreateOptionsMenu(menu)
//    }

//    private fun setList(): ArrayList<String> {
//        val list = arrayListOf<String>()
//        list.add("Кот")
//        list.add("Собака")
//        list.add("Колбаса")
//        list.add("Котлеты")
//
//        return list
//    }
}