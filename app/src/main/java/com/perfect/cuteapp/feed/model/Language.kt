package com.perfect.cuteapp.feed.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * A model object for a Language
 */
@Entity
data class Language(@PrimaryKey val name: String, val votes: Int, val logo: String)