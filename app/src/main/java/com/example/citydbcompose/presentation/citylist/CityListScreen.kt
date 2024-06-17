package com.example.citydbcompose.presentation.citylist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.citydbcompose.domain.models.City

@Composable
fun CityListScreen(navController: NavController, viewModel: CityListViewModel = hiltViewModel()) {
    val cities by viewModel.cities.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(cities) { city ->
            CityItem(city) {
                navController.navigate("city_details/${city.id}")
            }
        }
    }
}

@Composable
fun CityItem(city: City, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 8.dp)
    ) {
        Text(text = city.name)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = city.description)
    }
}