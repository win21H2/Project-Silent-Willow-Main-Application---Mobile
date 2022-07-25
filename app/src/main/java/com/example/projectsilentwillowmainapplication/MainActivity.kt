package com.example.projectsilentwillowmainapplication

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
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


        val connect: Button = findViewById(R.id.connect)
        val bluetoothManager: BluetoothManager = getSystemService(BluetoothManager::class.java)
        val bluetoothAdapter: BluetoothAdapter? = bluetoothManager.adapter

        /*requestpermission.setOnClickListener {
            ContextCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT)
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT) == android.content.pm.PackageManager.PERMISSION_GRANTED) {
                bluetoothAdapter?.enable()
                Toast.makeText(this, "Bluetooth permissions have already been granted!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please enable Bluetooth permissions to control Project Silent Willow!", Toast.LENGTH_SHORT).show()
                requestPermissions(arrayOf(android.Manifest.permission.BLUETOOTH_CONNECT), 1)
            }
        }*/

        connect.setOnClickListener {
            if (!bluetoothAdapter!!.isEnabled) {
                Toast.makeText(this, "Bluetooth is off!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Bluetooth is already on!", Toast.LENGTH_SHORT).show()
            }
        }
        //TODO: IF THE USER CLICKS ENABLEBT AND THE PERM IS NOT ALREADY GRANTED, ASK THE USER TO GRANT ACCESS
        //TODO: MAYBE BRING THE SUER TO A NEW PAGE WITH ALL OF THE BLUETOOTH RELATED BUTTONS ALTHOUGH IT MIGHT BE HARD TO PASS DATA FROM THE BT SCREEN TO THE MAIN SCREEN

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