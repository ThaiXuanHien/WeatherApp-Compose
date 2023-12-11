package com.hienthai.weatherapp_compose.repository

import com.hienthai.weatherapp_compose.models.BaseModel
import com.hienthai.weatherapp_compose.models.DailyForecasts
import com.hienthai.weatherapp_compose.models.HourlyForecast
import com.hienthai.weatherapp_compose.models.Location

interface WeatherRepository {
    suspend fun searchLocation(query: String): BaseModel<List<Location>>
    suspend fun getDailyForecasts(locationKey: String): BaseModel<DailyForecasts>
    suspend fun getHourlyForecasts(locationKey: String): BaseModel<List<HourlyForecast>>
}