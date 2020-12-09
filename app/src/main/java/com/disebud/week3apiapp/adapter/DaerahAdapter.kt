package com.disebud.week3apiapp.adapter

import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.recyclerview.widget.RecyclerView
import com.disebud.week3apiapp.R
import com.disebud.week3apiapp.model.ProvinsiItem
import kotlinx.android.synthetic.main.detail_item_daerah.*
import kotlinx.android.synthetic.main.item_daerah.view.*

class DaerahAdapter(var data: List<ProvinsiItem>?) : RecyclerView.Adapter<DaerahAdapter.DaerahHolder>()  {
    class DaerahHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textName = itemView.itemDaerah
        val itemID = itemView.itemID
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DaerahHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_daerah,parent,false)
        val holder = DaerahHolder(view)
        return holder
    }
    override fun getItemCount(): Int {
        return data?.size ?: 0
    }
    override fun onBindViewHolder(holder: DaerahHolder, position: Int) {
        holder.textName.text = data?.get(position)?.nama
        holder.itemID.text = data?.get(position)?.id.toString()
//        Glide.with(holder.itemView.context).load(data?.get(position)?.urlToImage).into(holder.img)


        holder.itemView.setOnClickListener {

            Dialog(holder.itemView.context).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(true)
                setContentView(R.layout.detail_item_daerah)

                idProv.text = data?.get(position)?.id.toString()
                namaProv.text = data?.get(position)?.nama

                btnCloseDaerah.setOnClickListener{
                    this.dismiss()
                }
            }.show()

//            //action klik
//            val intent = Intent(holder.itemView.context, DetailMuseumActivity::class.java)
//            intent.putExtra("nama", data?.get(position)?.nama)
////            intent.putExtra("img", data?.get(position)?.urlToImage)
//            intent.putExtra("alamat", data?.get(position)?.alamatJalan)
//
//            holder.itemView.context.startActivity(intent)

        }
    }
}