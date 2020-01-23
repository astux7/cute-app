package com.perfect.cuteapp.feed.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.perfect.cuteapp.feed.model.Language
import com.perfect.cuteapp.feed.repository.FeedRepository

class FeedViewModel(private val feedRepository: FeedRepository) : ViewModel() {

    val feedData: MutableLiveData<List<Language>> = MutableLiveData()

    suspend fun getFeed() {
        val feed = feedRepository.getFeed()
        feedData.postValue(feed.value)
    }
}