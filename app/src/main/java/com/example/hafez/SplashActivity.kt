package com.example.hafez

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    private val splashTimeOut: Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
        Handler().postDelayed(
            kotlinx.coroutines.Runnable {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }, splashTimeOut
        )
    }
}