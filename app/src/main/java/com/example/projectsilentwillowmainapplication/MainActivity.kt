package com.example.projectsilentwillowmainapplication

import android.bluetooth.*
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.projectsilentwillowmainapplication.databinding.ActivityMainBinding
import org.w3c.dom.Text
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

        val backwards: Button = findViewById(R.id.backwards); val forwards: Button = findViewById(R.id.forwards)
        val left: Button = findViewById(R.id.left); val right: Button = findViewById(R.id.right)
        val rotateleft: Button = findViewById(R.id.rotateleft); val rotateright: Button = findViewById(R.id.rotateright)
        val speed: SeekBar = findViewById(R.id.speed)
        val stop: Button = findViewById(R.id.stop)

        val others: Button = findViewById(R.id.others); val relayoff: Button = findViewById(R.id.relayoff); val relayon: Button = findViewById(R.id.relayon)
        others.setOnClickListener { others() }; relayoff.setOnClickListener { relayoff() }; relayon.setOnClickListener { relayon() }

        val enablebt: Button = findViewById(R.id.enableBT); enablebt.setOnClickListener {enablebt()}
        val disablebt: Button = findViewById(R.id.disableBT); disablebt.setOnClickListener {disablebt()}
        val connectbt: Button = findViewById(R.id.connect); connectbt.setOnClickListener {connectbt()}
        val disconnectbt: Button = findViewById(R.id.disconnect); disconnectbt.setOnClickListener {disconnectbt()}

        speed.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (m_btSocket != null) {
                    if (progress > 9) {
                        val bytes = ByteArray(1)
                        bytes[0] = progress.toByte()
                        m_btSocket!!.outputStream.write(bytes)
                        //TODO: make the speed change actually happen so that when the user changes the value, it would simultaneously change the speed of PSW
                    }
                } else { socketerror() }
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
        stop.setOnClickListener {
            val bytes = byteArrayOf(0.toByte())
            if (m_btSocket != null) {
                m_btSocket?.outputStream?.write(bytes)
            } else { socketerror() }
        }
        backwards.setOnClickListener {
            val bytes = byteArrayOf(1.toByte())
            if (m_btSocket != null) {
                m_btSocket?.outputStream?.write(bytes)
            } else { socketerror() }
        }
        forwards.setOnClickListener {
            val bytes = byteArrayOf(2.toByte())
            if (m_btSocket != null) {
                m_btSocket?.outputStream?.write(bytes)
            } else { socketerror() }
        }
        left.setOnClickListener {
            val bytes = byteArrayOf(3.toByte())
            if (m_btSocket != null) {
                m_btSocket?.outputStream?.write(bytes)
            } else { socketerror() }
        }
        right.setOnClickListener {
            val bytes = byteArrayOf(4.toByte())
            if (m_btSocket != null) {
                m_btSocket?.outputStream?.write(bytes)
            } else { socketerror() }
        }
        rotateleft.setOnClickListener {
            val bytes = byteArrayOf(5.toByte())
            if (m_btSocket != null) {
                m_btSocket?.outputStream?.write(bytes)
            } else { socketerror() }
        }
        rotateright.setOnClickListener {
            val bytes = byteArrayOf(6.toByte())
            if (m_btSocket != null) {
                m_btSocket?.outputStream?.write(bytes)
            } else { socketerror() }
        }
    }

    private fun enablebt() {
        val bluetoothManager: BluetoothManager = getSystemService(BluetoothManager::class.java)
        val bluetoothAdapter: BluetoothAdapter? = bluetoothManager.adapter
        ContextCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT)
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT) == android.content.pm.PackageManager.PERMISSION_GRANTED) {
            bluetoothAdapter?.enable()
            Toast.makeText(this, "BT ON", Toast.LENGTH_SHORT).show()
        } else { requestPermissions(arrayOf(android.Manifest.permission.BLUETOOTH_CONNECT), 1) }
    }

    private fun socketerror() { Toast.makeText(this, "SOCKET NOT CONNECTED", Toast.LENGTH_SHORT).show() }

    private fun connectbt() {
        val bluetoothManager: BluetoothManager = getSystemService(BluetoothManager::class.java)
        val bluetoothAdapter: BluetoothAdapter? = bluetoothManager.adapter
        val connectionstatus: TextView = findViewById(R.id.connectionstatus)
        val deviceinfo: TextView = findViewById(R.id.deviceinfo)
        val pairedDevices = bluetoothAdapter?.bondedDevices
        val uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")
        try {
          if (bluetoothAdapter?.isEnabled == false) {
                Toast.makeText(this, "ERROR BT OFF", Toast.LENGTH_SHORT).show()
          } else {
            for (device in pairedDevices!!) {
              if (device.address == "98:D3:71:FE:13:4D") {
                  deviceinfo.text = (device.name + " : " + device.address + " : " + device.bondState + " : " + device.type + " : " + device.uuids)
                  m_device = device
                  m_btSocket = m_device.createRfcommSocketToServiceRecord(uuid)
                  m_btSocket?.connect()
                  connectionstatus.setTextColor(ContextCompat.getColor(applicationContext, R.color.connected))
              }
            }
          }
      } catch (e: Exception) { Toast.makeText(this, "ERROR DEVICE CONNECT", Toast.LENGTH_SHORT).show() }
    }

    private fun disconnectbt() {
        val connectionstatus: TextView = findViewById(R.id.connectionstatus)
        if (m_btSocket != null) {
            try { m_btSocket?.close(); connectionstatus.setTextColor(ContextCompat.getColor(applicationContext, R.color.disconnected)) }
            catch (e: Exception) { Toast.makeText(this, "ERROR DEVICE DISCONNECT", Toast.LENGTH_SHORT).show() }
        } else { socketerror() }
    }

    private fun disablebt() {
        val bluetoothManager: BluetoothManager = getSystemService(BluetoothManager::class.java)
        val bluetoothAdapter: BluetoothAdapter? = bluetoothManager.adapter
        bluetoothAdapter?.disable()
        Toast.makeText(this, "BT OFF", Toast.LENGTH_SHORT).show()
    }

    private fun others() {
        val intent = Intent(this, Others::class.java)
        startActivity(intent)
    }

    private fun relayon() {
        val bytes = byteArrayOf(7.toByte())
        if (m_btSocket != null) {
            m_btSocket?.outputStream?.write(bytes)
        } else { socketerror() }
    }

    private fun relayoff() {
        val bytes = byteArrayOf(8.toByte())
        if (m_btSocket != null) {
            m_btSocket?.outputStream?.write(bytes)
        } else { socketerror() }
    }
}