package com.example.breesmobileapp.ui.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.breesmobileapp.R
import com.example.breesmobileapp.databinding.ActivityOnboardingBinding
import com.example.breesmobileapp.ui.login.LoginActivity

class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOb3.setOnClickListener {
            startActivity(Intent(this@OnboardingActivity, LoginActivity::class.java))
            finish()
        }

    }
}