package com.talhahasanzia.deezal.app.tracks.interactor

import com.talhahasanzia.deezal.app.tracks.api.TrackListResponse
import com.talhahasanzia.deezal.app.tracks.contracts.TracksInteractor
import com.talhahasanzia.deezal.app.tracks.contracts.TracksInteractorOut
import com.talhahasanzia.deezal.commons.network.Request
import javax.inject.Inject

class TracksInteractorImpl @Inject constructor(
    private val request: Request<TrackListResponse, String>
) : TracksInteractor {

    private lateinit var out: TracksInteractorOut

    override fun initOut(out: TracksInteractorOut) {
        this.out = out
    }
}