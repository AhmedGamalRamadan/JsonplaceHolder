package com.example.cleanarch.data.remote

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteRepositoryImp(private val apiService: APIService) : RemoteRepository {

    override suspend fun getAllUsers() =
        withContext(Dispatchers.IO) {
            apiService.getAllUsers()
        }
}

