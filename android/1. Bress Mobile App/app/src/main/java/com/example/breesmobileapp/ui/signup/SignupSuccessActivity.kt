package com.example.breesmobileapp.ui.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.breesmobileapp.R
import com.example.breesmobileapp.databinding.ActivitySignupSuccessBinding

class SignupSuccessActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupSuccessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupSuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}