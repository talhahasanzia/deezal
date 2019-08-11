package com.talhahasanzia.deezal.app.search.interactor

import com.talhahasanzia.deezal.app.search.contracts.SearchInteractor
import com.talhahasanzia.deezal.app.search.contracts.SearchInteractorOut
import com.talhahasanzia.deezal.commons.contracts.BaseInteractor

class SearchInteractorImpl : SearchInteractor {

    private lateinit var out: SearchInteractorOut

    override fun initOut(out: SearchInteractorOut) {
        this.out = out
    }

}