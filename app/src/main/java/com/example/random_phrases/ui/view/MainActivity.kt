package com.example.random_phrases.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.random_phrases.databinding.ActivityMainBinding
import com.example.random_phrases.ui.viewModel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()
        //el codigo dentro de observer se ejecutara cada vez q se detecte un cambio en el modelo
        quoteViewModel.quoteModel.observe(this, Observer { current ->
            binding.tvQuote.text = current.quote
            binding.tvAuthor.text = current.author

        })

        quoteViewModel.quoteLoading.observe(this, {
            binding.pbProgress.isVisible = it
        })

        binding.viewContainer.setOnClickListener{
            quoteViewModel.randomQuote()
        }
    }
}