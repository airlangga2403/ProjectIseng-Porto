package com.example.breesmobileapp.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.breesmobileapp.R
import com.example.breesmobileapp.databinding.ActivitySignUpBinding
import com.example.breesmobileapp.ui.login.LoginActivity

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.ivArrowBack.setOnClickListener {
            startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
        }
    }
}