package com.disebud.week3apiapp.home

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.disebud.week3apiapp.R
import com.disebud.week3apiapp.adapter.DaerahAdapter
import com.disebud.week3apiapp.model.ProvinsiItem
import com.disebud.week3apiapp.model.ResponseDaerah
import com.disebud.week3apiapp.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_home_daerah.*
import retrofit2.Callback
import retrofit2.Response

class HomeDaerah : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_daerah)

        if(isConnect()) {

            ConfigNetwork.getRetrofitDaerahInd().getDataDaerah().enqueue(object :
                Callback<ResponseDaerah> {
                override fun onFailure(call: retrofit2.Call<ResponseDaerah>, t: Throwable) {

                    progressDaerah.visibility = View.GONE
                    Log.d("error server"," " + t.message)
                }

                override fun onResponse(
                    call: retrofit2.Call<ResponseDaerah>,
                    response: Response<ResponseDaerah>
                ) {

                    Log.d("response server", response.message())

                    //check response server
                    if (response.isSuccessful) {
                        progressDaerah.visibility = View.GONE



                        val data = response.body()?.provinsi

                        showData(data as List<ProvinsiItem>)


                    }
                }
            })
        }else{

            progressDaerah.visibility = View.GONE

            Toast.makeText(this,"device tidak connect dengan intenet", Toast.LENGTH_SHORT).show()
        }

    }


    fun isConnect() : Boolean{

        val connect : ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager


        return  connect.activeNetworkInfo != null && connect.activeNetworkInfo!!.isConnected
    }



    private fun showData(data: List<ProvinsiItem>?) {

        listDaerah.adapter =   DaerahAdapter(data)

    }
}