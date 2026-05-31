package com.example.dependancyinjection_4

import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("pokemon")
    suspend fun getPosts(
        @Query("page")page : Int
    ): Users
}