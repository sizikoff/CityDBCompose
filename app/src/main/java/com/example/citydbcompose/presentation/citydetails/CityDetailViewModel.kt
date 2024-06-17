package com.example.citydbcompose.presentation.citydetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.citydbcompose.domain.models.City
import com.example.citydbcompose.domain.usecases.GetCityDetailsUseCase

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CityDetailsViewModel(private val getCityDetailsUseCase: GetCityDetailsUseCase) : ViewModel() {
    private val _city = MutableStateFlow<City?>(null)
    val city: StateFlow<City?> get() = _city

    fun fetchCityDetails(id: Int) {
        viewModelScope.launch {
            val city = getCityDetailsUseCase(id)
            _city.value = city
        }
    }
}