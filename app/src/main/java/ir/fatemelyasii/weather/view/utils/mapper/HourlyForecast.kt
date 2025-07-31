package ir.fatemelyasii.weather.view.utils.mapper

import ir.fatemelyasii.weather.model.network.responseModels.hourlyForecast.HourlyForecastResponseModel
import ir.fatemelyasii.weather.view.utils.DateFormatter
import ir.fatemelyasii.weather.model.viewEntity.HourlyForecastViewEntity

fun HourlyForecastResponseModel.toViewEntity(): HourlyForecastViewEntity {
    return HourlyForecastViewEntity(
        dateFormatted = this.date.let { DateFormatter.formatToReadableDate(it) },
        temperature = this.temperature.valueResponseModel,
        weatherIcon = this.weatherIcon,
        description = this.iconPhrase,
        isDaylight = this.isDaylight,
        hasPrecipitation = this.hasPrecipitation,
        epochDateTime = this.epochDateTime,
    )
}
