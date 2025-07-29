package ir.fatemelyasii.weather.view.utils.mapper

import ir.fatemelyasii.weather.model.network.responseModels.dailyForcasts.DailyForecast
import ir.fatemelyasii.weather.view.utils.DateFormatter
import ir.fatemelyasii.weather.model.viewEntity.DailyForecastViewEntity


fun DailyForecast.toViewEntity(): DailyForecastViewEntity {
    return DailyForecastViewEntity(
        dateFormatted = this.date.let { DateFormatter.formatToReadableDate(it) },
        minTemp = this.temperature.min.value,
        maxTemp = this.temperature.max.value,
        dayDescription = this.day.iconPhrase,
        nightDescription = this.night.iconPhrase,
        dayIcon = this.day.icon,
        nightIcon = this.night.icon,
        epochDate = this.epochDate,
    )
}





