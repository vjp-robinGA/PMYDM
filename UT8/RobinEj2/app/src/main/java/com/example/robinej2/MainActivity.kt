package com.example.robinej2

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var spinnerCiclos: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerCiclos = findViewById<Spinner>(R.id.spinnerCiclos)
        var textViewResult = findViewById<TextView>(R.id.textView)

        val adapador = ArrayAdapter.createFromResource(this, R.array.ciclos, android.R.layout.simple_spinner_item)
        adapador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerCiclos.adapter = adapador
        spinnerCiclos.onItemSelectedListener = this

    }

    override fun onItemSelected(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ) {
        if(position == 1){
            Toast.makeText(this, "Ha seleccionado SMR", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, "Ha seleccionado cualquier opcion menos SMR", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}