package com.disebud.week3apiapp.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.disebud.week3apiapp.R
import kotlinx.android.synthetic.main.activity_detail_daerah_corona.*
import kotlinx.android.synthetic.main.activity_detail_museum.*
import kotlinx.android.synthetic.main.activity_detail_museum.NamaMuseumDetail
import java.text.NumberFormat
import java.util.*

class DetailDaerahCoronaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_daerah_corona)

        val nama = intent.getStringExtra("nama")
        val kasus = intent.getStringExtra("kasus")?.toInt()
        val meninggal = intent.getStringExtra("meninggal")?.toInt()
        val sembuh = intent.getStringExtra("sembuh")?.toInt()
        val dirawat = intent.getStringExtra("dirawat")?.toInt()

        val localeID = Locale("in", "ID")
        val AngkaIndo = NumberFormat.getInstance(localeID)

        daerahCovid.text = nama.toString()
        btnJlhKasus.text = "${AngkaIndo.format(kasus)} ORANG"
        btnMeninggal.text = "${AngkaIndo.format(meninggal)}\nORANG"
        btnSembuh.text =  "${AngkaIndo.format(sembuh)}\nORANG"
        btnDirawat.text =  "${AngkaIndo.format(dirawat)}\nORANG"

        btnCloseCorona.setOnClickListener {
            this.onBackPressed()
        }


    }
}