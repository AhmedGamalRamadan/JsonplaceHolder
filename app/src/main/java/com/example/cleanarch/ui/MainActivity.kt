package com.example.cleanarch.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanarch.adapter.UserAdapter
import com.example.cleanarch.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getAllUser()

        binding.rvUser.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            try {
                binding.progressBar.isVisible = true
                viewModel.userStateFlow.collect {
                    val allUser = it
                    val adapter = UserAdapter(this@MainActivity, allUser)
                    binding.rvUser.adapter = adapter
                    delay(10000L)
                    binding.progressBar.isVisible = false
                }
            } catch (e: IOException) {
                withContext(Dispatchers.Main) {
                    binding.progressBar.isVisible = true
                }
            }
        }
    }
}


