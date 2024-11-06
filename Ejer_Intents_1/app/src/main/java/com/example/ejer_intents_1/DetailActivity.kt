package com.example.ejer_intents_1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


class DetailActivity : AppCompatActivity()  {

    var textViewDatos = findViewById<TextView>(R.id.textViewDetalles)

    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) { result ->
        // Este bloque de código se ejecutará cuando ProvinceActivity envíe un resultado de vuelta.
        // Si el resultado es correcto
        if (result.resultCode == Activity.RESULT_OK) {
            // Obtenemos el dato "province" del Intent que ha vuelto.
            val selectedProvince = result.data?.getStringExtra("province")
            // Establecemos el texto del TextView con la provincia seleccionada.
            textViewDatos.text = selectedProvince
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        startForResult.launch(intent)
    }
}