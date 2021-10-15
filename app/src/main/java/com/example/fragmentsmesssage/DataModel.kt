package com.example.fragmentsmesssage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel : ViewModel() {

    val messageAct: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val messageFrag1: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val messageFrag2: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}