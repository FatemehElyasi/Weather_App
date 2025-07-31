package ir.fatemelyasii.weather.view.screens.weatherScreen

import android.R.attr.data
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.fatemelyasii.weather.model.repository.WeatherRepository
import ir.fatemelyasii.weather.model.viewEntity.DailyForecastViewEntity
import ir.fatemelyasii.weather.model.viewEntity.HourlyForecastViewEntity
import ir.fatemelyasii.weather.view.utils.baseModel.BaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class WeatherViewModel(
    private val weatherRepository: WeatherRepository,
) : ViewModel() {

    private val _hourlyForecast: MutableStateFlow<BaseModel<List<HourlyForecastViewEntity>>> =
        MutableStateFlow(BaseModel.Loading)
    val hourlyForecast = _hourlyForecast.asStateFlow()

    private val _dailyForecast: MutableStateFlow<BaseModel<List<DailyForecastViewEntity>>> =
        MutableStateFlow(BaseModel.Loading)
    val dailyForecast = _dailyForecast.asStateFlow()

    fun getHourlyForecast(locationKey: String) {
        Log.d("WeatherViewModel", "📥 Requesting getHourlyForecast for: $locationKey")
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("WeatherViewModel", " Forecast getHourlyForecast result: $data")
            weatherRepository.getHourlyForecasts(locationKey).also { data ->
                _hourlyForecast.update { data }
            }
        }
    }

    fun getDailyForecast(locationKey: String) {
        Log.d("WeatherViewModel", "Calling getDailyForecast for key: $locationKey")
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("WeatherViewModel", "Requesting daily forecast for: $data")
            weatherRepository.getDailyForecasts(locationKey).also { data ->
                _dailyForecast.update { data }
            }
        }
    }
}