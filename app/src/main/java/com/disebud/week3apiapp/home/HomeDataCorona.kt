package com.disebud.week3apiapp.home

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.disebud.week3apiapp.R
import com.disebud.week3apiapp.adapter.KawalCoronaAdapter
import com.disebud.week3apiapp.adapter.NewsAdapter
import com.disebud.week3apiapp.model.ArticlesItem
import com.disebud.week3apiapp.model.ListDataItem
import com.disebud.week3apiapp.model.ResponseDataCorona
import com.disebud.week3apiapp.model.ResponseNews
import com.disebud.week3apiapp.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_home_data_corona.*
import kotlinx.android.synthetic.main.activity_home_news.*
import retrofit2.Callback
import retrofit2.Response

class HomeDataCorona : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_data_corona)

        if(isConnect()) {

            ConfigNetwork.getRetrofitKawalCorona().getDataCorona().enqueue(object : Callback<ResponseDataCorona> {
                override fun onFailure(call: retrofit2.Call<ResponseDataCorona>, t: Throwable) {

                    progressDataCorona.visibility = View.GONE
                    Log.d("error server"," " + t.message)
                }

                override fun onResponse(
                    call: retrofit2.Call<ResponseDataCorona>,
                    response: Response<ResponseDataCorona>
                ) {

                    Log.d("response server", response.message())

                    //check response server
                    if (response.isSuccessful) {
                        progressDataCorona.visibility = View.GONE



                        val data = response.body()?.listData

                        showData(data as List<ListDataItem>)


                    }
                }
            })
        }else{

            progressDataCorona.visibility = View.GONE

            Toast.makeText(this,"device tidak connect dengan intenet", Toast.LENGTH_SHORT).show()
        }

    }


    fun isConnect() : Boolean{

        val connect : ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager


        return  connect.activeNetworkInfo != null && connect.activeNetworkInfo!!.isConnected
    }



    private fun showData(data: List<ListDataItem>?) {

        listDataCorona.adapter =   KawalCoronaAdapter(data)

    }
}