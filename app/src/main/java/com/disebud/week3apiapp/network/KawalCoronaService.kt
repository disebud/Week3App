package com.disebud.week3apiapp.network

import com.disebud.week3apiapp.model.ResponseDataCorona
import retrofit2.Call
import retrofit2.http.GET

interface KawalCoronaService {
    @GET("public/api/prov.json")
    fun getDataCorona(): Call<ResponseDataCorona>
}