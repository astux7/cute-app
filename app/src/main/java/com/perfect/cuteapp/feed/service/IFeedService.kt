package com.perfect.cuteapp.feed.service

import retrofit2.http.GET

interface IFeedService {

    /**
     * Gets all of the Feed data
     */
    @GET("/feed")
    suspend fun getFeed(): com.perfect.cuteapp.feed.dto.Feed
}