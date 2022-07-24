package com.example.projectsilentwillowmainapplication

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.projectsilentwillowmainapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        val backwards: Button = findViewById(R.id.backwards)
        val forwards: Button = findViewById(R.id.forwards)
        val left: Button = findViewById(R.id.left)
        val right: Button = findViewById(R.id.right)
        val rotateleft: Button = findViewById(R.id.rotateleft)
        val rotateright: Button = findViewById(R.id.rotateright)
        val stop: Button = findViewById(R.id.stop)

        val textView = findViewById<android.widget.TextView>(R.id.teststatus)

        // TODO: Make it so that when a user clicks one of the movement buttons, it A: sends a byte to PSW and B: displays a log of which button was pressed
        // TODO: A: SEND A BYTE
        // TODO: B: DISPLAY A LOG OF WHICH BUTTON WAS PRESSED UNDERNEATH THE SPEED CONTROL BAR ON IN A SEPARATE WINDOW


        backwards.setOnClickListener {
            backwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.moveactivated))
            forwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            left.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            right.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            rotateleft.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            rotateright.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            stop.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            // send BYTE after
            textView.setText("string").toString()
        }
        forwards.setOnClickListener {
            backwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            forwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.moveactivated))
            left.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            right.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            rotateleft.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            rotateright.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            stop.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            // send BYTE after
        }
        left.setOnClickListener {
            backwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            forwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            left.setTextColor(ContextCompat.getColor(applicationContext, R.color.moveactivated))
            right.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            rotateleft.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            rotateright.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            stop.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            // send BYTE after
        }
        right.setOnClickListener {
            backwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            forwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            left.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            right.setTextColor(ContextCompat.getColor(applicationContext, R.color.moveactivated))
            rotateleft.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            rotateright.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            stop.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            // send BYTE after
        }
        rotateleft.setOnClickListener {
            backwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            forwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            left.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            right.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            rotateleft.setTextColor(ContextCompat.getColor(applicationContext, R.color.moveactivated))
            rotateright.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            stop.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            // send BYTE after
        }
        rotateright.setOnClickListener {
            backwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            forwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            left.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            right.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            rotateleft.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            rotateright.setTextColor(ContextCompat.getColor(applicationContext, R.color.moveactivated))
            stop.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            // send BYTE after
        }
        stop.setOnClickListener {
            backwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            forwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            left.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            right.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            rotateleft.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            rotateright.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            stop.setTextColor(ContextCompat.getColor(applicationContext, R.color.moveactivated))
            // send BYTE after
        }
    }
}