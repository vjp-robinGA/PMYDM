package com.example.robin_ej13.ui.linearLayout

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LinLayoutViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is linearLayout Fragment"
    }
    val text: LiveData<String> = _text
}