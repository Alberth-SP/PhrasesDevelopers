package com.example.random_phrases.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.random_phrases.data.model.QuoteModel
import com.example.random_phrases.data.model.QuoteProvider
import com.example.random_phrases.domain.GetQuoteRandomUseCase
import com.example.random_phrases.domain.GetQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel: ViewModel() {
    //encapsulamos el quoteModel en un liveData
    val quoteModel = MutableLiveData<QuoteModel>()
    val quoteLoading = MutableLiveData<Boolean>()
    var getQuoteUseCase = GetQuoteUseCase()
    var getQuoteRandomUseCase = GetQuoteRandomUseCase()

    fun randomQuote(){
        quoteLoading.postValue(true)
        //llamamos a un caso de uso nuevo
        var quote = getQuoteRandomUseCase()
        if (quote!= null){
            quoteModel.postValue(quote)
        }

        quoteLoading.postValue(false)
        /*
        val currentQuote = QuoteProvider.getQuoteRandom()
        //avisara a la view de que hubo cambios
        quoteModel.postValue(currentQuote) */
    }

    fun onCreate() {

        viewModelScope.launch {
            quoteLoading.postValue(true)
            var result = getQuoteUseCase()
            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[(result.indices).random()])
                quoteLoading.postValue(false)
            }
        }
    }
}