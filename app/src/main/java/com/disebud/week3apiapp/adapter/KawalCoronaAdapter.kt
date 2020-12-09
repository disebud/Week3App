package com.disebud.week3apiapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.disebud.week3apiapp.R
import com.disebud.week3apiapp.detail.DetailDaerahCoronaActivity
import com.disebud.week3apiapp.detail.DetailNewsActivity
import com.disebud.week3apiapp.model.ArticlesItem
import com.disebud.week3apiapp.model.ListDataItem
import kotlinx.android.synthetic.main.activity_detail_daerah_corona.*
import kotlinx.android.synthetic.main.item_data_corona.view.*
import kotlinx.android.synthetic.main.item_news.view.*
import java.text.NumberFormat
import java.util.*

class KawalCoronaAdapter(var data: List<ListDataItem>?) : RecyclerView.Adapter<KawalCoronaAdapter.KawalCoronaHolder>()  {
    class KawalCoronaHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textName = itemView.itemDaerahCorona
        val itemJlhKasus = itemView.jlhKasusDaerah
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KawalCoronaHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data_corona,parent,false)
        val holder = KawalCoronaHolder(view)
        return holder
    }
    override fun getItemCount(): Int {
        return data?.size ?: 0
    }
    override fun onBindViewHolder(holder: KawalCoronaHolder, position: Int) {
        val localeID = Locale("in", "ID")
        val AngkaIndo = NumberFormat.getInstance(localeID)

        holder.itemJlhKasus.text = AngkaIndo.format(data?.get(position)?.jumlahKasus)
//        holder.itemJlhKasus.text = data?.get(position)?.jumlahKasus.toString()
        holder.textName.text = data?.get(position)?.key

        holder.itemView.setOnClickListener {

            //action klik
            val intent = Intent(holder.itemView.context, DetailDaerahCoronaActivity::class.java)
            intent.putExtra("nama", data?.get(position)?.key)
            intent.putExtra("kasus", data?.get(position)?.jumlahKasus.toString())
            intent.putExtra("meninggal", data?.get(position)?.jumlahMeninggal.toString())
            intent.putExtra("sembuh", data?.get(position)?.jumlahSembuh.toString())
            intent.putExtra("dirawat", data?.get(position)?.jumlahDirawat.toString())
            holder.itemView.context.startActivity(intent)

        }
    }
}