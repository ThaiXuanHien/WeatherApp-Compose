package com.hienthai.weatherapp_compose.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hienthai.weatherapp_compose.models.BaseModel
import com.hienthai.weatherapp_compose.models.Location
import com.hienthai.weatherapp_compose.repository.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel : ViewModel(), KoinComponent {
    private val repository: WeatherRepository by inject()

    private val _location: MutableStateFlow<BaseModel<List<Location>>?> = MutableStateFlow(null)
    val locations = _location.asStateFlow()

    fun searchLocation(query: String) {
        viewModelScope.launch {
            _location.update { BaseModel.Loading }
            repository.searchLocation(query).also { data ->
                _location.update { data }
            }
        }
    }
}