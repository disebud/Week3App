package com.disebud.week3apiapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.disebud.week3apiapp.R
import com.disebud.week3apiapp.detail.DetailMuseumActivity
import com.disebud.week3apiapp.model.DataItem
import kotlinx.android.synthetic.main.items_museum.view.*

class MuseumAdapter(var data: List<DataItem>?) : RecyclerView.Adapter<MuseumAdapter.MuseumHolder>()  {
    class MuseumHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val img = itemView.itemImgMuseum
        val textName = itemView.itemNamaMuseum
        val itemNamaProvinsi = itemView.itemNamaProvinsi
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MuseumHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_museum,parent,false)
        val holder = MuseumHolder(view)
        return holder
    }
    override fun getItemCount(): Int {
        return data?.size ?: 0
    }
    override fun onBindViewHolder(holder: MuseumHolder, position: Int) {
        holder.textName.text = data?.get(position)?.nama
        holder.itemNamaProvinsi.text = data?.get(position)?.propinsi
//        Glide.with(holder.itemView.context).load(data?.get(position)?.urlToImage).into(holder.img)


        holder.itemView.setOnClickListener {

            //action klik
            val intent = Intent(holder.itemView.context, DetailMuseumActivity::class.java)
            intent.putExtra("nama", data?.get(position)?.nama)
            intent.putExtra("prov", data?.get(position)?.propinsi)
            intent.putExtra("alamat", data?.get(position)?.alamatJalan)
            intent.putExtra("thBerdiri", data?.get(position)?.tahunBerdiri)
            intent.putExtra("jnsBangunan", data?.get(position)?.bangunan)
            intent.putExtra("pengelola", data?.get(position)?.pengelola)

            holder.itemView.context.startActivity(intent)

        }
    }
}