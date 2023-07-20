package com.example.breesmobileapp.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.breesmobileapp.R
import com.example.breesmobileapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}