package com.example.breesmobileapp.ui

import android.annotation.SuppressLint
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        val smokeAnimation = findViewById<ImageView>(R.id.iv_smoke).background as AnimationDrawable
        smokeAnimation.start()

        val rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate)
        findViewById<ImageView>(R.id.iv_smoke).startAnimation(rotateAnimation)


    }
}