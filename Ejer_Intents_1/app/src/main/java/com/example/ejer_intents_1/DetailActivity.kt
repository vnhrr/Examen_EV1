package com.example.ejer_intents_1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class DetailActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        var textViewDatos = findViewById<TextView>(R.id.textViewDetalles)

        textViewDatos.text = intent.getStringExtra("datos")
    }
}