package com.talhahasanzia.deezal.app.search.view

import android.support.annotation.LayoutRes
import com.talhahasanzia.deezal.R
import com.talhahasanzia.deezal.app.search.api.SearchArtistRequest
import com.talhahasanzia.deezal.app.search.api.SearchArtistResponse
import com.talhahasanzia.deezal.commons.logging.DeezalLogger
import com.talhahasanzia.deezal.commons.network.Request
import com.talhahasanzia.deezal.commons.network.ResponseCallback
import com.talhahasanzia.deezal.commons.ui.BaseActivity

class SearchActivity : BaseActivity() {

    @LayoutRes
    override fun getLayout(): Int {
        return R.layout.activity_search
    }

    override fun inject() {
    }

}
