package com.talhahasanzia.deezal.app.albums.view

import android.support.annotation.LayoutRes
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.talhahasanzia.deezal.R
import com.talhahasanzia.deezal.app.albums.adapters.AlbumsAdapter
import com.talhahasanzia.deezal.app.albums.api.Album
import com.talhahasanzia.deezal.app.albums.contracts.AlbumsPresenter
import com.talhahasanzia.deezal.app.albums.contracts.AlbumsView
import com.talhahasanzia.deezal.app.albums.dependencies.DaggerAlbumsComponent
import com.talhahasanzia.deezal.app.albums.router.AlbumsRouter
import com.talhahasanzia.deezal.app.search.api.Artist
import com.talhahasanzia.deezal.app.tracks.router.TracksRouter
import com.talhahasanzia.deezal.commons.extensions.hide
import com.talhahasanzia.deezal.commons.extensions.show
import com.talhahasanzia.deezal.commons.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_albums.*
import javax.inject.Inject


class AlbumsActivity : BaseActivity(), AlbumsView {

    @Inject
    lateinit var presenter: AlbumsPresenter

    @Inject
    lateinit var tracksRouter: TracksRouter

    private lateinit var adapter: AlbumsAdapter

    @LayoutRes
    override fun getLayout(): Int {
        return R.layout.activity_albums
    }

    override fun onCreate() {
        presenter.initView(this)
        initToolbar()
        checkArtist()
    }

    private fun initToolbar() {
        setSupportActionBar(albumsToolbar)
        backImage.setOnClickListener { finish() }
    }

    override fun inject() {
        DaggerAlbumsComponent
            .create()
            .inject(this)
    }


    private fun checkArtist() {
        getArtistFromIntent()?.let {
            fetchAlbums(it.id)
            initRecyclerView(it.name)
        } ?: run {
            showNoAlbumsFound()
        }
    }

    private fun initRecyclerView(name: String) {
        // initialize with empty data first time
        adapter = AlbumsAdapter(name, ArrayList(), this)

        val layoutManager = FlexboxLayoutManager(this)
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.justifyContent = JustifyContent.SPACE_BETWEEN

        albumsRecyclerView.layoutManager = layoutManager
        albumsRecyclerView.adapter = adapter
    }

    private fun fetchAlbums(id: String) {
        presenter.getAlbumByArtist(id)
    }

    private fun getArtistFromIntent(): Artist? {
        var artist: Artist? = null
        if (intent.hasExtra(AlbumsRouter.ARTIST)) {
            artist = intent.getSerializableExtra(AlbumsRouter.ARTIST) as Artist
        }
        return artist
    }

    override fun setAlbums(data: List<Album>) {
        albumsLoader.hide()
        noAlbumsText.hide()
        albumsRecyclerView.show()
        adapter.updateData(data)
    }

    override fun showNoAlbumsFound() {
        albumsLoader.hide()
        albumsRecyclerView.hide()
        noAlbumsText.show()
    }

    override fun onAlbumClicked(album: Album) {
        getArtistFromIntent()?.let {
            val trackData = TracksRouter.TracksData(it.name, album)
            tracksRouter.route(this, trackData)
        }
    }

    override fun showError(message: String) {
        super.showError(message)
        showNoAlbumsFound()
    }
}
