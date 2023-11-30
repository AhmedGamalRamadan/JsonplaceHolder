package com.example.cleanarch.data.remote

import com.example.cleanarch.model.User
import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    @GET("posts")
    suspend fun getAllUsers(): Response<List<User>>
}