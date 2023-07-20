package com.example.breesmobileapp.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.breesmobileapp.R
import com.example.breesmobileapp.databinding.ActivitySplashScreenBinding
import com.example.breesmobileapp.ui.onboarding.OnboardingActivity

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Delay the splash screen for 2 seconds (adjust as needed)
        val splashDurationMillis = 2000
        Thread {
            try {
                Thread.sleep(splashDurationMillis.toLong())
            } catch (e: InterruptedException) {
                e.printStackTrace()
            } finally {
                // After the splash screen duration, start the next activity
                val intent = Intent(this, OnboardingActivity::class.java) // Replace MainActivity with your desired activity
                startActivity(intent)
                finish() // Optional: finish the splash screen activity so it won't be shown when back button is pressed
            }
        }.start()

    }
}