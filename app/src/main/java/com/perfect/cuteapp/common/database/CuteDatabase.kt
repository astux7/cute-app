package com.perfect.cuteapp.common.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.perfect.cuteapp.feed.model.Language
import com.perfect.cuteapp.feed.dao.Language as LanguageDao

@Database(
    entities = [Language::class],
    version = 1,
    exportSchema = false
)
abstract class CuteDatabase : RoomDatabase() {

    abstract fun getLanguageDao() : LanguageDao

    companion object {
        @Volatile
        var instance: CuteDatabase? = null
    }
}