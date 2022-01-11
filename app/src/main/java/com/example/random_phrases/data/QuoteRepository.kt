package com.example.random_phrases.data

import com.example.random_phrases.data.model.QuoteModel
import com.example.random_phrases.data.model.QuoteProvider
import com.example.random_phrases.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response

    }
}