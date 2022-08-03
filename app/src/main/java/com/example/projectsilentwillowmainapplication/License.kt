package com.example.projectsilentwillowmainapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class License : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_license)

        val home: Button = findViewById(R.id.home)
        home.setOnClickListener { finish() }
    }
}