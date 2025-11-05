package com.example.robin_ej13.ui.constraintLayout

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ConstLayoutViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is constraintLayout Fragment"
    }
    val text: LiveData<String> = _text
}