package com.example.random_phrases.domain

import com.example.random_phrases.data.model.QuoteModel
import com.example.random_phrases.data.model.QuoteProvider

class GetQuoteRandomUseCase {


    operator fun invoke():  QuoteModel? {
        val quotes = QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            return quotes[(quotes.indices).random()]
        }
        return null
    }
}