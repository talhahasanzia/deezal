package com.talhahasanzia.deezal.app.albums.contracts

import com.talhahasanzia.deezal.app.albums.api.Album
import com.talhahasanzia.deezal.commons.contracts.BaseInteractorOut

interface AlbumsInteractorOut : BaseInteractorOut {
    fun onAlbumsFailure(message: String)
    fun onAlbumsFound(data: List<Album>)
}