package com.example.breesmobileapp.ui.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.breesmobileapp.R
import com.example.breesmobileapp.databinding.ActivityGetStartedBinding

class GetStartedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGetStartedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetStartedBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}