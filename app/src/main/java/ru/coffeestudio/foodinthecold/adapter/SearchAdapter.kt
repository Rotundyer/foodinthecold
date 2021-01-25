package ru.coffeestudio.foodinthecold.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.coffeestudio.foodinthecold.R

class SearchAdapter(private val searchList: List<String>) :
    RecyclerView.Adapter<SearchAdapter.SearchHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAdapter.SearchHolder {
        return SearchHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_search, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SearchAdapter.SearchHolder, position: Int) {
        holder.bind(searchList[position])
    }

    override fun getItemCount() = searchList.size

    class SearchHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var searchText: TextView? = view.findViewById(R.id.textViewLarge)
        fun bind(str: String) {
            Log.e("Adapter", str)
            searchText?.text = str
        }
    }
}