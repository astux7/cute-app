package com.perfect.cuteapp.feed.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.perfect.cuteapp.R
import com.perfect.cuteapp.feed.model.Language

class LanguageAdapter(private val languages: List<Language>) :
    RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_language, parent, false)

        return LanguageViewHolder(layout)
    }

    override fun getItemCount() = languages.size

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.name.text = languages[position].name
    }

    class LanguageViewHolder(layout: View) : RecyclerView.ViewHolder(layout) {
        val name: TextView = layout.findViewById(R.id.name)
    }
}