package com.talhahasanzia.deezal.app.search.contracts

import com.talhahasanzia.deezal.app.search.api.Data
import com.talhahasanzia.deezal.commons.contracts.BaseView

interface SearchView : BaseView {
    fun clearErrors()
    fun showNoArtistsFound()
    fun setArtistsData(data: List<Data>)
}