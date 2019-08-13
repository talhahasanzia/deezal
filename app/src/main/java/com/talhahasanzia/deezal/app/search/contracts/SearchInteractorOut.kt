package com.talhahasanzia.deezal.app.search.contracts

import com.talhahasanzia.deezal.app.search.api.Artist
import com.talhahasanzia.deezal.commons.contracts.BaseInteractorOut

interface SearchInteractorOut : BaseInteractorOut {
    fun onArtistsFound(data: List<Artist>)
    fun onArtistFailure(message: String)
}