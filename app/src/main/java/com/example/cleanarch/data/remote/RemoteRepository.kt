package com.example.cleanarch.data.remote

import com.example.cleanarch.model.User
import retrofit2.Response

interface RemoteRepository {

    suspend fun getAllUsers(): Response<List<User>>
}