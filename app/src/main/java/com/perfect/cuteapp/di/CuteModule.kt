package com.perfect.cuteapp.di

import com.google.gson.GsonBuilder
import com.perfect.cuteapp.feed.repository.FeedRepository
import com.perfect.cuteapp.feed.service.IFeedService
import com.perfect.cuteapp.feed.viewmodel.FeedViewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CuteModule {

    val module = module {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://cute-ruby-api.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create())).build()

        ////// Feed //////
        single<IFeedService> { retrofit.create(IFeedService::class.java) }
        single { FeedRepository(get()) }
        single { FeedViewModel(get()) }
    }
}