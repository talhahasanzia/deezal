package com.talhahasanzia.deezal.app.tracks.api

import com.talhahasanzia.deezal.commons.network.BaseRequest
import com.talhahasanzia.deezal.commons.network.ResponseCallback

class TrackListRequest: BaseRequest<TrackListResponse, String>() {

    companion object Keys{
        const val TRACK_ID = "TRACK_ID"
    }

    override fun execute(requestData: HashMap<String, String>, responseCallback: ResponseCallback<TrackListResponse>) {

    }
}