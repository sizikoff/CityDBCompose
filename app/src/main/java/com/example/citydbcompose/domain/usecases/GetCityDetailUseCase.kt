package com.example.citydbcompose.domain.usecases

import com.example.citydbcompose.domain.models.City
import com.example.citydbcompose.domain.repositories.CityRepository


class GetCityDetailsUseCase(private val repository: CityRepository) {
    suspend operator fun invoke(id: Int): City {
        return repository.getCityDetails(id)
    }
}