package com.example.citydbcompose.data.models

import kotlinx.serialization.Serializable

@Serializable
data class CityDto(
    val id: Int,
    val name: String,
    val description: String
)