package com.perfect.cuteapp.feed.service

import com.perfect.cuteapp.feed.model.Feed
import retrofit2.http.GET

interface IFeedService {

    /**
     * Gets all of the Feed data
     */
    @GET("/feed")
    suspend fun getFeed(): Feed
}