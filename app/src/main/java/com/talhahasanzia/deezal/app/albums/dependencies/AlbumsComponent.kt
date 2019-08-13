package com.talhahasanzia.deezal.app.albums.dependencies

import com.talhahasanzia.deezal.app.albums.view.AlbumsActivity
import com.talhahasanzia.deezal.app.search.dependencies.SearchScope
import dagger.Component

@AlbumsScope
@Component(modules = [AlbumsModule::class])
interface AlbumsComponent {
    fun inject(albumsActivity: AlbumsActivity)
}