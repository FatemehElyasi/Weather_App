package ir.fatemelyasii.weather.view.utils.mapper

import ir.fatemelyasii.weather.model.network.responseModels.hourlyForecast.HourlyForecast
import ir.fatemelyasii.weather.view.utils.DateFormatter
import ir.fatemelyasii.weather.model.viewEntity.HourlyForecastViewEntity

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
