package ir.fatemelyasii.weather.viewEntity

data class HourlyForecastViewEntity(
    val dateFormatted: String?,
    val temperature: Double?,
    val weatherIcon: Int?,
    val description: String?,
    val isDaylight: Boolean?,
    val hasPrecipitation: Boolean?,
    val epochDateTime: Long?,
)
