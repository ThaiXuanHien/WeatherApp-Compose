package com.hienthai.weatherapp_compose.models

import com.google.gson.annotations.SerializedName

data class DailyForecasts(
    @SerializedName("DailyForecasts")
    val dailyForecasts: List<DailyForecast>
)
