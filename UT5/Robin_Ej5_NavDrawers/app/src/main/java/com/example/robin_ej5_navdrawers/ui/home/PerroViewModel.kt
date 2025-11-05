package com.example.robin_ej5_navdrawers.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PerroViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is perro Fragment"
    }
    val text: LiveData<String> = _text
}