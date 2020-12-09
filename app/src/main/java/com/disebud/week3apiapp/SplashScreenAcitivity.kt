package com.disebud.week3apiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreenAcitivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen_acitivity)


        Handler().postDelayed(Runnable {

            startActivity(Intent(this,MainActivity::class.java))

        },3000)
    }
}
