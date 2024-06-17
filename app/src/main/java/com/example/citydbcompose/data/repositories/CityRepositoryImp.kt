package com.example.citydbcompose.data.repositories

import com.example.citydbcompose.data.models.CityDto
import com.example.citydbcompose.data.network.ApiService
import com.example.citydbcompose.domain.models.City
import com.example.citydbcompose.domain.repositories.CityRepository

class CityRepositoryImpl(private val apiService: ApiService) : CityRepository {

    override suspend fun getCities(): List<City> {
        return apiService.getCities().map { it.toDomainModel() }
    }

    override suspend fun getCityDetails(id: Int): City {
        return apiService.getCityDetails(id).toDomainModel()
    }

    private fun CityDto.toDomainModel(): City {
        return City(
            id = id,
            name = name,
            description = description
        )
    }
    }