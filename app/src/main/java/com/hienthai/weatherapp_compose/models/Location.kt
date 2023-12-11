package com.hienthai.weatherapp_compose.models

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("Version") var version: Int? = null,
    @SerializedName("Key") var key: String? = null,
    @SerializedName("Type") var type: String? = null,
    @SerializedName("Rank") var rank: Int? = null,
    @SerializedName("LocalizedName") var localizedName: String? = null,
    @SerializedName("EnglishName") var englishName: String? = null,
    @SerializedName("PrimaryPostalCode") var primaryPostalCode: String? = null,
    @SerializedName("Region") var region: Region? = Region(),
    @SerializedName("Country") var country: Country? = Country(),
    @SerializedName("TimeZone") var timeZone: TimeZone? = TimeZone(),
    @SerializedName("GeoPosition") var geoPosition: GeoPosition? = GeoPosition(),
    @SerializedName("IsAlias") var isAlias: Boolean? = null
)

data class Region(
    @SerializedName("ID") var id: String? = null,
    @SerializedName("LocalizedName") var localizedName: String? = null,
    @SerializedName("EnglishName") var englishName: String? = null
)

data class Country(
    @SerializedName("ID") var id: String? = null,
    @SerializedName("LocalizedName") var localizedName: String? = null,
    @SerializedName("EnglishName") var englishName: String? = null
)

data class TimeZone(

    @SerializedName("Code") var code: String? = null,
    @SerializedName("Name") var name: String? = null,
    @SerializedName("GmtOffset") var gmtOffset: Int? = null,
    @SerializedName("IsDaylightSaving") var isDaylightSaving: Boolean? = null,
    @SerializedName("NextOffsetChange") var nextOffsetChange: String? = null

)

data class GeoPosition(

    @SerializedName("Latitude") var latitude: Double? = null,
    @SerializedName("Longitude") var longitude: Double? = null,
    @SerializedName("Elevation") var elevation: Elevation? = Elevation()

)

data class Elevation(

    @SerializedName("Metric") var metric: Metric? = Metric(),
    @SerializedName("Imperial") var imperial: Imperial? = Imperial()

)

data class Metric(

    @SerializedName("Value") var value: Int? = null,
    @SerializedName("Unit") var unit: String? = null,
    @SerializedName("UnitType") var unitType: Int? = null

)

data class Imperial(

    @SerializedName("Value") var value: Int? = null,
    @SerializedName("Unit") var unit: String? = null,
    @SerializedName("UnitType") var unitType: Int? = null

)