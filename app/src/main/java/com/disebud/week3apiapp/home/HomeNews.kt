package com.disebud.week3apiapp.home

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.disebud.week3apiapp.R
import com.disebud.week3apiapp.adapter.NewsAdapter
import com.disebud.week3apiapp.model.ArticlesItem
import com.disebud.week3apiapp.model.ResponseNews
import com.disebud.week3apiapp.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_home_news.*
import retrofit2.Callback
import retrofit2.Response


class HomeNews : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_news)


        if(isConnect()) {

            ConfigNetwork.getRetrofit().getDataNews().enqueue(object : Callback<ResponseNews> {
                override fun onFailure(call: retrofit2.Call<ResponseNews>, t: Throwable) {

                    progress.visibility = View.GONE
                    Log.d("error server"," " + t.message)
                }

                override fun onResponse(
                    call: retrofit2.Call<ResponseNews>,
                    response: Response<ResponseNews>
                ) {

                    Log.d("response server", response.message())

                    //check response server
                    if (response.isSuccessful) {
                        progress.visibility = View.GONE



//                        val data = response.body()?.hasil
                        val data = response.body()?.articles

                        showData(data as List<ArticlesItem>)


                    }
                }
            })
        }else{

            progress.visibility = View.GONE

            Toast.makeText(this,"device tidak connect dengan intenet",Toast.LENGTH_SHORT).show()
        }

    }


    fun isConnect() : Boolean{

        val connect : ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager


        return  connect.activeNetworkInfo != null && connect.activeNetworkInfo!!.isConnected
    }



    private fun showData(data: List<ArticlesItem>?) {

        listNews.adapter =   NewsAdapter(data)

    }
}