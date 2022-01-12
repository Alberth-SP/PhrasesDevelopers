package com.example.random_phrases.domain

import com.example.random_phrases.data.QuoteRepository
import com.example.random_phrases.data.model.QuoteModel
import javax.inject.Inject

class GetQuoteUseCase @Inject constructor(
    private val repository: QuoteRepository
) {
    //se llama automaticamente sin nombre de alguna funcion solo obj()
    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()


}