package com.example.citydbcompose.presentation.citylist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.citydbcompose.domain.models.City
import com.example.citydbcompose.domain.usecases.GetCitiesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class CityListViewModel(private val getCitiesUseCase: GetCitiesUseCase) : ViewModel() {
    private val _cities = MutableStateFlow<List<City>>(emptyList())
    val cities: StateFlow<List<City>> get() = _cities

    init {
        fetchCities()
    }

    private fun fetchCities() {
        viewModelScope.launch {
            val cities = getCitiesUseCase()
            _cities.value = cities
        }
    }
}