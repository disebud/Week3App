package com.disebud.week3apiapp.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.disebud.week3apiapp.R
import com.disebud.week3apiapp.detail.DetailNewsActivity
import com.disebud.week3apiapp.model.ArticlesItem
import com.smarteist.autoimageslider.SliderViewAdapter



class SliderImageAdapter(private val mContext: Context, mSliderItems: List<ArticlesItem>?) :
    SliderViewAdapter<SliderImageAdapter.SliderAdapterVH>() {
    private val mSliderItems: List<ArticlesItem>
    private var mCount = 0
    fun setCount(count: Int) {
        mCount = count
    }

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_slider, null)
        return SliderAdapterVH(view)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {
        val sliderItem: ArticlesItem = mSliderItems[position]
        viewHolder.tvDescSlider.setText(sliderItem.title)
        viewHolder.tvDescSlider.textSize = 20f
        viewHolder.tvDescSlider.setTextColor(Color.WHITE)
        Glide.with(viewHolder.itemView)
            .load(sliderItem.urlToImage)
            .fitCenter()
            .into(viewHolder.imgAutoSlider)

        viewHolder.itemView.setOnClickListener {

            //action klik
            val intent = Intent(viewHolder.itemView.context, DetailNewsActivity::class.java)
            intent.putExtra("jdl", mSliderItems?.get(position)?.title)
            intent.putExtra("img", mSliderItems?.get(position)?.urlToImage)
            intent.putExtra("desk", mSliderItems?.get(position)?.description)
            intent.putExtra("source", mSliderItems?.get(position)?.source?.name)
            intent.putExtra("author", mSliderItems?.get(position)?.author)

            viewHolder.itemView.context.startActivity(intent)

        }
    }

    override fun getCount(): Int {
        return mCount
    }

    inner class SliderAdapterVH(itemView: View) :
        ViewHolder(itemView) {
        var imgAutoSlider: ImageView
        var tvDescSlider: TextView

        init {
            imgAutoSlider = itemView.findViewById(R.id.imgAutoSlider)
            tvDescSlider = itemView.findViewById(R.id.tvDescSlider)
        }
    }

    init {
        this.mSliderItems = mSliderItems!!
    }
}
