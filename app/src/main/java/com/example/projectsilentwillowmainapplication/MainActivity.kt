package com.example.projectsilentwillowmainapplication

import android.bluetooth.*
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.projectsilentwillowmainapplication.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        var m_btSocket: BluetoothSocket? = null
        lateinit var m_device: BluetoothDevice
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

        enablebt.setOnClickListener {enablebt()}
        disablebt.setOnClickListener {disablebt()}
        connectbt.setOnClickListener {connectbt()}

        backwards.setOnClickListener {

        }
        forwards.setOnClickListener {

        }
        left.setOnClickListener {

        }
        right.setOnClickListener {

        }
        rotateleft.setOnClickListener {

        }
        rotateright.setOnClickListener {

        }
        stop.setOnClickListener {

        }
    }

    private fun enablebt() {
        val bluetoothManager: BluetoothManager = getSystemService(BluetoothManager::class.java)
        val bluetoothAdapter: BluetoothAdapter? = bluetoothManager.adapter

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

    private fun connectbt() {
        val connectionstatus: TextView = findViewById(R.id.connectionstatus)
        try {
          val bluetoothManager: BluetoothManager = getSystemService(BluetoothManager::class.java)
          val bluetoothAdapter: BluetoothAdapter? = bluetoothManager.adapter
          if (bluetoothAdapter?.isEnabled == false) {
              Toast.makeText(this, "Please turn on Bluetooth", Toast.LENGTH_SHORT).show()
                } else {
                    val pairedDevices = bluetoothAdapter?.bondedDevices
                    if (pairedDevices?.isNotEmpty() == true) {
                        for (device in pairedDevices) {
                            if (device.name == "HC-05") {
                                if (device.address == "98:D3:71:FE:13:4D") {
                                    m_device = device
                                    val uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")
                                    m_btSocket = m_device.createRfcommSocketToServiceRecord(uuid)
                                    m_btSocket?.connect()
                                    connectionstatus.text = "Connected"
                                    Toast.makeText(this, "Connected to HC-05", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    } else { Toast.makeText(this, "No paired devices", Toast.LENGTH_SHORT).show() }
                }
      } catch (e: Exception) { Toast.makeText(this, "Error connecting to device", Toast.LENGTH_SHORT).show() }
    }

    private fun disablebt() {
        val bluetoothManager: BluetoothManager = getSystemService(BluetoothManager::class.java)
        val bluetoothAdapter: BluetoothAdapter? = bluetoothManager.adapter

        bluetoothAdapter?.disable()
        Toast.makeText(this, "Bluetooth has been turned off", Toast.LENGTH_SHORT).show()
    }
}

/*
*
* if (bluetoothAdapter?.isEnabled == true) {
                backwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                forwards.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                left.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                right.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                rotateleft.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                rotateright.setTextColor(ContextCompat.getColor(applicationContext, R.color.main))
                stop.setTextColor(ContextCompat.getColor(applicationContext, R.color.moveactivated))
                // SEND BYTE 0
            } else { Toast.makeText(this, "ERROR 110", Toast.LENGTH_SHORT).show() }
* */