package com.example.newsinformed.repository.utils

class Constants {

    internal companion object {

        const val BASE_URL: String = "https://newsapi.org/"
        const val PATH_URL: String = "v2/everything"
        const val LANGUAGE: String = "pt"
        const val PARAMETER: String = "relevancy"
        const val API_KEY: String = "0ce07b5aee29496f9d2c8b05fb72f0a2"
    }
}

// https://newsapi.org/v2/
// everything?q=caruaru&language=pt&sortBy=relevancy&apiKey=0ce07b5aee29496f9d2c8b05fb72f0a2
