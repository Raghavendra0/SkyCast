package com.skycast.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "locations")
data class LocationEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val cityName: String,
    val latitude: Double,
    val longitude: Double,
    val isCurrentGps: Boolean = false,
    val orderIndex: Int = 0
)

@Entity(tableName = "weather_cache")
data class WeatherCacheEntity(
    @PrimaryKey
    val locationId: Int, // Foreign key conceptually
    val currentTemp: Double = 0.0,
    val conditionCode: Int = 800,
    val humidity: Int = 0,
    val windSpeed: Double = 0.0,
    val forecastJson: String,
    val lastUpdated: Long = System.currentTimeMillis()
)
