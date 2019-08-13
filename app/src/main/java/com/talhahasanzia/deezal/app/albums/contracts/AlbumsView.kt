package com.talhahasanzia.deezal.app.albums.contracts

import com.talhahasanzia.deezal.app.albums.adapters.AlbumsAdapter
import com.talhahasanzia.deezal.app.albums.api.Album
import com.talhahasanzia.deezal.commons.contracts.BaseView

interface AlbumsView : BaseView, AlbumsAdapter.AlbumClickListener {
    fun setAlbums(data: List<Album>)
    fun showNoAlbumsFound()
}