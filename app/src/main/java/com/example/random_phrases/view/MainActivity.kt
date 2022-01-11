package com.example.random_phrases.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.random_phrases.databinding.ActivityMainBinding
import com.example.random_phrases.viewModel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //el codigo dentro de observer se ejecutara cada vez q se detecte un cambio en el modelo
        quoteViewModel.quoteModel.observe(this, Observer { current ->
            binding.tvQuote.text = current.quote
            binding.tvAuthor.text = current.author

        })

        binding.viewContainer.setOnClickListener{
            quoteViewModel.randomQuote()
        }
    }
}