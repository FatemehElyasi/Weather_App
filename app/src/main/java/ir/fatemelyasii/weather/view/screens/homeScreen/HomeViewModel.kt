package ir.fatemelyasii.weather.view.screens.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.fatemelyasii.weather.model.repository.WeatherRepository
import ir.fatemelyasii.weather.view.utils.baseModel.BaseModel
import ir.fatemelyasii.weather.model.viewEntity.LocationViewEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import org.koin.core.component.KoinComponent

@KoinViewModel
class HomeViewModel(
    private val weatherRepository: WeatherRepository,
) : ViewModel() {

    private val _locations: MutableStateFlow<BaseModel<List<LocationViewEntity>>?> =
        MutableStateFlow(null)
    val locations = _locations.asStateFlow()

    private val _city = MutableStateFlow("")
    val city: StateFlow<String> = _city.asStateFlow()

    init {
        observeCityChanges()
    }

    fun setCity(newCity: String) {
        _city.value = newCity
    }

    fun searchLocation(query: String) {

        viewModelScope.launch(Dispatchers.IO) {
            _locations.update { BaseModel.Loading }
            weatherRepository.searchLocation(query).also { data ->
                _locations.update { data }
            }
        }
    }

    private fun observeCityChanges() {
        viewModelScope.launch(Dispatchers.IO) {
            city
                .debounce(2000)
                .filter { it.length > 2 }
                .distinctUntilChanged()
                .collectLatest { query ->
                    searchLocation(query)
                }
        }
    }
}