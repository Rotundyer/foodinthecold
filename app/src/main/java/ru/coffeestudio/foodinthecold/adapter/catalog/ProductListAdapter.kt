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

class ProductListAdapter(
    private val products: ArrayList<ProductSimple>,
    private val fullSize: Boolean,
    private val callbackClick: ClickableItem? = null,
    private val callbackCart: CartableItem? = null,
    private val callbackLike: LikableItem? = null
) : RecyclerView.Adapter<ProductListAdapter.ProductHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {

        val layout = R.layout.item_product

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

        private val photoView: ImageView = view.findViewById(R.id.item_product_image)
        private val titleView: TextView = view.findViewById(R.id.item_product_title)
        private val priceView: TextView = view.findViewById(R.id.item_product_price)
        private val priceBaseView: TextView = view.findViewById(R.id.item_product_price_base)

        private val heart: ImageView = view.findViewById(R.id.item_product_like)

//        private val likeView: ImageView = view.findViewById(R.id.item_product_like)
//        private val cartView: ImageView = view.findViewById(R.id.item_product_cart)
//        private val rootView: CardView = view.findViewById(R.id.item_product_card)

        private var stars = ArrayList<ImageView>()

        private val star1: ImageView = view.findViewById(R.id.star1)
        private val star2: ImageView = view.findViewById(R.id.star2)
        private val star3: ImageView = view.findViewById(R.id.star3)
        private val star4: ImageView = view.findViewById(R.id.star4)
        private val star5: ImageView = view.findViewById(R.id.star5)

        fun bind(product: ProductSimple) {

            Glide.with(photoView.context).load(R.drawable.scottish_salmon).fitCenter()
                .into(photoView)
            titleView.text = product.title
            priceView.text = product.price.toString() + " руб."
            priceBaseView.text = Html.fromHtml("<s>" + product.priceBase + " руб." + "</s>")

            stars.add(star1)
            stars.add(star2)
            stars.add(star3)
            stars.add(star4)
            stars.add(star5)

            when ((0..1).random()) {
                0 -> {
                    Glide.with(heart.context).load(R.drawable.ic_heart_on).fitCenter().into(heart)
                    heart.setPadding(0,0,0,0)
                }
                1 -> {
                    Glide.with(heart.context).load(R.drawable.ic_heart_off).fitCenter().into(heart)
                    heart.setPadding(10,10,10,10)
                }
            }

            var a = 0
            while (a < (0..5).random()) {
                Glide.with(stars[a].context).load(R.drawable.star_on).into(stars[a])
                a++
            }


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