package com.talhahasanzia.deezal.app.search.presenter

import com.talhahasanzia.deezal.app.search.api.Artist
import com.talhahasanzia.deezal.app.search.contracts.SearchInteractor
import com.talhahasanzia.deezal.app.search.contracts.SearchInteractorOut
import com.talhahasanzia.deezal.app.search.contracts.SearchPresenter
import com.talhahasanzia.deezal.app.search.contracts.SearchView
import javax.inject.Inject

class SearchPresenterImpl @Inject constructor(private val interactor: SearchInteractor): SearchPresenter, SearchInteractorOut {

    private lateinit var view: SearchView

    override fun initView(view: SearchView) {
        this.view = view
        interactor.initOut(this)
    }

    override fun onTextChanged(string: String) {
        if (string.isEmpty()) {
            // user cleared the text
            view.clearErrors()
        } else {
            interactor.getArtists(string)
        }
    }

    override fun onArtistsFound(data: List<Artist>) {
        if (data.isNotEmpty()) {
            view.setArtistsData(data)
        } else {
            view.showNoArtistsFound()
        }
    }

    override fun onArtistFailure(message: String) {
        view.showError(message)
    }
}
