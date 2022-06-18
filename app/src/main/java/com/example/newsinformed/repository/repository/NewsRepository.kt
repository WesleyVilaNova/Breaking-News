package com.example.newsinformed.repository.repository

import com.example.newsinformed.repository.utils.Constants

class NewsRepository(private val iWebService: IWebService) {

    fun getNewsRepository(search: String) =
        iWebService.getNewsOfAPI(search, Constants.LANGUAGE, Constants.PARAMETER, Constants.API_KEY)
}
