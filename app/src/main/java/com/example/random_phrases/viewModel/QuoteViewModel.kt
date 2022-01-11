package com.example.random_phrases.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.random_phrases.model.QuoteModel
import com.example.random_phrases.model.QuoteProvider

class QuoteViewModel: ViewModel() {
    //encapsulamos el quoteModel en un liveData
    val quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuote(){
        val currentQuote = QuoteProvider.getQuoteRandom()
        //avisara a la view de que hubo cambios
        quoteModel.postValue(currentQuote)
    }
}