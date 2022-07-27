package com.example.projectsilentwillowmainapplication

// BLUETOOTH
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.TextView
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
    //val SERVICE_ID = "00001101-0000-1000-8000-00805f9b34fb" //SPP UUID
    //val SERVICE_ADDRESS = "98:D3:31:FB:82:85" // HC-05 BT ADDRESS


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

        // turn on/off BT
        enablebt.setOnClickListener {
            ContextCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT)
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT) == android.content.pm.PackageManager.PERMISSION_GRANTED) {
                bluetoothAdapter?.enable()
                if (bluetoothAdapter?.isEnabled == true) {
                    Toast.makeText(this, "Bluetooth has already been turned on", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Bluetooth is now turned on", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please allow Bluetooth permissions", Toast.LENGTH_SHORT).show()
                requestPermissions(arrayOf(android.Manifest.permission.BLUETOOTH_CONNECT), 1)
            }
        }
        disablebt.setOnClickListener {
            bluetoothAdapter?.disable()
            Toast.makeText(this, "Bluetooth has been turned off", Toast.LENGTH_SHORT).show()
        }

        // scan BT devices
        startbtscan.setOnClickListener {
            val pairedDevices = bluetoothAdapter?.bondedDevices
            val list = ArrayList<String>()
            if (bluetoothAdapter?.isEnabled == false) {
                Toast.makeText(this, "Please turn on Bluetooth", Toast.LENGTH_SHORT).show()
            } else {
                if (pairedDevices?.isNotEmpty() == true) {
                    for (device in pairedDevices) {
                        if (device.name == "HC-05") {
                            if (device.address == "98:D3:71:FE:13:4D") {
                                list.add(device.name + " @ " + device.address)
                            }
                        }
                    }
                    listbt.text = list.toString()
                } else {
                    Toast.makeText(this, "No paired devices", Toast.LENGTH_SHORT).show()
                }
            }
        }
        /*
        TODO: try to check if the name is "HC-05" and the address is "98:D3:71:FE:13:4D" and then change the color to an example red color
        TODO: Try to make it so that when the user clicks the connect button, it will not only connect
        TODO: to the HC-05 but it will also change the color of the connection status bar to green
        TODO: it will also hide the paired devices section and if the user clicks the connect button
        TODO: again, it will return a toast which has something like you are already connected to the HC-05
        TODO: look through here: https://developer.android.com/guide/topics/connectivity/bluetooth/connect-bluetooth-devices
        */


        // connect/disconnect/list BT devices
        connectbt.setOnClickListener {

        }
        disconnectbt.setOnClickListener { Toast.makeText(this, "Sorry, nothing here yet!", Toast.LENGTH_SHORT).show() }

        listbt.setOnClickListener {
            Toast.makeText(this, "Sorry, nothing here yet!", Toast.LENGTH_SHORT).show()
        }

        // movement button code
        backwards.setOnClickListener {
            if (bluetoothAdapter?.isEnabled == true) {
                backwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.moveactivated))
                forwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                left.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                right.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                rotateleft.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                rotateright.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                stop.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                // SEND BYTE 7
            } else {
                Toast.makeText(this, "ERROR 110", Toast.LENGTH_SHORT).show()
            }
        }
        forwards.setOnClickListener {
            if (bluetoothAdapter?.isEnabled == true) {
                backwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                forwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.moveactivated))
                left.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                right.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                rotateleft.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                rotateright.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                stop.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                // SEND BYTE 2
            } else {
                Toast.makeText(this, "ERROR 110", Toast.LENGTH_SHORT).show()
            }
        }
        left.setOnClickListener {
            if (bluetoothAdapter?.isEnabled == true) {
                backwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                forwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                left.setTextColor(ContextCompat.getColor(applicationContext, R.color.moveactivated))
                right.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                rotateleft.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                rotateright.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                stop.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                // SEND BYTE 4
            } else {
                Toast.makeText(this, "ERROR 110", Toast.LENGTH_SHORT).show()
            }
        }
        right.setOnClickListener {
            if (bluetoothAdapter?.isEnabled == true) {
                backwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                forwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                left.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                right.setTextColor(ContextCompat.getColor(applicationContext, R.color.moveactivated))
                rotateleft.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                rotateright.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                stop.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                // SEND BYTE 5
            } else {
                Toast.makeText(this, "ERROR 110", Toast.LENGTH_SHORT).show()
            }
        }
        rotateleft.setOnClickListener {
            if (bluetoothAdapter?.isEnabled == true) {
                backwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                forwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                left.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                right.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                rotateleft.setTextColor(ContextCompat.getColor(applicationContext, R.color.moveactivated))
                rotateright.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                stop.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                // SEND BYTE 9
            } else {
                Toast.makeText(this, "ERROR 110", Toast.LENGTH_SHORT).show()
            }
        }
        rotateright.setOnClickListener {
            if (bluetoothAdapter?.isEnabled == true) {
                backwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                forwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                left.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                right.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                rotateleft.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                rotateright.setTextColor(ContextCompat.getColor(applicationContext, R.color.moveactivated))
                stop.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                // SEND BYTE 10
            } else {
                Toast.makeText(this, "ERROR 110", Toast.LENGTH_SHORT).show()
            }
        }
        stop.setOnClickListener {
            if (bluetoothAdapter?.isEnabled == true) {
                backwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                forwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                left.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                right.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                rotateleft.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                rotateright.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                stop.setTextColor(ContextCompat.getColor(applicationContext, R.color.moveactivated))
                // SEND BYTE 0
            } else {
                Toast.makeText(this, "ERROR 110", Toast.LENGTH_SHORT).show()
            }
        }
    }
}