package com.example.robin_proyecto_ut9.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.robin_proyecto_ut9.R
import com.example.robin_proyecto_ut9.servicios.RetrofitClient
import kotlinx.coroutines.launch

class ListFragment : Fragment(R.layout.fragment_list) {

    private lateinit var adapter: VideojuegoAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = VideojuegoAdapter(emptyList())
        recyclerView.adapter = adapter

        fetchVideojuegos()
    }

    private fun fetchVideojuegos() {
        lifecycleScope.launch {
            try {
                val response = RetrofitClient.instance.getVideojuegos()
                if (response.isSuccessful) {
                    val videojuegos = response.body() ?: emptyList()
                    adapter.updateData(videojuegos)
                    // Toast.makeText(context, "Datos cargados correctamente", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Error: ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Log.e("ListFragment", "Error fetching data", e)
                Toast.makeText(context, "Error de conexión: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
