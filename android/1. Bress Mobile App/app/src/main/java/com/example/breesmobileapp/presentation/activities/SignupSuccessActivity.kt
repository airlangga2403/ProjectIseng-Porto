package com.example.breesmobileapp.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.breesmobileapp.databinding.ActivitySignupSuccessBinding

class SignupSuccessActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupSuccessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupSuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}