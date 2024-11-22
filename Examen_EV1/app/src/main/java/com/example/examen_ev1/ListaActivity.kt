package com.example.examen_ev1

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ListaActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    // Defino el array de las categorias y sus imagenes
    private lateinit var categorias: Array<String>
    private lateinit var categoriasImg: IntArray
    private var categoriaSelec = ""

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        categorias = arrayOf(
            getString(R.string.politica),
            getString(R.string.economia),
            getString(R.string.cultura),
            getString(R.string.deportes))

        categoriasImg = intArrayOf(
            R.mipmap.politicsjpg,
            R.mipmap.economyjpg,
            R.mipmap.cultutejpg,
            R.mipmap.sportsjpg
        )

        val NoticiasPol = arrayOf(
            getString(R.string.politica_internacional),
            getString(R.string.politica_nacional)
        )
        val NoticiasEco = arrayOf(
            "SP500",
            "IBEX35"
        )
        val NoticiasCult = arrayOf(
            getString(R.string.cartelera_teatro_calderon)
        )
        val NoticiasDep = arrayOf(
            getString(R.string.futbol),
            getString(R.string.baloncesto)
        )

        //Enlazamos con los elementos de la interfaz
        val listViewNoticias = findViewById<ListView>(R.id.listViewNoticias)

        // Spinner sobre la seleccion de la categoria, ademas de pasarle un adaptador personalizado
        val selectorCategorias = findViewById<Spinner>(R.id.spinnerCategorias)
        val adaptadorPersonalizado = AdaptadorPersonalizado(this, R.layout.spinner_layout, categorias)
        selectorCategorias.adapter = adaptadorPersonalizado
    }

    /**
     * Creo una subclase de array adapter para personalizar el adaptador
     */
    private inner class AdaptadorPersonalizado(
        context: Context,
        resource: Int,
        objects: Array<String>
    ) : ArrayAdapter<String>(context, resource, objects) {
        //Constructor de mi adaptador paso el contexto (this)
        // el layout, y los elementos

        /**
         * Reescribo el método getDropDownView para que me devuelva una fila personalizada en la
         * lista desplegable en vez del elemento que se encuentra en esa posición
         * @param posicion
         * @param ViewConvertida
         * @param padre
         * @return
         */
        override fun getDropDownView(
            position: Int,
            convertView: View?,
            parent: ViewGroup
        ): View {
            // Llama a la función para crear la fila personalizada y la devuelve
            return crearFilaPersonalizada(position, convertView, parent)
        }

        override fun getView(
            position: Int,
            convertView: View?,
            parent: ViewGroup
        ): View {
            // Este método se llama para mostrar una vista personalizada en el elemento seleccionado

            // Llama a la función para crear la fila personalizada y la devuelve
            return crearFilaPersonalizada(position, convertView, parent)
        }

        /**
         * Método que me crea mis filas personalizadas pasando como parámetro la posición
         * la vista y la vista padre
         * @param position
         * @param convertView
         * @param parent
         * @return
         */
        private fun crearFilaPersonalizada(
            position: Int,
            convertView: View?,
            parent: ViewGroup
        ): View {

            // Crea un objeto LayoutInflater para inflar la vista personalizada desde un diseño XML
            val layoutInflater = LayoutInflater.from(context)

            //Declaro una vista de mi fila, y la preparo para inflarla con datos
            // Los parametros son: XML descriptivo
            // Vista padre
            // Booleano que indica si se debe ceñir a las características del padre
            val rowView = convertView ?: layoutInflater.inflate(R.layout.spinner_layout, parent, false)

            //Fijamos el nombre de la categoria
            rowView.findViewById<TextView>(R.id.textViewCategoria).text = categorias[position]
            categoriaSelec = categorias[position].toString()

            //Fijamos la imagen de la categoria
            rowView.findViewById<ImageView>(R.id.imageViewImagenCategoria).setImageResource(categoriasImg[position])

            // Devuelve la vista de fila personalizada
            return rowView
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val c = view?.findViewById<TextView>(R.id.textViewCategoria)
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}