package com.talhahasanzia.deezal.app.tracks.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.talhahasanzia.deezal.R
import com.talhahasanzia.deezal.app.tracks.api.Track

class TracksAdapter(private var data: List<Track>) : RecyclerView.Adapter<TracksAdapter.TracksViewHolder>() {

    fun updateData(data: List<Track>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): TracksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.track_list_item, parent, false)
        return TracksViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(viewHolder: TracksViewHolder, position: Int) {
        viewHolder.bind(data[position])
    }


    class TracksViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(track: Track) {
            view.findViewById<TextView>(R.id.trackPosition).text = track.track_position.toString()
            view.findViewById<TextView>(R.id.trackTitle).text = track.title
            view.findViewById<TextView>(R.id.trackArtist).text = track.artist.name
        }
    }
}