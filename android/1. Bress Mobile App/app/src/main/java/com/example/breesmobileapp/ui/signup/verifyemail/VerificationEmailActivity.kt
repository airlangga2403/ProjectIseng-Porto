package com.example.breesmobileapp.ui.signup.verifyemail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.breesmobileapp.R
import com.example.breesmobileapp.databinding.ActivityVerificationEmailBinding

class VerificationEmailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityVerificationEmailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerificationEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}