package com.example.dependancyinjection_4

import retrofit2.http.GET
import retrofit2.http.Path

interface PostAPIService {

    @GET("pokemon/{name}")
    suspend fun getUsers(
        @Path("name" )name : String
    ) : Posts

}