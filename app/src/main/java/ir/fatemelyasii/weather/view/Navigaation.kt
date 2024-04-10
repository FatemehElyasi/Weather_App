package ir.fatemelyasii.weather.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ir.fatemelyasii.weather.view.screens.HomeScreen
import ir.fatemelyasii.weather.view.screens.WeatherScreen

@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        //---------------HomeScreen
        composable(
            route = "home"
        ) {
            HomeScreen(navController = navController)
        }
        //----------WeatherScreen
        composable(
            route = "weather/{location_key}/{name}/{country}",
            arguments = listOf(
                navArgument("location_key") {
                    type = NavType.StringType
                },
                navArgument("name") {
                    type = NavType.StringType
                },
                navArgument("country") {
                    type = NavType.StringType
                })
        ) {
            WeatherScreen(
                navController = navController,
                locationKey = it.arguments?.getString("location_key") ?: "",
                locationName = it.arguments?.getString("name") ?: "",
                country = it.arguments?.getString("country") ?: ""
            )
        }
        //----------
    }
}
