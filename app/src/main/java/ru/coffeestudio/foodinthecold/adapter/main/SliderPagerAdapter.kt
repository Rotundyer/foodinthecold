package ru.coffeestudio.foodinthecold.adapter.main

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter
import ru.coffeestudio.foodinthecold.R
import ru.coffeestudio.foodinthecold.model.Category
import ru.coffeestudio.foodinthecold.util.CategoryListener
import ru.coffeestudio.foodinthecold.view.model.BannerItem

class SliderPagerAdapter(
    private val images: List<BannerItem>,
    private val context: Context,
    private val callback: CategoryListener
) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object`

    override fun getCount(): Int = images.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var imageView = AppCompatImageView(context)

        if (images.isNotEmpty() && position <= images.count()) {

            imageView.scaleType = ImageView.ScaleType.FIT_CENTER
            imageView.setImageDrawable(ContextCompat.getDrawable(context, images[position].image))
            container.addView(imageView)

            imageView.setOnClickListener {
                callback.onCategorySelect(Category(1))
            }
        } else {
            imageView.setImageResource(R.drawable.ic_no_image)
        }

        return imageView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

        private fun getTestSliderImage(position: Int): Int =
            when(position) {
                0 -> R.drawable.test_slider1
                1 -> R.drawable.test_slider2
                2 -> R.drawable.test_slider3
                else -> R.drawable.test_slider1
            }
}