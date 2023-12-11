package com.hienthai.weatherapp_compose.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hienthai.weatherapp_compose.models.BaseModel
import com.hienthai.weatherapp_compose.models.DailyForecasts
import com.hienthai.weatherapp_compose.models.HourlyForecast
import com.hienthai.weatherapp_compose.repository.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class WeatherViewModel : ViewModel(), KoinComponent {
    private val repository: WeatherRepository by inject()
    private val _hourlyForecast: MutableStateFlow<BaseModel<List<HourlyForecast>>> =
        MutableStateFlow(BaseModel.Loading)
    val hourlyForecast = _hourlyForecast.asStateFlow()

    private val _dailyForecast: MutableStateFlow<BaseModel<DailyForecasts>> =
        MutableStateFlow(BaseModel.Loading)
    val dailyForecast = _dailyForecast.asStateFlow()

    fun getHourlyForecast(locationKey: String) {
        viewModelScope.launch {
            repository.getHourlyForecasts(locationKey).also { data ->
                _hourlyForecast.update { data }
            }
        }
    }

    fun getDailyForecast(locationKey: String) {
        viewModelScope.launch {
            repository.getDailyForecasts(locationKey).also { data ->
                _dailyForecast.update { data }
            }
        }
    }
}