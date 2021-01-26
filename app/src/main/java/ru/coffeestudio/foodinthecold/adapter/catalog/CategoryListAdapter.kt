package ru.coffeestudio.foodinthecold.adapter.catalog

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import ru.coffeestudio.food.util.setPhoto
import ru.coffeestudio.foodinthecold.R
import ru.coffeestudio.foodinthecold.model.Category
import ru.coffeestudio.foodinthecold.util.CategoryListener

class CategoryListAdapter(
    private val categories: List<Category>,
    private val callback: CategoryListener
) : RecyclerView.Adapter<CategoryListAdapter.CategoryHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder =
        CategoryHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_category, parent,false))

    override fun getItemCount(): Int = categories.size

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        Log.e("AdapterCategory", categories.toString())
        holder.bind(categories[position])
    }

    inner class CategoryHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val photoView: ImageView = view.findViewById(R.id.item_category_image)
        private val titleView: TextView = view.findViewById(R.id.item_category_title)
        private val rootView: ConstraintLayout = view.findViewById(R.id.item_category_layout)

        fun bind(category: Category) {

            titleView.text = category.title
            if(category.image.isNullOrBlank())
                photoView.visibility = View.GONE
            else
                setPhoto(category.image, photoView)

            rootView.setOnClickListener { callback.onCategorySelect(category) }
        }
    }

}