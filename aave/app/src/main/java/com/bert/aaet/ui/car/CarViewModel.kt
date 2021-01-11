package com.bert.aaet.ui.car

import androidx.lifecycle.*
import com.bert.aaet.data.car.Car

class CarViewModel : ViewModel() {
    private val _items: LiveData<List<Car>> = MutableLiveData<List<Car>>()
    val cars: LiveData<List<Car>> = _items
}