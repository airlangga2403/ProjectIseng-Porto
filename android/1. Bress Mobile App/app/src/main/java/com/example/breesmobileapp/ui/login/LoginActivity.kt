package com.example.breesmobileapp.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.breesmobileapp.databinding.ActivityLoginBinding
import com.example.breesmobileapp.ui.signup.GetStartedActivity
import com.example.breesmobileapp.ui.signup.SignUpActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerBtn.setOnClickListener {
            startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
        }

        binding.loginBtn.setOnClickListener {
            startActivity(Intent(this@LoginActivity, GetStartedActivity::class.java))

        }
    }
}