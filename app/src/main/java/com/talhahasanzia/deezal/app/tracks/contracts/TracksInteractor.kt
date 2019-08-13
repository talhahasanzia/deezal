package com.talhahasanzia.deezal.app.tracks.contracts

import com.talhahasanzia.deezal.commons.contracts.BaseInteractor

interface TracksInteractor : BaseInteractor<TracksInteractorOut> {
    fun fetchTrackList(trackListId: String)
}