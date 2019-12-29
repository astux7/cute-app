package com.perfect.cuteapp.feed.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.perfect.cuteapp.feed.model.Feed
import com.perfect.cuteapp.feed.repository.FeedRepository

class FeedViewModel(private val feedRepository: FeedRepository) : ViewModel() {

    val feedData: MutableLiveData<Feed> = MutableLiveData()

    suspend fun getFeed() {
        val feed = feedRepository.getFeed()
        feedData.postValue(feed)
    }
}