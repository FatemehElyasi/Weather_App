package ir.fatemelyasii.weather.utils.mapper

import ir.fatemelyasii.weather.network.responseModels.hourlyForecast.HourlyForecast
import ir.fatemelyasii.weather.utils.DateFormatter
import ir.fatemelyasii.weather.viewEntity.HourlyForecastViewEntity

fun HourlyForecast.toViewEntity(): HourlyForecastViewEntity {
    return HourlyForecastViewEntity(
        dateFormatted = this.date.let { DateFormatter.formatToReadableDate(it) },
        temperature = this.temperature.value,
        weatherIcon = this.weatherIcon,
        description = this.iconPhrase,
        isDaylight = this.isDaylight,
        hasPrecipitation = this.hasPrecipitation,
        epochDateTime = this.epochDateTime,
    )
}
