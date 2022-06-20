package com.example.newsinformed.repository.api

import com.example.newsinformed.repository.models.ModelNews
import com.example.newsinformed.repository.utils.Constants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface IWebService {

    @GET(Constants.PATH_URL)
    fun getNewsOfAPI(
        @Query("q") id: String?,
        @Query("language") languege: String,
        @Query("sortBy") parameter: String,
        @Query("apiKey") keyApi: String
    ): Call<ModelNews>

    @GET("v2/top-headlines?country=br")
    fun getCategoryOfNewsApi(
        @Query("category") category: String,
        @Query("apikey") keyApi: String
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
// https://newsapi.org/v2/top-headlines?country=br&category=business&apiKey=0ce07b5aee29496f9d2c8b05fb72f0a2
// https://newsapi.org/
// v2/
// everything?
// q=agua
// &language=pt
// &sortBy=relevancy
// &apiKey=0ce07b5aee29496f9d2c8b05fb72f0a2
