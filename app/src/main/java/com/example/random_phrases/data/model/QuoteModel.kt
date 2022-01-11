package com.example.random_phrases.data.model

import com.google.gson.annotations.SerializedName

data class QuoteModel (
    @SerializedName("author") var author: String,
    @SerializedName("quote") var quote: String

    )