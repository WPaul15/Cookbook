package com.wpaul15.cookbook.androidApp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class PageViewModel : ViewModel() {

    private val index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(index) {
        "Hello world from section: $it"
    }

    fun setIndex(index: Int) {
        this.index.value = index
    }
}