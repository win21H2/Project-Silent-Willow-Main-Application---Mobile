package com.example.projectsilentwillowmainapplication

// BLUETOOTH
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
// BLUETOOTH
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.projectsilentwillowmainapplication.databinding.ActivityMainBinding
import android.text.method.ScrollingMovementMethod




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

        val enablebt: Button = findViewById(R.id.enableBT)
        val disablebt: Button = findViewById(R.id.disableBT)
        val connectbt: Button = findViewById(R.id.connect)
        val disconnectbt: Button = findViewById(R.id.disconnect)
        val startbtscan: Button = findViewById(R.id.startBTscan)
        val listbt: TextView = findViewById(R.id.listbt)
        listbt.movementMethod = ScrollingMovementMethod()

        val bluetoothManager: BluetoothManager = getSystemService(BluetoothManager::class.java)
        val bluetoothAdapter: BluetoothAdapter? = bluetoothManager.adapter

        enablebt.setOnClickListener {
            ContextCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT)
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT) == android.content.pm.PackageManager.PERMISSION_GRANTED) {
                bluetoothAdapter?.enable()
                Toast.makeText(this, "Bluetooth has been turned on", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please allow Bluetooth permissions", Toast.LENGTH_SHORT).show()
                requestPermissions(arrayOf(android.Manifest.permission.BLUETOOTH_CONNECT), 1)
            }
        }
        disablebt.setOnClickListener {
            bluetoothAdapter?.disable()
            Toast.makeText(this, "Bluetooth has been turned off", Toast.LENGTH_SHORT).show()
        }

        connectbt.setOnClickListener { Toast.makeText(this, "Sorry, nothing here yet!", Toast.LENGTH_SHORT).show() }
        disconnectbt.setOnClickListener { Toast.makeText(this, "Sorry, nothing here yet!", Toast.LENGTH_SHORT).show() }

        startbtscan.setOnClickListener {
            val pairedDevices = bluetoothAdapter?.bondedDevices
            val list = ArrayList<String>()
            for (device in pairedDevices!!) {
                list.add(device.name + " : " + device.address + "\n")
            }
            listbt.text = list.toString()
        }

        backwards.setOnClickListener {
            backwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.moveactivated))
            forwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            left.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            right.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            rotateleft.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            rotateright.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            stop.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
        }
        forwards.setOnClickListener {
            backwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            forwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.moveactivated))
            left.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            right.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            rotateleft.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            rotateright.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            stop.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
        }
        left.setOnClickListener {
            backwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            forwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            left.setTextColor(ContextCompat.getColor(applicationContext, R.color.moveactivated))
            right.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            rotateleft.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            rotateright.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            stop.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
        }
        right.setOnClickListener {
            backwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            forwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            left.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            right.setTextColor(ContextCompat.getColor(applicationContext, R.color.moveactivated))
            rotateleft.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            rotateright.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            stop.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
        }
        rotateleft.setOnClickListener {
            backwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            forwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            left.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            right.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            rotateleft.setTextColor(ContextCompat.getColor(applicationContext, R.color.moveactivated))
            rotateright.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            stop.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
        }
        rotateright.setOnClickListener {
            backwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            forwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            left.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            right.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            rotateleft.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            rotateright.setTextColor(ContextCompat.getColor(applicationContext, R.color.moveactivated))
            stop.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
        }
        stop.setOnClickListener {
            backwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            forwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            left.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            right.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            rotateleft.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            rotateright.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
            stop.setTextColor(ContextCompat.getColor(applicationContext, R.color.moveactivated))
        }
    }
}