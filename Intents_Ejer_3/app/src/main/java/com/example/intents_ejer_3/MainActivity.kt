package com.example.intents_ejer_3

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var texto: TextView

        val boton = findViewById<Button>(R.id.buttonEnviar)
        val text = findViewById<TextView>(R.id.textView)

        boton.setOnClickListener(){
            val mens = text.toString()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(mens))
            val chooser = Intent.createChooser(intent, "Abrir con: ")

            try{
                startActivity(chooser)
            } catch (e: ActivityNotFoundException){
                text.error = "No hay aplicaciones"
            }

        }
    }
}