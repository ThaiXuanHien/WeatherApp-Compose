package com.hienthai.weatherapp_compose.models

sealed class BaseModel<out T> {
    data class Success<T>(val data: T) : BaseModel<T>()
    data class Error(val error: String) : BaseModel<Nothing>()
    object Loading : BaseModel<Nothing>()
}
