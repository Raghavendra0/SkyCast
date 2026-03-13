package com.skycast.data.api

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val current: CurrentWeather,
    val hourly: List<HourlyWeather>,
    val daily: List<DailyWeather>,
    val alerts: List<WeatherAlert>?
)

data class CurrentWeather(
    val dt: Long,
    val temp: Double,
    @SerializedName("feels_like") val feelsLike: Double,
    val humidity: Int,
    val uvi: Double,
    @SerializedName("wind_speed") val windSpeed: Double,
    val visibility: Int,
    val weather: List<WeatherDescription>
)

data class HourlyWeather(
    val dt: Long,
    val temp: Double,
    val weather: List<WeatherDescription>
)

data class DailyWeather(
    val dt: Long,
    val temp: DailyTemp,
    val weather: List<WeatherDescription>,
    val pop: Double
)

data class DailyTemp(
    val min: Double,
    val max: Double
)

data class WeatherDescription(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)

data class WeatherAlert(
    @SerializedName("sender_name") val senderName: String,
    val event: String,
    val start: Long,
    val end: Long,
    val description: String
)
