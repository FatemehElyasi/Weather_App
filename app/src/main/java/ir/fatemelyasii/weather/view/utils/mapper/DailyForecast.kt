package ir.fatemelyasii.weather.view.utils.mapper

import ir.fatemelyasii.weather.model.network.responseModels.dailyForcasts.DailyForecastResponseModel
import ir.fatemelyasii.weather.view.utils.DateFormatter
import ir.fatemelyasii.weather.model.viewEntity.DailyForecastViewEntity


fun DailyForecastResponseModel.toViewEntity(): DailyForecastViewEntity {
    return DailyForecastViewEntity(
        dateFormatted = this.date.let { DateFormatter.formatToReadableDate(it) },
        minTemp = this.temperature.min.valueResponseModel,
        maxTemp = this.temperature.max.valueResponseModel,
        dayDescription = this.day.iconPhrase,
        nightDescription = this.night.iconPhrase,
        dayIcon = this.day.icon,
        nightIcon = this.night.icon,
        epochDate = this.epochDate,
    )
}





