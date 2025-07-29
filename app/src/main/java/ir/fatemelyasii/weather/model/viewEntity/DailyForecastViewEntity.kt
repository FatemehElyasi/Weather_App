package ir.fatemelyasii.weather.model.viewEntity

data class DailyForecastViewEntity(
    val dateFormatted: String,       // Date formatted for display, e.g. "July 29, 2025"
    val minTemp: Double,             // Minimum temperature
    val maxTemp: Double,             // Maximum temperature
    val dayDescription: String,      // Daytime weather description, e.g. "Sunny"
    val nightDescription: String,    // Nighttime weather description, e.g. "Cloudy"
    val dayIcon: Int,                // Daytime weather icon code, e.g. 1 for sunny
    val nightIcon: Int,
    val epochDate: Long,
)

