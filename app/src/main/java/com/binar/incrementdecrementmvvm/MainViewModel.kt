package com.binar.incrementdecrementmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val _counter : MutableLiveData<Int> = MutableLiveData<Int>().apply {
        postValue(0)
    }
    private val _price : MutableLiveData<Int> = MutableLiveData<Int>().apply {
        postValue(0)
    }

    val counter: LiveData<Int>
        get() = _counter

    val price: LiveData<Int>
        get() = _price


    fun increment(){
        val currentValue = _counter.value ?: 0
        val value = currentValue + 1
        _counter.postValue(value)
        setPrice(value)
    }

    fun decrement() {
        val currentValue = _counter.value ?: 0
        if(currentValue <= 0) return
        val value = currentValue - 1
        _counter.postValue(value)
        setPrice(value)
    }

    fun setPrice(count: Int) {
        val price = 18000
        val TotalPrice = count * price
        _price.postValue(TotalPrice)
    }

}