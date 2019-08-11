package com.talhahasanzia.deezal.app.search.presenter

import com.talhahasanzia.deezal.app.search.contracts.SearchInteractor
import com.talhahasanzia.deezal.app.search.contracts.SearchInteractorOut
import com.talhahasanzia.deezal.app.search.contracts.SearchPresenter
import com.talhahasanzia.deezal.app.search.contracts.SearchView
import com.talhahasanzia.deezal.app.search.interactor.SearchInteractorImpl

class SearchPresenterImpl : SearchPresenter, SearchInteractorOut {
    private lateinit var view: SearchView
    private lateinit var searchInteractor: SearchInteractor

    override fun initView(view: SearchView) {
        this.view = view
        searchInteractor = SearchInteractorImpl()
        searchInteractor.initOut(this)
    }
}