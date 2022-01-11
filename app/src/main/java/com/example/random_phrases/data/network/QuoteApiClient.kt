package com.example.random_phrases.data.network

import com.example.random_phrases.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {

    @GET("/quotes.json")
    suspend fun getAllQuotes():Response<List<QuoteModel>>
}