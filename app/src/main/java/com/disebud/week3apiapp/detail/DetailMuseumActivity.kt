package com.disebud.week3apiapp.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.disebud.week3apiapp.R
import kotlinx.android.synthetic.main.activity_detail_museum.*
import kotlinx.android.synthetic.main.activity_detail_news.*

class DetailMuseumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_museum)



        val nama = intent.getStringExtra("nama")
        val prov = intent.getStringExtra("prov")
        val alamat = intent.getStringExtra("alamat")
        val thBerdiri = intent.getStringExtra("thBerdiri")
        val jnsBangunan = intent.getStringExtra("jnsBangunan")
        val pengelola = intent.getStringExtra("pengelola")

        NamaMuseumDetail.text = nama
        provMuseumDetail.text = prov
        alamatMuseumDetail.text = alamat
        thnBerdiri.text = thBerdiri
        jenisBangunan.text = jnsBangunan
        pengelolaMuseum.text = pengelola

        btnCloseMuseum.setOnClickListener {
            this.onBackPressed()
        }


    }
}