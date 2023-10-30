package com.example.breesmobileapp.ui.signup

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.breesmobileapp.databinding.ActivityGetStartedBinding
import com.example.breesmobileapp.ui.signup.verifyemail.VerificationEmailActivity

class GetStartedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGetStartedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetStartedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cv1.setOnClickListener {
            startActivity(Intent(this@GetStartedActivity, VerificationEmailActivity::class.java))
        }
    }
}