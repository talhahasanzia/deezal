package com.talhahasanzia.deezal.app.albums.router

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.talhahasanzia.deezal.app.albums.view.AlbumsActivity
import com.talhahasanzia.deezal.commons.contracts.BaseRouter

class AlbumsRouter : BaseRouter {

    companion object Keys{
        const val ARTIST = "artist"
    }

    override fun route(context: Context, bundle: Bundle) {
        val intent = Intent(context, AlbumsActivity::class.java)
        intent.putExtra(ARTIST, bundle)
        context.startActivity(intent)
    }
}