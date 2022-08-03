package com.example.projectsilentwillowmainapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Others : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_others)

        val home: Button = findViewById(R.id.home)
        val license: Button = findViewById(R.id.license)
        val about: Button = findViewById(R.id.about)

        home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        license.setOnClickListener {
            val intent = Intent(this, License::class.java)
            startActivity(intent)
        }
        about.setOnClickListener {
            val intent = Intent(this, About::class.java)
            startActivity(intent)
        }
    }
}