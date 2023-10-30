package com.example.breesmobileapp.ui.signup

import android.content.Intent
import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.breesmobileapp.data.remote.api.DataState
import com.example.breesmobileapp.data.remote.model.User
import com.example.breesmobileapp.databinding.ActivitySignUpBinding
import com.example.breesmobileapp.ui.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SignUpActivity : AppCompatActivity() {

    private val viewModel: SignUpViewModel by viewModels()
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.ivArrowBack.setOnClickListener {
            startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
        }

        binding.registerBtn.setOnClickListener {
            signUp()
        }
        viewModel.signUpResult.observe(this) { state ->
            when (state) {
                is DataState.Init -> {
                    isLoading(true)
                    Log.d("SignUpActivity", "INIT")
                }

                is DataState.Success -> {
                    isLoading(false)
//                    state.data.name
                    val user: User = state.data
                    Log.d("SignUpActivity", "sucesss")
                    Toast.makeText(this, "Hallo User ${user.email.toString()}", Toast.LENGTH_SHORT)
                        .show()
                    // Handle success state
                }

                is DataState.Failure -> {
                    isLoading(false)
                    Log.d("SignUpActivity", "failure")
                    Toast.makeText(this, "Failure SignUp", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun signUp() {
        val name = binding.edtName.text.toString()
        val email = binding.edtEmail.text.toString()
        val password = binding.edtPasswordLogin.text.toString()

        if (name.length < 6) {
            // Nama kurang dari 6 karakter, tampilkan pesan kesalahan
            binding.edtName.error = "Nama harus memiliki setidaknya 6 karakter"
            return
        }

        if (email.isEmpty() || email.length < 6 || !android.util.Patterns.EMAIL_ADDRESS.matcher(
                email
            ).matches()
        ) {
            // Email kosong, kurang dari 6 karakter, atau tidak valid, tampilkan pesan kesalahan
            binding.edtEmail.error = "Masukkan email yang valid (minimal 6 karakter)"
            return
        }

        if (password.length < 6) {
            // Password kurang dari 6 karakter, tampilkan pesan kesalahan
            binding.edtPasswordLogin.error = "Password harus memiliki setidaknya 6 karakter"
            return
        }
        viewModel.signUp(email, password)

    }

    private fun isLoading(state: Boolean) {
        if (state) {
            binding.loadingProgressBar.visibility = View.VISIBLE
        } else {
            binding.loadingProgressBar.visibility = View.GONE
        }

    }
}