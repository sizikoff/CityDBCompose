package com.example.citydbcompose.presentation.citydetails

import androidx.compose.foundation.layout.*

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun CityDetailsScreen(
    navController: NavController,
    cityId: Int,
    viewModel: CityDetailsViewModel = hiltViewModel()
) {
    val city by viewModel.city.collectAsState()

    viewModel.fetchCityDetails(cityId)

    city?.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = it.name)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = it.description)
        }
    }
}