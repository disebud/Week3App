package com.disebud.week3apiapp.network

import com.disebud.week3apiapp.model.ResponseMuseum
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MuseumService {
    @GET("api/index.php/CcariMuseum/searchGET?nama=museum")
    fun getDataMuseumAll(): Call<ResponseMuseum>

    @GET("api/index.php/CcariMuseum/searchGET?nama=")
    fun getDataMuseumByNama(@Query("nama") nama : String): Call<ResponseMuseum>
}