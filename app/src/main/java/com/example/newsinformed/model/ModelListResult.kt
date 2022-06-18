package com.example.newsinformed.model

import java.io.Serializable

data class ModelListResult(
    val urlToImage: String,
    val name: String,
    val publishedAt: String,
    val title: String,
    val description: String
) : Serializable