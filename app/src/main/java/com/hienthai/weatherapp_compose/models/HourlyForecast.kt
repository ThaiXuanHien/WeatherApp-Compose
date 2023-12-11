package com.hienthai.weatherapp_compose.models

import com.google.gson.annotations.SerializedName

data class HourlyForecast(
    @SerializedName("DateTime") var dateTime: String? = null,
    @SerializedName("EpochDateTime") var epochDateTime: Long? = null,
    @SerializedName("WeatherIcon") var weatherIcon: Int? = null,
    @SerializedName("IconPhrase") var iconPhrase: String? = null,
    @SerializedName("HasPrecipitation") var hasPrecipitation: Boolean? = null,
    @SerializedName("IsDaylight") var isDaylight: Boolean? = null,
    @SerializedName("Temperature") var temperature: TemperatureHourly? = TemperatureHourly()
)

data class TemperatureHourly(
    @SerializedName("Value") var value: Int? = null,
    @SerializedName("Unit") var unit: String? = null,
    @SerializedName("UnitType") var unitType: Int? = null

)