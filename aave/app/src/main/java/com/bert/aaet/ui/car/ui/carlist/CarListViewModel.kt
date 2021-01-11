package com.bert.aaet.ui.car.ui.carlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bert.aaet.data.car.Car

class CarListViewModel : ViewModel() {
    private val _items: LiveData<List<Car>> = MutableLiveData<List<Car>>()

    val cars: LiveData<List<Car>> = _items

}