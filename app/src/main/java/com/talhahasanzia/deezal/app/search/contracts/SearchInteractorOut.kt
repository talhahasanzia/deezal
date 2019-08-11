package com.talhahasanzia.deezal.app.search.contracts

import com.talhahasanzia.deezal.app.search.api.Data
import com.talhahasanzia.deezal.commons.contracts.BaseInteractorOut

interface SearchInteractorOut : BaseInteractorOut {
    fun onArtistsFound(data: List<Data>)
    fun onArtistFailure(message: String)
}