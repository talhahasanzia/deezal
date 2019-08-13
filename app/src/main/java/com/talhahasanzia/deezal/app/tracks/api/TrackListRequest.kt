package com.talhahasanzia.deezal.app.tracks.api

import com.talhahasanzia.deezal.commons.network.BaseRequest
import com.talhahasanzia.deezal.commons.network.ResponseCallback
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TrackListRequest : BaseRequest<TrackListResponse, String>() {

    companion object Keys {
        const val TRACK_ID = "TRACK_ID"
    }

    override fun execute(requestData: HashMap<String, String>, responseCallback: ResponseCallback<TrackListResponse>) {
        val trackId: String? = requestData[TRACK_ID]

        trackId?.let {
            disposable.add(
                retrofit.create(TracksAPI::class.java)
                    .getTracksByAlbum(it)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(responseCallback::onSuccess) { e -> responseCallback.onFailure(e.message, -1) }
            )
        }
    }
}