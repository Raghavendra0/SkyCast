package com.skycast.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LocationEntity::class, WeatherCacheEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun locationDao(): LocationDao
}
