package com.example.random_phrases.domain

import com.example.random_phrases.data.QuoteRepository
import com.example.random_phrases.data.model.QuoteModel

class GetQuoteUseCase {

    private  val repository  = QuoteRepository()
    //se llama automaticamente sin nombre de alguna funcion solo obj()
    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()


}