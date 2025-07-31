package ir.fatemelyasii.weather.model.network.responseModels.dailyForcasts

import com.google.gson.annotations.SerializedName

data class DailyForecastsResponseModel(
    @SerializedName("DailyForecastsResponseModel")
    val dailyForecasts: List<DailyForecastResponseModel>
)