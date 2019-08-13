package com.talhahasanzia.deezal.app.albums.dependencies

import com.talhahasanzia.deezal.app.albums.api.AlbumsRequest
import com.talhahasanzia.deezal.app.albums.api.AlbumsResponse
import com.talhahasanzia.deezal.app.albums.contracts.AlbumsInteractor
import com.talhahasanzia.deezal.app.albums.contracts.AlbumsPresenter
import com.talhahasanzia.deezal.app.albums.interactor.AlbumsInteractorImpl
import com.talhahasanzia.deezal.app.albums.presenter.AlbumsPresenterImpl
import com.talhahasanzia.deezal.app.tracks.router.TracksRouter
import com.talhahasanzia.deezal.commons.network.Request
import dagger.Module
import dagger.Provides

@Module
class AlbumsModule {

    @Provides
    @AlbumsScope
    fun provideAlbumsPresenter(interactor: AlbumsInteractor): AlbumsPresenter {
        return AlbumsPresenterImpl(interactor)
    }

    @Provides
    @AlbumsScope
    fun provideAlbumsInteractor(request: Request<AlbumsResponse, String>): AlbumsInteractor {
        return AlbumsInteractorImpl(request)
    }

    @Provides
    @AlbumsScope
    fun provideAlbumsRequest(): Request<AlbumsResponse, String> {
        return AlbumsRequest()
    }

    @Provides
    @AlbumsScope
    fun provideTracksRouter(): TracksRouter {
        return TracksRouter()
    }
}

