package com.example.cleanarch.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarch.data.remote.RemoteRepositoryImp
import com.example.cleanarch.data.remote.RetrofitBuilder
import com.example.cleanarch.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val remoteRepositoryImp: RemoteRepositoryImp

    init {
        val service = RetrofitBuilder.apiUser
        remoteRepositoryImp = RemoteRepositoryImp(service)
    }


    private val _userStateFlow = MutableStateFlow<List<User>>(emptyList())
    val userStateFlow: StateFlow<List<User>> = _userStateFlow


    fun getAllUser() = viewModelScope.launch {
        val response = remoteRepositoryImp.getAllUsers()

        if (response.isSuccessful && response.body() != null) {
            _userStateFlow.value = response.body()!!
        } else {
            Log.d("MainViewModel", response.message())
        }
    }


}