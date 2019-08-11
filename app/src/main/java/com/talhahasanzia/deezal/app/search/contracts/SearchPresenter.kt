package com.talhahasanzia.deezal.app.search.contracts

import com.talhahasanzia.deezal.commons.contracts.BasePresenter

interface SearchPresenter : BasePresenter<SearchView> {
    fun onTextChanged(string: String)
}