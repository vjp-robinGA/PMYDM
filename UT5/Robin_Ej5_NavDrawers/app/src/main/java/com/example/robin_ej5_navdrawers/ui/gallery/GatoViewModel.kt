package com.example.robin_ej5_navdrawers.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GatoViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is gato Fragment"
    }
    val text: LiveData<String> = _text
}