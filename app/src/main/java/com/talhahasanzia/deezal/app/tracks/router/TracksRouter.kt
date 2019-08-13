package com.talhahasanzia.deezal.app.tracks.router

import android.content.Context
import android.content.Intent
import com.talhahasanzia.deezal.app.albums.api.Album
import com.talhahasanzia.deezal.app.tracks.view.TracksActivity
import com.talhahasanzia.deezal.commons.contracts.BaseRouter
import java.io.Serializable

// This router need Album object to navigate to TrackActivity
class TracksRouter : BaseRouter<TracksRouter.TracksData> {

    companion object Keys {
        const val TRACK_DATA = "TRACK_DATA"
    }

    override fun route(context: Context, data: TracksData) {
        val intent = Intent(context, TracksActivity::class.java)
        intent.putExtra(TRACK_DATA, data)
        context.startActivity(intent)
    }

    data class TracksData(val artistName: String, val album: Album) : Serializable
}