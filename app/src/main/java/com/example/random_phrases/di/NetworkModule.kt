package com.example.random_phrases.di

import com.example.random_phrases.data.network.QuoteApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module//modulo nos proveera las dependencias
@InstallIn(SingletonComponent::class)//especificamos el alcance
object NetworkModule {

    @Singleton
    @Provides
    fun  providerRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://eng-gate-322422-default-rtdb.firebaseio.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideQuoteApiClient(retrofit: Retrofit): QuoteApiClient {
        return retrofit.create(QuoteApiClient::class.java)

    }
}