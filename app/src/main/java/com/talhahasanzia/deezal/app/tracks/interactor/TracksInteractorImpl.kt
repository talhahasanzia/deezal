package com.talhahasanzia.deezal.app.tracks.interactor

import com.talhahasanzia.deezal.app.tracks.api.TrackListRequest
import com.talhahasanzia.deezal.app.tracks.api.TrackListResponse
import com.talhahasanzia.deezal.app.tracks.contracts.TracksInteractor
import com.talhahasanzia.deezal.app.tracks.contracts.TracksInteractorOut
import com.talhahasanzia.deezal.commons.logging.DeezalLogger
import com.talhahasanzia.deezal.commons.network.Request
import com.talhahasanzia.deezal.commons.network.ResponseCallback
import javax.inject.Inject

class TracksInteractorImpl @Inject constructor(
    private val requestData: HashMap<String, String>,
    private val request: Request<TrackListResponse, String>
) : TracksInteractor, ResponseCallback<TrackListResponse> {

    private lateinit var out: TracksInteractorOut

    override fun initOut(out: TracksInteractorOut) {
        this.out = out
    }

    override fun fetchTrackList(trackListId: String) {
        requestData[TrackListRequest.TRACK_ID] = trackListId
        request.execute(requestData, this)
    }

    override fun onSuccess(response: TrackListResponse) {
        out.onTracksFound(response.data)
        request.dispose()
    }

    override fun onFailure(message: String?, code: Int) {
        message?.let {
            DeezalLogger.log(it)
            out.onTracksFailure(message)
        }
        request.dispose()
    }
}