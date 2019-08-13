package com.talhahasanzia.deezal.app.albums.presenter

import com.talhahasanzia.deezal.app.albums.api.Album
import com.talhahasanzia.deezal.app.albums.contracts.AlbumsInteractor
import com.talhahasanzia.deezal.app.albums.contracts.AlbumsInteractorOut
import com.talhahasanzia.deezal.app.albums.contracts.AlbumsPresenter
import com.talhahasanzia.deezal.app.albums.contracts.AlbumsView
import javax.inject.Inject

class AlbumsPresenterImpl @Inject constructor(private val interactor: AlbumsInteractor) : AlbumsPresenter,
    AlbumsInteractorOut {

    private lateinit var view: AlbumsView

    override fun initView(view: AlbumsView) {
        this.view = view
        interactor.initOut(this)
    }

    override fun getAlbumByArtist(id: String) {
        interactor.fetchAlbumsByArtistId(id)
    }

    override fun onAlbumsFound(data: List<Album>) {
        if (data.isNotEmpty()) {
            view.setAlbums(data)
        } else {
            view.showNoAlbumsFound()
        }
    }

    override fun onAlbumsFailure(message: String) {
        view.showError(message)
    }

}
