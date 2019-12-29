package com.perfect.cuteapp.feed.repository

import com.perfect.cuteapp.feed.model.Feed
import com.perfect.cuteapp.feed.service.IFeedService

class FeedRepository(private val feedService: IFeedService) {

     suspend fun getFeed(): Feed {
         return feedService.getFeed()
     }
}