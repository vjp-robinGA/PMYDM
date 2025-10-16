package com.example.robinejciclovidat4

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val msg = resources.getString(R.string.texto_inicial)
    }

    override fun onStart() {
        super.onStart()

        val msg = resources.getString(R.string.texto_inicial)

        Log.d(TAG, msg)

    }

    override fun onRestart() {
        super.onRestart()

        val msg = resources.getString(R.string.texto_inicial)

        Log.d("btag", msg)

    }

    override fun onResume() {
        super.onResume()

        val msg = resources.getString(R.string.texto_inicial)

        Log.d(TAG, msg)

    }

    override fun onPause() {
        super.onPause()

        val msg = resources.getString(R.string.texto_inicial)

        Log.d(TAG, msg)

    }

    override fun onStop() {
        super.onStop()

        val msg = resources.getString(R.string.texto_inicial)

        Log.d(TAG, msg)

    }

    override fun onDestroy() {
        super.onDestroy()

        val msg = resources.getString(R.string.texto_ondestroy)

        Log.d(TAG, msg)

    }

}