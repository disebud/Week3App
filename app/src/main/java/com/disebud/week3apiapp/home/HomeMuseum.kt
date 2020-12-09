package com.disebud.week3apiapp.home

import android.app.ProgressDialog
import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.disebud.week3apiapp.R
import com.disebud.week3apiapp.adapter.MuseumAdapter
import com.disebud.week3apiapp.adapter.NewsAdapter
import com.disebud.week3apiapp.model.ArticlesItem
import com.disebud.week3apiapp.model.DataItem
import com.disebud.week3apiapp.model.ResponseMuseum
import com.disebud.week3apiapp.model.ResponseNews
import com.disebud.week3apiapp.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_home_museum.*
import kotlinx.android.synthetic.main.activity_home_news.*
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Callback
import retrofit2.Response

class HomeMuseum : AppCompatActivity() {

    private var progressDialog: ProgressDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_museum)



        searcMuseum.setQueryHint("Cari Apa?")
        getAllMuseum()

        if(isConnect()) {

            searcMuseum.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    setSearchMuseum(query)
                    return false
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    if (newText == "") getAllMuseum()
                    return false
                }
            })

        }else{

            progressMuseum.visibility = View.GONE

            Toast.makeText(this,"device tidak connect dengan intenet", Toast.LENGTH_SHORT).show()
        }

    }

    private fun setSearchMuseum(query: String) {
        progressMuseum.visibility = View.VISIBLE
        progressDialog?.show()
        ConfigNetwork.getRetrofitMuseum().getDataMuseumByNama(query).enqueue(object : Callback<ResponseMuseum> {
            override fun onFailure(call: retrofit2.Call<ResponseMuseum>, t: Throwable) {
                progressDialog?.dismiss()
                progressMuseum.visibility = View.GONE
                Log.d("error server"," " + t.message)
                Toast.makeText(this@HomeMuseum, "Gagal menampilkan data!", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: retrofit2.Call<ResponseMuseum>,
                response: Response<ResponseMuseum>
            ) {
                progressDialog?.show()
                progressMuseum.visibility = View.VISIBLE
                Log.d("response server", response.message())

                //check response server
                if (response.isSuccessful) {
                    progressDialog?.dismiss()
                    progressMuseum.visibility = View.GONE

                    val data = response.body()?.data


                    showData(data as List<DataItem>)


                }
            }
        })
    }



    fun getAllMuseum(){
        progressDialog?.show()
        ConfigNetwork.getRetrofitMuseum().getDataMuseumAll().enqueue(object : Callback<ResponseMuseum> {
            override fun onFailure(call: retrofit2.Call<ResponseMuseum>, t: Throwable) {
                progressDialog?.dismiss()
                progressMuseum.visibility = View.GONE
                Log.d("error server"," " + t.message)
                Toast.makeText(this@HomeMuseum, "Gagal menampilkan data!", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: retrofit2.Call<ResponseMuseum>,
                response: Response<ResponseMuseum>
            ) {

                Log.d("response server", response.message())

                //check response server
                if (response.isSuccessful) {
                    progressDialog?.dismiss()
                    progressMuseum.visibility = View.GONE



                    val data = response.body()?.data

                    showData(data as List<DataItem>)


                }
            }
        })
    }

    fun isConnect() : Boolean{

        val connect : ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager


        return  connect.activeNetworkInfo != null && connect.activeNetworkInfo!!.isConnected
    }



    private fun showData(data: List<DataItem>?) {

        listMuseum.adapter =   MuseumAdapter(data)

    }
}