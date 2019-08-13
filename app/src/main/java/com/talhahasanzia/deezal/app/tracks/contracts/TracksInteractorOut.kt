package com.talhahasanzia.deezal.app.tracks.contracts

import com.talhahasanzia.deezal.app.tracks.api.Track
import com.talhahasanzia.deezal.commons.contracts.BaseInteractorOut

interface TracksInteractorOut : BaseInteractorOut {
    fun onTracksFailure(message: String)
    fun onTracksFound(data: List<Track>)
}