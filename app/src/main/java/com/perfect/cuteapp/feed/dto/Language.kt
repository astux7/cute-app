package com.perfect.cuteapp.feed.dto

import androidx.room.PrimaryKey

data class Language(@PrimaryKey val name: String, val votes: Int, val logo: String)