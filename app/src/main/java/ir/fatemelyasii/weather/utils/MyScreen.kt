package ir.fatemelyasii.weather.utils

import kotlinx.serialization.Serializable

@Serializable
sealed class MyScreen {

    @Serializable
    object HomeScreen : MyScreen()

    @Serializable
    data class WeatherScreen(
        val locationKey: String,
        val locationName: String,
        val countryName: String
    ) : MyScreen()
}
