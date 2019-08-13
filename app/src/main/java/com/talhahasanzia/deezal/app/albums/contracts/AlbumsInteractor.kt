package com.talhahasanzia.deezal.app.albums.contracts

import com.talhahasanzia.deezal.commons.contracts.BaseInteractor

interface AlbumsInteractor : BaseInteractor<AlbumsInteractorOut> {
    fun fetchAlbumsByArtistId(id: String)
}