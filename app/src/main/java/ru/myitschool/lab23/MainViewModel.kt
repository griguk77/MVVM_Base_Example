package ru.myitschool.lab23

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var value = MutableLiveData<Double>()
    fun setValue(_value: Double) {
        this.value.value = _value
    }
}