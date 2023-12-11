package com.hienthai.weatherapp_compose.repository

import com.hienthai.weatherapp_compose.models.BaseModel
import com.hienthai.weatherapp_compose.models.DailyForecasts
import com.hienthai.weatherapp_compose.models.HourlyForecast
import com.hienthai.weatherapp_compose.models.Location
import com.hienthai.weatherapp_compose.network.Api
import retrofit2.Response

class WeatherRepositoryImpl(private val api: Api) : WeatherRepository {
    override suspend fun searchLocation(query: String): BaseModel<List<Location>> {
        return request {
            api.searchLocation(query = query)
        }
    }

    override suspend fun getDailyForecasts(locationKey: String): BaseModel<DailyForecasts> {
        return request {
            api.getDailyForecasts(locationKey = locationKey)
        }
    }

    override suspend fun getHourlyForecasts(locationKey: String): BaseModel<List<HourlyForecast>> {
        return request {
            api.getHourlyForecasts(locationKey = locationKey)
        }
    }

}

suspend fun <T> request(request: suspend () -> Response<T>): BaseModel<T> {
    try {
        request().also {
            return if (it.isSuccessful) {
                BaseModel.Success(it.body() ?: throw NullPointerException("Response body is null"))
            } else {
                BaseModel.Error(it.errorBody()?.string().toString())
            }
        }
    } catch (e: Exception) {
        return BaseModel.Error(e.message.toString())
    }
}