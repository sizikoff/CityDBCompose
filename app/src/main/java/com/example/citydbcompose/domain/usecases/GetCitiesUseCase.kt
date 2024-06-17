package com.example.citydbcompose.domain.usecases


import com.example.citydbcompose.domain.models.City
import com.example.citydbcompose.domain.repositories.CityRepository


class GetCitiesUseCase(private val repository: CityRepository) {
    suspend operator fun invoke(): List<City> {
        return repository.getCities()
    }
}