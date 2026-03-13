package com.skycast.data.repository

import com.skycast.data.api.WeatherApi
import com.skycast.data.db.LocationDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepository @Inject constructor(
    private val api: WeatherApi,
    private val dao: LocationDao
) {
    // API Key should ideally be injected or from build config, using placeholder for now
    private val apiKey = "60a743f3dfebf2725efd4465e4a63c37"

    fun getSavedLocations() = dao.getAllLocations()

    fun getWeatherFlowForLocation(locationId: Int) = dao.getWeatherCache(locationId)

    suspend fun fetchWeather(lat: Double, lon: Double) {
        try {
            val response = api.getWeather(lat = lat, lon = lon, apiKey = apiKey)
            // Need to save this to DB
            // Simplified logic: find/insert location, then insert weather cache
            // Since this is a skeleton for now, actual implementation needs Gson serialization
        } catch (e: Exception) {
            e.printStackTrace()
            // In a real app, handle error properly, perhaps return a Result wrapper
        }
    }
}
