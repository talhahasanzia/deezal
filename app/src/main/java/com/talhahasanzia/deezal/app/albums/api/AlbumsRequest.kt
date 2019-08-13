package com.talhahasanzia.deezal.app.albums.api

import com.talhahasanzia.deezal.commons.network.BaseRequest
import com.talhahasanzia.deezal.commons.network.ResponseCallback
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AlbumsRequest : BaseRequest<AlbumsResponse, String>() {

    // Keys for data specific to this request
    companion object Keys {
        const val ID = "id"
    }

    override fun execute(data: HashMap<String, String>, responseCallback: ResponseCallback<AlbumsResponse>) {
        data[ID]?.let {
            disposable.add(
                retrofit.create(AlbumsAPI::class.java)
                    .getArtistAlbums(it)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(responseCallback::onSuccess) { e -> responseCallback.onFailure(e.message, -1) }
            )
        }

    }
}