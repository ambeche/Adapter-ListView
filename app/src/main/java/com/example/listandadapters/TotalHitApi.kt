package com.example.listandadapters

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object TotalHitApi {
    const val URL = "https://en.wikipedia.org/"
    object Model {
        data class PresidentQuery(val searchInfo: SearchInfo )
        data class SearchInfo(val totalHits: String)
    }

    interface Service {
        @GET("w/api.php?action=query&format=json&list=search")
        suspend fun presidentName(@Query("srsearch") search: String): Model.PresidentQuery
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service = retrofit.create(Service::class.java)!!
}
