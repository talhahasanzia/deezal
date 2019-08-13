package com.talhahasanzia.deezal.app.tracks.router

import android.content.Context
import android.content.Intent
import com.talhahasanzia.deezal.app.albums.api.Album
import com.talhahasanzia.deezal.app.tracks.view.TracksActivity
import com.talhahasanzia.deezal.commons.contracts.BaseRouter

// This router need Album object to navigate to TrackActivity
class TracksRouter : BaseRouter<Album> {

    companion object Keys {
        const val ALBUM = "ALBUM"
    }

    override fun route(context: Context, data: Album) {
        val intent = Intent(context, TracksActivity::class.java)
        intent.putExtra(ALBUM, data)
        context.startActivity(intent)
    }
}