package com.talhahasanzia.deezal.app.search.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.talhahasanzia.deezal.R
import com.talhahasanzia.deezal.app.search.api.Data
import com.talhahasanzia.deezal.commons.utils.CircleTransformation

class ArtistsAdapter(private var data: List<Data>) : RecyclerView.Adapter<ArtistsAdapter.ArtistViewHolder>() {

    fun updateData(data: List<Data>) {
        this.data = data
        notifyDataSetChanged()
    }

    fun clearData() {
        this.data = ArrayList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ArtistViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.artist_search_item, parent, false)
        return ArtistViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(viewHolder: ArtistViewHolder, position: Int) {
        viewHolder.bind(data[position])
    }


    inner class ArtistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: Data) {
            // set name
            itemView.findViewById<TextView>(R.id.artistNameText).text = data.name
            // set artist logo
            val artistLogo = itemView.findViewById<ImageView>(R.id.artistLogo)

            Picasso.get()
                .load(data.picture_medium)
                .transform(CircleTransformation())
                .into(artistLogo)
        }
    }
}