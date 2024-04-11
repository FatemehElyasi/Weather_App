package ir.fatemelyasii.weather.view.screens

import ir.fatemelyasii.weather.model.Location
import ir.fatemelyasii.weather.repository.WeatherRepo
import ir.fatemelyasii.weather.utils.BaseModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

class HomeViewModel:ViewModel(),KoinComponent {
     val repo: WeatherRepo by inject()

    private val _locations: MutableStateFlow<BaseModel<List<Location>>?> = MutableStateFlow(null)
    //casting data to flow for handling and save data
    val locations = _locations.asStateFlow()


    fun searchLocation(query: String) {
        viewModelScope.launch {
            _locations.update { BaseModel.Loading }
            repo.searchLocation(query).also { data ->
                _locations.update { data }
            }
        }
    }
}