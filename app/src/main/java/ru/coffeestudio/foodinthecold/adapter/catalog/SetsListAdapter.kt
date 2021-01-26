package ru.coffeestudio.foodinthecold.adapter.catalog

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.coffeestudio.foodinthecold.R
import ru.coffeestudio.foodinthecold.model.ProductSimple
import ru.coffeestudio.foodinthecold.util.CartableItem
import ru.coffeestudio.foodinthecold.util.ClickableItem
import ru.coffeestudio.foodinthecold.util.LikableItem

class SetsListAdapter(
    private val products: ArrayList<ProductSimple>,
    private val fullSize: Boolean,
    private val callbackClick: ClickableItem? = null,
    private val callbackCart: CartableItem? = null,
    private val callbackLike: LikableItem? = null
) : RecyclerView.Adapter<SetsListAdapter.ProductHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {

        val layout = R.layout.item_sets

        return ProductHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(layout, parent, false)
        )
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.bind(products[position])
    }

    fun addMore(items: List<ProductSimple>) {
        products.addAll(items)
        notifyDataSetChanged()
    }

    inner class ProductHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val photoView: ImageView = view.findViewById(R.id.item_sets_image)
        private val titleView: TextView = view.findViewById(R.id.item_sets_title)

        fun bind(product: ProductSimple) {

            Glide.with(photoView.context).load(R.drawable.procent_15).fitCenter()
                .into(photoView)
            titleView.text = product.title


//            val priceBase = product.priceBase ?: 0
//
//            if(priceBase != 0)
//                priceBaseView.text = priceBase.toString() + "руб."
//            else
//                priceBaseView.text = product.price.toString() + "руб."
//
//            priceBaseView.paintFlags = (Paint.STRIKE_THRU_TEXT_FLAG)
//            setPhotoItem(product.imagePreview, photoView)
//
//            rootView.setOnClickListener {
//                callbackClick?.onItemClick(product.id)
//            }
//
//            likeView.setOnClickListener {
//                callbackLike?.onItemLiked(productSimpleToProductEntity(product))
//
//                if (!product.liked) {
//                    product.liked = true
//                    Glide.with(likeView.context).load(R.drawable.ic_heart_on)
//                        .into(likeView)
//                } else {
//                    product.liked = false
//                    Glide.with(likeView.context).load(R.drawable.ic_heart_off)
//                        .into(likeView)
//                }
//            }
//
//            cartView.setOnClickListener {
//                callbackCart?.onItemCarted(productSimpleToProductEntity(product))
//                Glide.with(cartView.context).load(R.drawable.ic_cart_selected).into(cartView)
//
//                if (!product.inCart) {
//                    product.inCart = true
//                    Glide.with(cartView.context).load(R.drawable.ic_cart_selected)
//                        .into(cartView)
//                } else {
//                    product.inCart = false
//                    Glide.with(cartView.context).load(R.drawable.ic_cart_catalog)
//                        .into(cartView)
//                }
//            }cartView
        }
    }
}