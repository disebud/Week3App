package com.disebud.week3apiapp.network

import com.disebud.week3apiapp.model.ResponseNews
import retrofit2.Call
import retrofit2.http.GET

interface NewsService {
    @GET("v2/top-headlines?country=us&category=business&apiKey=dde3d89ab8b44cd3bcc6bd7ee0664369")
    fun getDataNews(): Call<ResponseNews>
}

