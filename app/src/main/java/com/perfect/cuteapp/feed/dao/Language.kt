package com.perfect.cuteapp.feed.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.perfect.cuteapp.common.dao.BaseDao
import com.perfect.cuteapp.feed.model.Language

@Dao
interface Language : BaseDao<Language> {

    @Query("SELECT * FROM Language")
    fun getAll(): LiveData<List<Language>>
}