package com.talhahasanzia.deezal.app.search.dependencies

import com.talhahasanzia.deezal.app.search.contracts.SearchPresenter
import com.talhahasanzia.deezal.app.search.contracts.SearchView
import com.talhahasanzia.deezal.app.search.presenter.SearchPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class SearchModule {

    @Provides
    @SearchScope
    fun providePresenter(view: SearchView): SearchPresenter {
        val presenter = SearchPresenterImpl()
        presenter.initView(view)
        return presenter
    }
}