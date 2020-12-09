package com.disebud.week3apiapp.network

import com.disebud.week3apiapp.model.ResponseDaerah
import com.disebud.week3apiapp.model.ResponseMuseum
import retrofit2.Call
import retrofit2.http.GET


interface DaerahService {
    @GET("api/daerahindonesia/provinsi")
    fun getDataDaerah(): Call<ResponseDaerah>
}