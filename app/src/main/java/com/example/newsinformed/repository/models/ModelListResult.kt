package com.example.newsinformed.repository.models

import java.io.Serializable

data class ModelListResult(
    val urlToImage: String,
    val source: ModelSource,
    val publishedAt: String,
    val title: String,
    val description: String,
    val content: String
) : Serializable
