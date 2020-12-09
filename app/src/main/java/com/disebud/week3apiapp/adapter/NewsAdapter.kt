package com.disebud.week3apiapp.adapter



import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.disebud.week3apiapp.R
import com.disebud.week3apiapp.detail.DetailNewsActivity
import com.disebud.week3apiapp.model.ArticlesItem
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(var data: List<ArticlesItem>?) :RecyclerView.Adapter<NewsAdapter.NewsHolder>()  {
    class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img = itemView.itemImg
        val itemJudul = itemView.itemJudul
//        val itemSumber = itemView.itemSumber
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        val holder = NewsHolder(view)
        return holder
    }
    override fun getItemCount(): Int {
        return data?.size ?: 0
    }
    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
//        val nama = data?.get(position)?.author
//        val source = data?.get(position)?.source?.name
//        holder.itemSumber.text = "$nama - $source"
        holder.itemJudul.text = data?.get(position)?.title
        Glide.with(holder.itemView.context).load(data?.get(position)?.urlToImage).into(holder.img)


        holder.itemView.setOnClickListener {

            //action klik
            val intent = Intent(holder.itemView.context, DetailNewsActivity::class.java)
            intent.putExtra("jdl", data?.get(position)?.title)
            intent.putExtra("img", data?.get(position)?.urlToImage)
            intent.putExtra("desk", data?.get(position)?.description)
            intent.putExtra("source", data?.get(position)?.source?.name)
            intent.putExtra("author", data?.get(position)?.author)

            holder.itemView.context.startActivity(intent)

        }
    }
}