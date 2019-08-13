package com.talhahasanzia.deezal.app.albums.interactor

import com.talhahasanzia.deezal.app.albums.api.AlbumsRequest
import com.talhahasanzia.deezal.app.albums.api.AlbumsResponse
import com.talhahasanzia.deezal.app.albums.contracts.AlbumsInteractor
import com.talhahasanzia.deezal.app.albums.contracts.AlbumsInteractorOut
import com.talhahasanzia.deezal.commons.logging.DeezalLogger
import com.talhahasanzia.deezal.commons.network.Request
import com.talhahasanzia.deezal.commons.network.ResponseCallback
import javax.inject.Inject

class AlbumsInteractorImpl @Inject constructor(
    private val request: Request<AlbumsResponse, String>
) : AlbumsInteractor, ResponseCallback<AlbumsResponse> {

    private lateinit var out: AlbumsInteractorOut

    override fun initOut(out: AlbumsInteractorOut) {
        this.out = out
    }

    override fun fetchAlbumsByArtistId(id: String) {
        val data = HashMap<String, String>()
        data[AlbumsRequest.ID] = id
        request.execute(data, this)
    }

    override fun onSuccess(response: AlbumsResponse) {
        out.onAlbumsFound(response.data)
        request.dispose()
    }

    override fun onFailure(message: String?, code: Int) {
        message?.let {
            DeezalLogger.log(it)
            out.onAlbumsFailure(it)
        }
        request.dispose()
    }
}