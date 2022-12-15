package com.elhady.inventory.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elhady.inventory.model.Shoe

class SharedViewModel: ViewModel() {

    var shoe: Shoe? = null
    private val shoes = mutableListOf<Shoe>()

    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    init {
        initShoe()
    }

    fun addShoe() {
        shoe?.let { shoe ->
            shoes.add(shoe)
            _shoeList.value = shoes
        }
    }

    fun initShoe() {
        shoe = Shoe("Shoe name", "Company name", "44", "jorden four")
    }

    override fun onCleared() {
        super.onCleared()
        shoes.clear()
    }
}