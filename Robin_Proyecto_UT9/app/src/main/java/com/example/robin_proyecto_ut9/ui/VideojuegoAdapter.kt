package com.example.robin_proyecto_ut9.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.robin_proyecto_ut9.R
import com.example.robin_proyecto_ut9.modelo.Videojuego

class VideojuegoAdapter(private var videojuegos: List<Videojuego>) :
    RecyclerView.Adapter<VideojuegoAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitulo: TextView = view.findViewById(R.id.tvTitulo)
        val tvPlataforma: TextView = view.findViewById(R.id.tvPlataforma)
        val tvGenero: TextView = view.findViewById(R.id.tvGenero)
        val tvAnio: TextView = view.findViewById(R.id.tvAnio)
        val tvId: TextView = view.findViewById(R.id.tvId)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.videojuego_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val juego = videojuegos[position]
        holder.tvTitulo.text = juego.titulo
        holder.tvPlataforma.text = juego.plataforma
        holder.tvGenero.text = "Género: ${juego.genero}"
        holder.tvAnio.text = "Año: ${juego.anio}"
        holder.tvId.text = "ID: ${juego.id}"
    }

    override fun getItemCount() = videojuegos.size

    fun updateData(newVideojuegos: List<Videojuego>) {
        videojuegos = newVideojuegos
        notifyDataSetChanged()
    }
}
