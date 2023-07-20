package com.example.breesmobileapp.ui

import android.annotation.SuppressLint
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.breesmobileapp.R
import com.example.breesmobileapp.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ivSmoke = findViewById<ImageView>(R.id.iv_smoke)
        val backgroundDrawable = ivSmoke.background
        Log.d("Animation", "ImageView Background: $backgroundDrawable")


    }
}