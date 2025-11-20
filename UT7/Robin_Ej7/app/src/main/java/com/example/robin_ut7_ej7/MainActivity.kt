package com.example.robin_ut7_ej7

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val inputNombres = findViewById<TextInputEditText>(R.id.introducirNombre)

        val botonBorrar = findViewById<Button>(R.id.btnBorrar)
        val botonInsertar = findViewById<Button>(R.id.btnInsertar)
        val botonSortear = findViewById<Button>(R.id.btnSortear)

        val listaNombres: ArrayList<String> = ArrayList<String>()

        botonInsertar.setOnClickListener {

            val nombre = inputNombres.text.toString()

            if( nombre.isEmpty() ){

                Toast.makeText(this, "Introduce un nombre", Toast.LENGTH_SHORT).show()
                
            }
            else{

                listaNombres.add(nombre)

                inputNombres.setText("")

                Toast.makeText(this, "Nombre añadido", Toast.LENGTH_SHORT).show()

            }

        }

        botonBorrar.setOnClickListener {

            inputNombres.setText("")

            Toast.makeText(this, "Nombre borrado", Toast.LENGTH_SHORT).show()

        }

        botonSortear.setOnClickListener {

            val indiceAleatorio = Random.nextInt(0, listaNombres.size)

            val ganador = listaNombres[indiceAleatorio]

            val intentGanador = Intent(this, WinnerActivity::class.java)

            intentGanador.putExtra("ganador", ganador)

            startActivity(intentGanador)

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

private fun ArrayList<String>.add(e: TextInputEditText) {}
