package com.disebud.week3apiapp

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.disebud.week3apiapp.adapter.NewsAdapter
import com.disebud.week3apiapp.adapter.SliderImageAdapter
import com.disebud.week3apiapp.home.HomeDaerah
import com.disebud.week3apiapp.home.HomeDataCorona
import com.disebud.week3apiapp.home.HomeMuseum
import com.disebud.week3apiapp.home.HomeNews
import com.disebud.week3apiapp.model.ArticlesItem
import com.disebud.week3apiapp.model.DataItem
import com.disebud.week3apiapp.model.ResponseNews
import com.disebud.week3apiapp.network.ConfigNetwork
import com.smarteist.autoimageslider.IndicatorAnimations
import com.smarteist.autoimageslider.SliderAnimations
import kotlinx.android.synthetic.main.activity_home_museum.*
import kotlinx.android.synthetic.main.activity_home_news.*
import kotlinx.android.synthetic.main.slider_imageview.*
import okio.Utf8.size
import retrofit2.Callback
import retrofit2.Response
import java.nio.file.Files.size
import java.util.ArrayList


class MainActivity : AppCompatActivity() {
    private var progressDialog: ProgressDialog? = null
    private val ArticlesItem: MutableList<ArticlesItem> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //method get slide
        getSlideData()

    }

    private fun getSlideData() {
        progressDialog?.show()
        ConfigNetwork.getRetrofit().getDataNews().enqueue(object : Callback<ResponseNews> {
            override fun onFailure(call: retrofit2.Call<ResponseNews>, t: Throwable) {
                progressDialog?.dismiss()
//                progressMuseum.visibility = View.GONE
                Log.d("error server"," " + t.message)
                Toast.makeText(this@MainActivity, "Gagal menampilkan data!", Toast.LENGTH_SHORT).show()
            }

            @RequiresApi(Build.VERSION_CODES.M)
            override fun onResponse(
                call: retrofit2.Call<ResponseNews>,
                response: Response<ResponseNews>
            ) {

                Log.d("response server", response.message())

                //check response server
                if (response.isSuccessful) {
                    progressDialog?.dismiss()
//                    progressMuseum.visibility = View.GONE



                    val data = response.body()?.articles

//                    showData(data as List<ArticlesItem>)
                    setImgSlide(data as List<ArticlesItem>?)


                }
            }
        })
    }

    private fun showData(data: List<ArticlesItem>?) {

        listNews.adapter =   NewsAdapter(data)

    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setImgSlide(data: List<ArticlesItem>?) {
        val sliderImageAdapter = SliderImageAdapter(this, data)
        sliderImageAdapter.count = data!!.size
        imgSlider.setSliderAdapter(sliderImageAdapter)
        imgSlider.setIndicatorAnimation(IndicatorAnimations.DROP)
        imgSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        imgSlider.indicatorSelectedColor = Color.WHITE
        imgSlider.indicatorUnselectedColor = getColor(R.color.colorPrimary)
        imgSlider.startAutoCycle()
        imgSlider.setOnIndicatorClickListener { position -> imgSlider.currentPagePosition = position }
    }

    fun newsMove(view: View) {
        var i : Intent = Intent(this, HomeNews::class.java)
        startActivity(i)
    }

    fun museumMove(view: View) {
        var i : Intent = Intent(this, HomeMuseum::class.java)
        startActivity(i)
    }

    fun daerahMove(view: View) {
        var i : Intent = Intent(this, HomeDaerah::class.java)
        startActivity(i)
    }

    fun dataCoronaMove(view: View) {
        var i : Intent = Intent(this, HomeDataCorona::class.java)
        startActivity(i)
    }
}
