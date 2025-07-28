package ir.fatemelyasii.weather.view.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.fatemelyasii.weather.model.DailyForecasts
import ir.fatemelyasii.weather.model.HourlyForecast
import ir.fatemelyasii.weather.repository.WeatherRepository
import ir.fatemelyasii.weather.utils.BaseModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class WeatherViewModel(
    private val weatherRepository: WeatherRepository,
) : ViewModel() {

    private val _hourlyForecast: MutableStateFlow<BaseModel<List<HourlyForecast>>> =
        MutableStateFlow(BaseModel.Loading)
    val hourlyForecast = _hourlyForecast.asStateFlow()

    private val _dailyForecast: MutableStateFlow<BaseModel<DailyForecasts>> =
        MutableStateFlow(BaseModel.Loading)
    val dailyForecast = _dailyForecast.asStateFlow()

    fun getHourlyForecast(locationKey: String) {
        viewModelScope.launch {
            weatherRepository.getHourlyForecasts(locationKey).also { data ->
                _hourlyForecast.update { data }
            }
        }
    }

    fun getDailyForecast(locationKey: String) {
        viewModelScope.launch {
            weatherRepository.getDailyForecasts(locationKey).also { data ->
                _dailyForecast.update { data }
            }
        }
    }
}