package com.example.breesmobileapp.presentation.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.breesmobileapp.databinding.ActivityGetStartedBinding
import com.example.breesmobileapp.utils.startActivity

class GetStartedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGetStartedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetStartedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cv1.setOnClickListener {
            startActivity(VerificationEmailActivity::class.java)
        }
    }
}