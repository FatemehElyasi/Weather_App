package ir.fatemelyasii.weather.utils.mapper

import ir.fatemelyasii.weather.network.responseModels.dailyForcasts.DailyForecast
import ir.fatemelyasii.weather.utils.DateFormatter
import ir.fatemelyasii.weather.viewEntity.DailyForecastViewEntity


fun DailyForecast.toViewEntity(): DailyForecastViewEntity {
    return DailyForecastViewEntity(
        dateFormatted = this.date?.let { DateFormatter.formatToReadableDate(it) } ?: "Unknown date",
        minTemp = this.temperature.min.value,
        maxTemp = this.temperature.max.value,
        dayDescription = this.day.iconPhrase,
        nightDescription = this.night.iconPhrase,
        dayIcon = this.day.icon,
        nightIcon = this.night.icon,
        epochDate = this.epochDate,

        )
}





