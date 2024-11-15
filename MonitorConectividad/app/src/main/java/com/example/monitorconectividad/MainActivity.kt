package com.example.monitorconectividad

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.widget.TextClock
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var conexionText: TextView
    private val conexionReceiver = object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            var conexion: Int = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                 NetworkCapabilities.NET_CAPABILITY_INTERNET {

                }
            } else {
                TODO("VERSION.SDK_INT < R")
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerReceiver(conexionReceiver, IntentFilter(Intent.ACTION_MANAGE_NETWORK_USAGE))
    }
}