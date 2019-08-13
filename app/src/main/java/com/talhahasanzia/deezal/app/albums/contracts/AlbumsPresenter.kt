package com.talhahasanzia.deezal.app.albums.contracts

import com.talhahasanzia.deezal.commons.contracts.BasePresenter

interface AlbumsPresenter : BasePresenter<AlbumsView> {
    fun getAlbumByArtist(id: String)
}