package com.talhahasanzia.deezal.app.search.dependencies

import com.talhahasanzia.deezal.app.search.view.SearchActivity
import dagger.Component

@Component(modules = [SearchModule::class])
interface SearchComponent {
    fun inject(searchActivity: SearchActivity)
}