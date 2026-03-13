package com.skycast.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationDao {
    @Query("SELECT * FROM locations ORDER BY orderIndex ASC")
    fun getAllLocations(): Flow<List<LocationEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocation(location: LocationEntity)

    @Delete
    suspend fun deleteLocation(location: LocationEntity)
    
    @Query("SELECT * FROM locations WHERE isCurrentGps = 1 LIMIT 1")
    suspend fun getCurrentGpsLocation(): LocationEntity?

    @Query("SELECT * FROM weather_cache WHERE locationId = :locationId")
    fun getWeatherCache(locationId: Int): Flow<WeatherCacheEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeatherCache(cache: WeatherCacheEntity)
}
