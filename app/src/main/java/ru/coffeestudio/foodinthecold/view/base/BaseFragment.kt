package ru.coffeestudio.foodinthecold.view.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import ru.coffeestudio.foodinthecold.util.Resource
import ru.coffeestudio.foodinthecold.util.Status
import ru.coffeestudio.foodinthecold.util.toast


abstract class BaseFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getData()
    }

    abstract fun initView()

    abstract fun getData()

    fun<T> loadData(action: () -> LiveData<Resource<T>>, loader: View?) {
        action().observe(viewLifecycleOwner, Observer {
            when(it.status) {
                Status.OK -> {
                    hideLoading(loader)
                    setView(it.data)
                }
                Status.LOADING -> showLoading(loader)
                Status.ERROR -> {
                    hideLoading(loader)
                    showError(it.errMessage)
                }
            }
        })
    }

    abstract fun<T> setView(data: T?)

    protected fun showLoading(view: View?) {
        view?.visibility = View.VISIBLE
    }

    protected fun hideLoading(view: View?) {
        view?.visibility = View.GONE
    }

    protected fun showError(errMessage: String?) {
        toast(errMessage ?: "Неизвестная ошибка")
    }
}