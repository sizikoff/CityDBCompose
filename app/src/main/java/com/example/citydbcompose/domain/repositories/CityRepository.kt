package com.example.citydbcompose.domain.repositories

import com.example.citydbcompose.domain.models.City

interface CityRepository {
    suspend fun getCities(): List<City>
    suspend fun getCityDetails(id: Int): City
}