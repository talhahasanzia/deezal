package com.talhahasanzia.deezal.app.albums.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.talhahasanzia.deezal.R
import com.talhahasanzia.deezal.app.albums.api.Album

class AlbumsAdapter(
    private var artist: String,
    private var data: List<Album>,
    private val albumClickListener: AlbumClickListener
) : RecyclerView.Adapter<AlbumsAdapter.AlbumViewHolder>() {

    fun updateData(data: List<Album>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.album_item, parent, false)
        return AlbumViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(viewHolder: AlbumViewHolder, position: Int) {
        viewHolder.bind(data[position])
    }


    inner class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(album: Album) {
            // set title of album
            itemView.findViewById<TextView>(R.id.albumTitle).text = album.title
            // set title of artist
            itemView.findViewById<TextView>(R.id.artistTitle).text = artist
            // set album logo
            val albumLogo = itemView.findViewById<ImageView>(R.id.albumLogo)

            Picasso.get()
                .load(album.cover_medium)
                .into(albumLogo)

            itemView.setOnClickListener { albumClickListener.onAlbumClicked(album) }
        }
    }

    interface AlbumClickListener {
        fun onAlbumClicked(album: Album)
    }
}