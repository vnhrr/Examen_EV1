package com.example.ejer_intents_1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNombre = findViewById<EditText>(R.id.editTextNombre)
        var textViewEdad = findViewById<TextView>(R.id.textViewEdadReal)
        val seekbarEdad = findViewById<SeekBar>(R.id.seekBarEdad)
        var edad = ""
        seekbarEdad.min = 10
        seekbarEdad.max = 100
        val buttonEnviar = findViewById<Button>(R.id.buttonEnviar)

        var nombre = editTextNombre.text

        seekbarEdad.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textViewEdad.text = "$progress"
                edad = progress.toString()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        buttonEnviar.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("datos", "Tu nombre es $nombre y tienes $edad years")
            setResult(Activity.RESULT_OK, intent)
            this.startActivity(intent)
        }

    }
}