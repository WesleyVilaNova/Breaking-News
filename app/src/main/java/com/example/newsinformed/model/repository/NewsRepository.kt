package com.example.newsinformed.model.repository

import com.example.newsinformed.model.Constants

class NewsRepository(val iWebService: IWebService) {

    fun getNewsRepository(search: String) =
        iWebService.getNewsOfAPI(search, Constants.LANGUAGE, Constants.PARAMETER, Constants.API_KEY)
}
