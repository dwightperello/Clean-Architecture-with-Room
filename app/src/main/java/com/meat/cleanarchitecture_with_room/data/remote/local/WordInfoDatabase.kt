package com.meat.cleanarchitecture_with_room.data.remote.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.meat.cleanarchitecture_with_room.data.remote.local.entity.WordInfoEntity
import com.meat.cleanarchitecture_with_room.data.util.Converters

@Database(entities = [WordInfoEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class WordInfoDatabase:RoomDatabase() {

    abstract val dao :WordInfoDao
}