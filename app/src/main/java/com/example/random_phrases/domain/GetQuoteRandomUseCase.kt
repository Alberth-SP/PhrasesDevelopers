package com.example.random_phrases.domain

import com.example.random_phrases.data.model.QuoteModel
import com.example.random_phrases.data.model.QuoteProvider
import javax.inject.Inject

class GetQuoteRandomUseCase @Inject constructor(private val quoteProvider: QuoteProvider){


    operator fun invoke():  QuoteModel? {
        val quotes = quoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            return quotes[(quotes.indices).random()]
        }
        return null
    }
}