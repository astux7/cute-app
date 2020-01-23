package com.perfect.cuteapp.di

import androidx.room.Room
import com.google.gson.GsonBuilder
import com.perfect.cuteapp.common.database.CuteDatabase
import com.perfect.cuteapp.feed.repository.FeedRepository
import com.perfect.cuteapp.feed.service.IFeedService
import com.perfect.cuteapp.feed.viewmodel.FeedViewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// dipendancy injection
object CuteModule {

    val module = module {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://cute-ruby-api.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create())).build()

        single<CuteDatabase> {
            Room.databaseBuilder(
                get(),
                CuteDatabase::class.java,
                "cute-db"
            ).build()
        }

        ////// Feed //////
        single<IFeedService> { retrofit.create(IFeedService::class.java) }
        single { FeedRepository(get(), get()) }
        single { FeedViewModel(get()) }
    }
}