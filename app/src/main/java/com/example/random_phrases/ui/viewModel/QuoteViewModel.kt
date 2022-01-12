package com.example.random_phrases.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.random_phrases.data.model.QuoteModel
import com.example.random_phrases.data.model.QuoteProvider
import com.example.random_phrases.domain.GetQuoteRandomUseCase
import com.example.random_phrases.domain.GetQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuoteUseCase: GetQuoteUseCase,
    private val getQuoteRandomUseCase:GetQuoteRandomUseCase
): ViewModel() {
    //encapsulamos el quoteModel en un liveData
    val quoteModel = MutableLiveData<QuoteModel>()
    val quoteLoading = MutableLiveData<Boolean>()


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