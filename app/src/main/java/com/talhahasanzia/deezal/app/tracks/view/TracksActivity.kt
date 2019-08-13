package com.talhahasanzia.deezal.app.tracks.view

import com.talhahasanzia.deezal.R
import com.talhahasanzia.deezal.app.albums.api.Album
import com.talhahasanzia.deezal.app.tracks.contracts.TracksPresenter
import com.talhahasanzia.deezal.app.tracks.contracts.TracksView
import com.talhahasanzia.deezal.app.tracks.dependencies.DaggerTracksComponent
import com.talhahasanzia.deezal.app.tracks.router.TracksRouter
import com.talhahasanzia.deezal.commons.ui.BaseActivity
import javax.inject.Inject

class TracksActivity : BaseActivity(), TracksView {

    @Inject
    lateinit var presenter: TracksPresenter

    override fun getLayout(): Int {
        return R.layout.activity_tracks
    }

    override fun inject() {
        DaggerTracksComponent
            .create()
            .inject(this)
    }

    override fun onCreate() {
        presenter.initView(this)
        initAlbum()
        initRecyclerView()
        initTracks()
    }

    private fun initAlbum() {

    }

    private fun initRecyclerView() {

    }

    private fun initTracks() {
        presenter.getTracks(getTrackListId())
    }

    private fun getTrackListId(): String {
        var id = "-1"
        if (intent.hasExtra(TracksRouter.ALBUM)) {
            val album = intent.getSerializableExtra(TracksRouter.ALBUM) as Album
            id = album.id
        }
        return id
    }
}