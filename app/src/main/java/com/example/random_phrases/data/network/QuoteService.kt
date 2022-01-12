package com.example.random_phrases.data.network

import com.example.random_phrases.core.RetrofitHelper
import com.example.random_phrases.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteService @Inject constructor(private val api:QuoteApiClient) {


    suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO){
            val response = api.getAllQuotes()
            response.body()  ?: emptyList()

        }

    }
}