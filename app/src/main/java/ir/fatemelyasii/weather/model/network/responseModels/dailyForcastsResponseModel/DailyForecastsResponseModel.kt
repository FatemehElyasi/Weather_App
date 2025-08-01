package ir.fatemelyasii.weather.model.network.responseModels.dailyForcastsResponseModel

import com.google.gson.annotations.SerializedName

data class DailyForecastsResponseModel(
    @SerializedName("DailyForecasts")
    val dailyForecastResponseModels: List<DailyForecastResponseModel>
)