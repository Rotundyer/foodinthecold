package ru.coffeestudio.foodinthecold.util

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import ru.coffeestudio.foodinthecold.R
import ru.coffeestudio.foodinthecold.view.MainActivity

class TabManager(private val mainActivity: MainActivity) {

    private val startDestinations = mapOf(
        R.id.nav_main_fragment to R.id.mainFragment,
        R.id.nav_catalog_fragment to R.id.categoryListFragment,
        R.id.nav_cart_fragment to R.id.cartFragment,
        R.id.nav_profile_fragment to R.id.profileFragment
    )

    private val startDestinationsIDs = mapOf(
        2131361896 to R.id.mainFragment,
        2131361895 to R.id.categoryListFragment,
        2131361894 to R.id.cartFragment,
        2131361897 to R.id.profileFragment
    )

    private var currentTabId: Int = R.id.nav_main_fragment
    var currentController: NavController? = null
    private var tabHistory = TabHistory().apply { push(R.id.nav_main_fragment) }

    val navMainController: NavController by lazy {
        mainActivity.findNavController(R.id.nav_main_fragment).apply {
            graph = navInflater.inflate(R.navigation.main_nav_graph).apply {
                startDestination = startDestinations.getValue(R.id.nav_main_fragment)
            }
        }
    }
    private val navCatalogController: NavController by lazy {
        mainActivity.findNavController(R.id.nav_catalog_fragment).apply {
            graph = navInflater.inflate(R.navigation.main_nav_graph).apply {
                startDestination = startDestinations.getValue(R.id.nav_catalog_fragment)
            }
        }
    }
    private val navCartController: NavController by lazy {
        mainActivity.findNavController(R.id.nav_cart_fragment).apply {
            graph = navInflater.inflate(R.navigation.main_nav_graph).apply {
                startDestination = startDestinations.getValue(R.id.nav_cart_fragment)
            }
        }
    }
    private val navProfileController: NavController by lazy {
        mainActivity.findNavController(R.id.nav_profile_fragment).apply {
            graph = navInflater.inflate(R.navigation.main_nav_graph).apply {
                startDestination = startDestinations.getValue(R.id.nav_profile_fragment)
            }
        }
    }

    private val mainContainer: View by lazy { mainActivity.nav_main_container }
    private val catalogContainer: View by lazy { mainActivity.nav_catalog_container }
    private val cartContainer: View by lazy { mainActivity.nav_cart_container }
    private val profileContainer: View by lazy { mainActivity.nav_profile_container }

    fun onSaveInstanceState(outState: Bundle?) {
        outState?.putSerializable(KEY_TAB_HISTORY, tabHistory)
    }

    fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        savedInstanceState?.let {
            tabHistory = it.getSerializable(KEY_TAB_HISTORY) as TabHistory
            switchTab(mainActivity.bottom_navigation_view.selectedItemId, false)
        }
    }

    fun supportNavigateUpTo(upIntent: Intent) {
        currentController?.navigateUp()
    }

    fun onBackPressed() {
        currentController?.let {
            if (it.currentDestination == null || it.currentDestination?.id == startDestinations[currentTabId]) {
                if (tabHistory.size > 1) {
                    val tabId = tabHistory.popPrevious()
                    switchTab(tabId, false)
                    mainActivity.bottom_navigation_view.menu.findItem(tabId)?.isChecked = true
                } else {
                    mainActivity.finish()
                }
            }
            it.popBackStack()
        } ?: run {
            mainActivity.finish()
        }
    }

    fun switchTab(tabId: Int, addToHistory: Boolean = true) {
        if (currentTabId != tabId) {
            currentTabId = tabId
        } else if (currentTabId == R.id.bottom_action_catalog) {
            currentController?.navigate(startDestinationsIDs[tabId] ?: R.id.categoryListFragment)
        } else if (currentTabId == R.id.bottom_action_cart) {
            currentController?.navigate(startDestinationsIDs[tabId] ?: R.id.cartFragment)
        } else if (currentTabId == R.id.bottom_action_profile) {
            currentController?.navigate(startDestinationsIDs[tabId] ?: R.id.profileFragment)
        } else {
            tabHistory.clear()
//            currentTabId = tabId
            currentController?.navigate(startDestinationsIDs[tabId] ?: R.id.mainFragment)
        }

        when (tabId) {
            R.id.bottom_action_main -> {
                currentController = navMainController
                invisibleTabContainerExcept(mainContainer)
                mainActivity.supportActionBar?.show()
            }
            R.id.bottom_action_catalog -> {
                currentController = navCatalogController
                invisibleTabContainerExcept(catalogContainer)
                mainActivity.supportActionBar?.show()
            }
            R.id.bottom_action_cart -> {
                currentController = navCartController
                invisibleTabContainerExcept(cartContainer)
                mainActivity.supportActionBar?.show()
            }
            R.id.bottom_action_profile -> {
                currentController = navProfileController
                invisibleTabContainerExcept(profileContainer)
                mainActivity.supportActionBar?.hide()
            }
        }
        if (addToHistory)
            tabHistory.push(tabId)
    }

    private fun invisibleTabContainerExcept(container: View) {

        mainContainer.visibility = View.INVISIBLE
        catalogContainer.visibility = View.INVISIBLE
        cartContainer.visibility = View.INVISIBLE
        profileContainer.visibility = View.INVISIBLE

        container.visibility = View.VISIBLE
    }

    companion object {
        private const val KEY_TAB_HISTORY = "key_tab_history"
    }
}