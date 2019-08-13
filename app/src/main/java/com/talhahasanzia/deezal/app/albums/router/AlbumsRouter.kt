package com.talhahasanzia.deezal.app.albums.router

import android.content.Context
import android.content.Intent
import com.talhahasanzia.deezal.app.albums.view.AlbumsActivity
import com.talhahasanzia.deezal.app.search.api.Artist
import com.talhahasanzia.deezal.commons.contracts.BaseRouter

class AlbumsRouter : BaseRouter<Artist> {

    companion object Keys {
        const val ARTIST = "artist"
    }

    override fun route(context: Context, data: Artist) {
        val intent = Intent(context, AlbumsActivity::class.java)
        intent.putExtra(ARTIST, data)
        context.startActivity(intent)
    }
}