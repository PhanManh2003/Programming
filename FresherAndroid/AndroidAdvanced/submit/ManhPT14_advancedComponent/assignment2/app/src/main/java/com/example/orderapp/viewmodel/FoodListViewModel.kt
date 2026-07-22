package com.example.orderapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.orderapp.data.FoodRepository
import com.example.orderapp.model.FoodItem

class FoodListViewModel : ViewModel() {

    private val _foods = MutableLiveData<List<FoodItem>>()
    val foods: LiveData<List<FoodItem>> get() = _foods

    init {
        _foods.value = FoodRepository.getSampleFoods()
    }

    fun addFood(item: FoodItem) {
        val current = _foods.value.orEmpty().toMutableList()
        current.add(item)
        _foods.value = current
    }
}