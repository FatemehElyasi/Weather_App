package ir.fatemelyasii.weather.view.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.fatemelyasii.weather.network.responseModels.location.Location
import ir.fatemelyasii.weather.repository.WeatherRepository
import ir.fatemelyasii.weather.utils.BaseModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import org.koin.core.component.KoinComponent

@KoinViewModel
class HomeViewModel(
    private val weatherRepository: WeatherRepository,
) : ViewModel(), KoinComponent {
    private val _locations: MutableStateFlow<BaseModel<List<Location>>?> = MutableStateFlow(null)

    val locations = _locations.asStateFlow()

    fun searchLocation(query: String) {
        viewModelScope.launch {
            _locations.update { BaseModel.Loading }
            weatherRepository.searchLocation(query).also { data ->
                _locations.update { data }
            }
        }
    }
}