package com.perfect.cuteapp.feed.repository

import android.os.Handler
import androidx.lifecycle.LiveData
import com.perfect.cuteapp.common.database.CuteDatabase
import com.perfect.cuteapp.feed.model.Language
import com.perfect.cuteapp.feed.service.IFeedService

class FeedRepository(
    private val feedService: IFeedService,
    private val database: CuteDatabase
) {

    suspend fun getFeed(): LiveData<List<Language>> {
        val feedDtos = feedService.getFeed()
        val languageDAO = database.getLanguageDao()

        feedDtos.list.map {
            val languageModel = Language(it.name, it.votes, it.logo)
            languageDAO.insert(languageModel)
        }

        Handler().postDelayed({
            val newLanguage = Language("C#", 5, "www.google.com")
            languageDAO.insert(newLanguage)
        }, 5000)

        return languageDAO.getAll()
    }
}