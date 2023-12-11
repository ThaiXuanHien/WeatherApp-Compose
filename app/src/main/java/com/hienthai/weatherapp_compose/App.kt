package com.hienthai.weatherapp_compose

import android.app.Application
import com.hienthai.weatherapp_compose.network.Api
import com.hienthai.weatherapp_compose.network.HeaderInterceptor
import com.hienthai.weatherapp_compose.repository.WeatherRepository
import com.hienthai.weatherapp_compose.repository.WeatherRepositoryImpl
import okhttp3.OkHttpClient
import org.koin.core.context.startKoin
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                module {
                    single {
                        val client = OkHttpClient.Builder()
                            .addInterceptor(HeaderInterceptor())
                            .build()
                        Retrofit.Builder()
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(client)
                            .baseUrl("http://dataservice.accuweather.com/")
                            .build()
                    }
                    single {
                        val retrofit: Retrofit = get()
                        retrofit.create(Api::class.java)
                    }
                    single {
                        val api: Api = get()
                        WeatherRepositoryImpl(api)
                    } bind WeatherRepository::class
                }
            )
        }

    }
}