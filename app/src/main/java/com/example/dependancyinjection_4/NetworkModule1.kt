package com.example.dependancyinjection_4

import com.example.dependancyinjection_4.NetworkModule.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule1 {

    val base_url = "https://pokeapi.co/api/v2/"


    @Provides
    @Singleton
    fun PostRetrofit(): PostAPIService {
        return Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostAPIService::class.java)
    }
}