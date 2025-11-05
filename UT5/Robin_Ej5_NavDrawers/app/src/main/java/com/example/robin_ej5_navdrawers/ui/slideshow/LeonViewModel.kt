package com.example.robin_ej5_navdrawers.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LeonViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is leon Fragment"
    }
    val text: LiveData<String> = _text
}