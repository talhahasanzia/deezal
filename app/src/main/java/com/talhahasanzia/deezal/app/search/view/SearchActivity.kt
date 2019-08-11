package com.talhahasanzia.deezal.app.search.view

import android.support.annotation.LayoutRes
import com.talhahasanzia.deezal.R
import com.talhahasanzia.deezal.app.search.contracts.SearchPresenter
import com.talhahasanzia.deezal.app.search.dependencies.DaggerSearchComponent
import com.talhahasanzia.deezal.commons.ui.BaseActivity
import javax.inject.Inject

class SearchActivity : BaseActivity() {

    @Inject
    private lateinit var presenter : SearchPresenter

    @LayoutRes
    override fun getLayout(): Int {
        return R.layout.activity_search
    }

    override fun inject() {
        DaggerSearchComponent
            .create()
            .inject(this)
    }

}
