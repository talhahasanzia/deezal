package com.talhahasanzia.deezal.app.tracks.view

import com.talhahasanzia.deezal.R
import com.talhahasanzia.deezal.app.tracks.contracts.TracksPresenter
import com.talhahasanzia.deezal.app.tracks.contracts.TracksView
import com.talhahasanzia.deezal.app.tracks.dependencies.DaggerTracksComponent
import com.talhahasanzia.deezal.commons.ui.BaseActivity
import javax.inject.Inject

class TracksActivity : BaseActivity(), TracksView {

    @Inject
    lateinit var presenter : TracksPresenter

    override fun getLayout(): Int {
        return R.layout.activity_tracks
    }

    override fun inject() {
        DaggerTracksComponent
            .create()
            .inject(this)
    }

    override fun onCreate() {

    }
}