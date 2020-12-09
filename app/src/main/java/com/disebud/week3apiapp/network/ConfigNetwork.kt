package com.disebud.week3apiapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigNetwork {


    companion object {
        fun getRetrofit() : NewsService {

            val retrofit = Retrofit.Builder()
                    .baseUrl("http://newsapi.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            val service = retrofit.create(NewsService::class.java)

            return service
        }

        fun getRetrofitKawalCorona() : KawalCoronaService {

            val retrofit = Retrofit.Builder()
                .baseUrl("https://data.covid19.go.id/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create(KawalCoronaService::class.java)

            return service
        }

        fun getRetrofitMuseum() : MuseumService {

            val retrofit = Retrofit.Builder()
                .baseUrl("http://jendela.data.kemdikbud.go.id/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val serviceM = retrofit.create(MuseumService::class.java)

            return serviceM
        }

        fun getRetrofitDaerahInd() : DaerahService {

            val retrofit = Retrofit.Builder()
                .baseUrl("https://dev.farizdotid.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create(DaerahService::class.java)

            return service
        }


    }
}