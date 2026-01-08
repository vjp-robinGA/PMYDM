package com.example.robin_proyecto_ut9.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.robin_proyecto_ut9.R
import com.example.robin_proyecto_ut9.modelo.Videojuego
import com.example.robin_proyecto_ut9.servicios.RetrofitClient
import kotlinx.coroutines.launch

class AddFragment : Fragment(R.layout.fragment_add) {

    private lateinit var etTitulo: EditText
    private lateinit var etGenero: EditText
    private lateinit var etAnio: EditText
    private lateinit var etPlataforma: EditText
    private lateinit var btnAdd: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etTitulo = view.findViewById(R.id.etTitulo)
        etGenero = view.findViewById(R.id.etGenero)
        etAnio = view.findViewById(R.id.etAnio)
        etPlataforma = view.findViewById(R.id.etPlataforma)
        btnAdd = view.findViewById(R.id.btnAdd)

        btnAdd.setOnClickListener {
            val titulo = etTitulo.text.toString()
            val genero = etGenero.text.toString()
            val anioStr = etAnio.text.toString()
            val plataforma = etPlataforma.text.toString()

            if (titulo.isNotEmpty() && genero.isNotEmpty() && anioStr.isNotEmpty() && plataforma.isNotEmpty()) {
                val videojuego = Videojuego(
                    titulo = titulo,
                    genero = genero,
                    anio = anioStr.toInt(),
                    plataforma = plataforma
                )
                agregarVideojuego(videojuego)
            } else {
                Toast.makeText(context, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun agregarVideojuego(videojuego: Videojuego) {
        lifecycleScope.launch {
            try {
                val response = RetrofitClient.instance.agregarVideojuego(videojuego)
                if (response.isSuccessful) {
                    Toast.makeText(context, "Videojuego añadido correctamente", Toast.LENGTH_SHORT).show()
                    clearFields()
                } else {
                    Toast.makeText(context, "Error al añadir: ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(context, "Error de conexión: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun clearFields() {
        etTitulo.text.clear()
        etGenero.text.clear()
        etAnio.text.clear()
        etPlataforma.text.clear()
    }
}
