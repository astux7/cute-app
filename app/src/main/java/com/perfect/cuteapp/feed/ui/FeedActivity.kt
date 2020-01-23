package com.perfect.cuteapp.feed.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.perfect.cuteapp.R
import com.perfect.cuteapp.feed.model.Language
import com.perfect.cuteapp.feed.viewmodel.FeedViewModel
import kotlinx.android.synthetic.main.activity_feed.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class FeedActivity : AppCompatActivity() {

    val feedViewModel: FeedViewModel by inject()
    private lateinit var viewAdapter: LanguageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)


        val feedObserver = Observer<List<Language>> { feed ->
//            feedTitle.text = feed.title
            viewAdapter = LanguageAdapter(feed)

            feedList.apply {
                adapter = viewAdapter
                layoutManager = LinearLayoutManager(this@FeedActivity)
            }

        }

        feedViewModel.feedData.observe(this, feedObserver)

        GlobalScope.launch {
            feedViewModel.getFeed()

        }
    }
}