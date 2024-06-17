package com.example.citydbcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.citydbcompose.presentation.citydetails.CityDetailsScreen
import com.example.citydbcompose.presentation.citylist.CityListScreen


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "city_list") {
        composable("city_list") {
            CityListScreen(navController)
        }
        composable("city_details/{cityId}") { backStackEntry ->
            val cityId = backStackEntry.arguments?.getString("cityId")?.toInt()
            if (cityId != null) {
                CityDetailsScreen(navController, cityId)
            }
        }
    }
}