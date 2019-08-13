package com.talhahasanzia.deezal.app.tracks.contracts

import com.talhahasanzia.deezal.app.tracks.api.Track
import com.talhahasanzia.deezal.commons.contracts.BaseView

interface TracksView : BaseView {
    fun setTrackList(data: List<Track>)
    fun showNoTracksFound()
}