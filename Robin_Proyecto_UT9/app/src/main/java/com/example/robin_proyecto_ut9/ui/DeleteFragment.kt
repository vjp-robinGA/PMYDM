package com.example.robin_proyecto_ut9.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.robin_proyecto_ut9.R
import com.example.robin_proyecto_ut9.servicios.RetrofitClient
import kotlinx.coroutines.launch

class DeleteFragment : Fragment(R.layout.fragment_delete) {

    private lateinit var etIdDelete: EditText
    private lateinit var btnDelete: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etIdDelete = view.findViewById(R.id.etIdDelete)
        btnDelete = view.findViewById(R.id.btnDelete)

        btnDelete.setOnClickListener {
            val idStr = etIdDelete.text.toString()
            if (idStr.isNotEmpty()) {
                deleteVideojuego(idStr.toInt())
            } else {
                Toast.makeText(context, "Por favor, introduce un ID", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun deleteVideojuego(id: Int) {
        lifecycleScope.launch {
            try {
                val response = RetrofitClient.instance.eliminarVideojuego(id)
                if (response.isSuccessful) {
                    Toast.makeText(context, "Videojuego eliminado correctamente", Toast.LENGTH_SHORT).show()
                    etIdDelete.text.clear()
                } else {
                    if (response.code() == 404) {
                        Toast.makeText(context, "Juego no encontrado (404)", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Error al eliminar: ${response.code()}", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                Toast.makeText(context, "Error de conexión: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
