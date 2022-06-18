package com.example.newsinformed.model.repository

import com.example.newsinformed.model.Constants
import com.example.newsinformed.model.ModelNews
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IWebService {

    @GET("v2/everything")
    fun getNewsOfAPI(
        @Query("q") id: String?,
        @Query("language") languege: String,
        @Query("sortBy") parameter: String,
        @Query("apiKey") keyApi: String
    ): Call<ModelNews>

    companion object {
        private val retrofit: IWebService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(IWebService::class.java)
        }

        fun getInstance(): IWebService {
            return retrofit
        }
    }
}

// https://newsapi.org/
// v2/
// everything?
// q=agua
// &language=pt
// &sortBy=relevancy
// &apiKey=0ce07b5aee29496f9d2c8b05fb72f0a2
