package com.talhahasanzia.deezal.app.tracks.view

import android.support.v7.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import com.talhahasanzia.deezal.R
import com.talhahasanzia.deezal.app.tracks.adapters.TracksAdapter
import com.talhahasanzia.deezal.app.tracks.api.Track
import com.talhahasanzia.deezal.app.tracks.contracts.TracksPresenter
import com.talhahasanzia.deezal.app.tracks.contracts.TracksView
import com.talhahasanzia.deezal.app.tracks.dependencies.DaggerTracksComponent
import com.talhahasanzia.deezal.app.tracks.router.TracksRouter
import com.talhahasanzia.deezal.commons.extensions.hide
import com.talhahasanzia.deezal.commons.extensions.show
import com.talhahasanzia.deezal.commons.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_tracks.*
import javax.inject.Inject

class TracksActivity : BaseActivity(), TracksView {

    @Inject
    lateinit var presenter: TracksPresenter

    private lateinit var adapter: TracksAdapter

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
        initBack()
    }

    private fun initAlbum() {
        getTracksData()?.let {
            // set album logo
            Picasso.get()
                .load(it.album.cover_big)
                .into(albumLogo)

            //set album title
            albumTitleText.text = it.album.title
            // set artist name
            artistTitleText.text = it.artistName
        }
    }

    private fun initRecyclerView() {
        // initialize adapter with empty list
        adapter = TracksAdapter(ArrayList())

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        tracksRecyclerView.layoutManager = layoutManager
        tracksRecyclerView.adapter = adapter

    }

    private fun initTracks() {
        presenter.getTracks(getTrackListId())
    }

    private fun initBack() {
        backImage.setOnClickListener { finish() }
    }

    private fun getTrackListId(): String {
        var id = "-1"
        getTracksData()?.let {
            id = it.album.id
        }
        return id
    }

    private fun getTracksData(): TracksRouter.TracksData? {
        var data: TracksRouter.TracksData? = null
        if (intent.hasExtra(TracksRouter.TRACK_DATA)) {
            data = intent.getSerializableExtra(TracksRouter.TRACK_DATA) as TracksRouter.TracksData
        }
        return data
    }

    override fun setTrackList(data: List<Track>) {
        // album did not provide any data about volume
        // take that data from track data
        val volumeLabel = getString(R.string.volume_label).format(data[0].disk_number)
        volumeTitleText.text = volumeLabel

        tracksLoader.hide()
        tracksRecyclerView.show()
        adapter.updateData(data)
    }

    override fun showNoTracksFound() {
        tracksLoader.hide()
        noTracksError.show()
    }
}