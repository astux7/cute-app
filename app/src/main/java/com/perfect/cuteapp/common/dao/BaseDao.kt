package com.perfect.cuteapp.common.dao

import androidx.room.*

@Dao
interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: T): Long

    @Update
    fun update(old: T, new: T)

    @Delete
    fun delete(item: T): Int
}