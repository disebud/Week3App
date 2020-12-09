package com.disebud.week3apiapp.detail

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.disebud.week3apiapp.R
import kotlinx.android.synthetic.main.activity_detail_daerah_corona.*

import kotlinx.android.synthetic.main.activity_detail_news.*


class DetailNewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)

        val nama = intent.getStringExtra("jdl")
        val desk = intent.getStringExtra("desk")
        val img = intent.getStringExtra("img")
        val author = intent.getStringExtra("author")
        val source = intent.getStringExtra("source")

        jdlDetail.text = nama
        deskDetail.text = desk
        tvAuthor.text = "$author - $source"

        Glide.with(this).load(img).into(imgDetail)

        btnCloseNews.setOnClickListener {
            this.onBackPressed()
        }

    }

}
