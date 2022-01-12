package com.example.random_phrases.data

import com.example.random_phrases.data.model.QuoteModel
import com.example.random_phrases.data.model.QuoteProvider
import com.example.random_phrases.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val api:QuoteService, private val quoteProvider: QuoteProvider){

    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
        quoteProvider.quotes = response
        return response

    }
}