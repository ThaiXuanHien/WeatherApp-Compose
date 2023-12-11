package com.hienthai.weatherapp_compose.models

import com.google.gson.annotations.SerializedName

data class DailyForecast(
    @SerializedName("Date") var date: String? = null,
    @SerializedName("EpochDate") var epochDate: Long? = null,
    @SerializedName("Temperature") var temperature: Temperature? = Temperature(),
    @SerializedName("Day") var day: Day? = Day(),
    @SerializedName("Night") var night: Night? = Night()
)

data class Minimum(

    @SerializedName("Value") var value: Int? = null,
    @SerializedName("Unit") var unit: String? = null,
    @SerializedName("UnitType") var unitType: Int? = null

)

data class Maximum(

    @SerializedName("Value") var value: Int? = null,
    @SerializedName("Unit") var unit: String? = null,
    @SerializedName("UnitType") var unitType: Int? = null

)

data class Temperature(

    @SerializedName("Minimum") var minimum: Minimum? = Minimum(),
    @SerializedName("Maximum") var maximum: Maximum? = Maximum()

)

data class Day(

    @SerializedName("Icon") var icon: Int? = null,
    @SerializedName("IconPhrase") var iconPhrase: String? = null,
    @SerializedName("HasPrecipitation") var hasPrecipitation: Boolean? = null,
    @SerializedName("PrecipitationType") var precipitationType: String? = null,
    @SerializedName("PrecipitationIntensity") var precipitationIntensity: String? = null

)

data class Night(

    @SerializedName("Icon") var icon: Int? = null,
    @SerializedName("IconPhrase") var iconPhrase: String? = null,
    @SerializedName("HasPrecipitation") var hasPrecipitation: Boolean? = null

)