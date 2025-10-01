package com.example.primeraprueba

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d( "TAG", "Hola Mundo" )

        val nombre: String = "Pepe"

        Log.d( "TAG", "Nombre: $nombre")

    }
}