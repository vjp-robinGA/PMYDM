package com.example.robin_proyecto_ut9.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.robin_proyecto_ut9.R
import com.example.robin_proyecto_ut9.servicios.RetrofitClient
import kotlinx.coroutines.launch

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private lateinit var etIdSearch: EditText
    private lateinit var btnSearch: Button
    private lateinit var tvResult: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etIdSearch = view.findViewById(R.id.etIdSearch)
        btnSearch = view.findViewById(R.id.btnSearch)
        tvResult = view.findViewById(R.id.tvResult)

        btnSearch.setOnClickListener {
            val idStr = etIdSearch.text.toString()
            if (idStr.isNotEmpty()) {
                searchVideojuego(idStr.toInt())
            } else {
                Toast.makeText(context, "Por favor, introduce un ID", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun searchVideojuego(id: Int) {
        lifecycleScope.launch {
            try {
                val response = RetrofitClient.instance.getVideojuego(id)
                if (response.isSuccessful && response.body() != null) {
                    val juego = response.body()!!
                    val result = """
                        ID: ${juego.id}
                        Título: ${juego.titulo}
                        Género: ${juego.genero}
                        Año: ${juego.anio}
                        Plataforma: ${juego.plataforma}
                    """.trimIndent()
                    tvResult.text = result
                    Toast.makeText(context, "Juego encontrado", Toast.LENGTH_SHORT).show()
                } else {
                    tvResult.text = ""
                    if (response.code() == 404) {
                        Toast.makeText(context, "Juego no encontrado (404)", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Error: ${response.code()}", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                tvResult.text = ""
                Toast.makeText(context, "Error de conexión: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
