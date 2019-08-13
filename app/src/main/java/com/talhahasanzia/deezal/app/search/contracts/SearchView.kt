package com.talhahasanzia.deezal.app.search.contracts

import com.talhahasanzia.deezal.app.search.adapters.ArtistsAdapter
import com.talhahasanzia.deezal.app.search.api.Artist
import com.talhahasanzia.deezal.commons.contracts.BaseView

interface SearchView : BaseView, ArtistsAdapter.ArtistClickListener {
    fun clearErrors()
    fun showNoArtistsFound()
    fun setArtistsData(data: List<Artist>)
}