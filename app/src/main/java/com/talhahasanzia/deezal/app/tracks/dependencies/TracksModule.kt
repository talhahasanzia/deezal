package com.talhahasanzia.deezal.app.tracks.dependencies

import com.talhahasanzia.deezal.app.tracks.api.TrackListRequest
import com.talhahasanzia.deezal.app.tracks.api.TrackListResponse
import com.talhahasanzia.deezal.app.tracks.contracts.TracksInteractor
import com.talhahasanzia.deezal.app.tracks.contracts.TracksPresenter
import com.talhahasanzia.deezal.app.tracks.interactor.TracksInteractorImpl
import com.talhahasanzia.deezal.app.tracks.presenter.TracksPresenterImpl
import com.talhahasanzia.deezal.commons.network.Request
import dagger.Module
import dagger.Provides

@Module
class TracksModule {

    @Provides
    @TracksScope
    fun providePresenter(interactor: TracksInteractor): TracksPresenter {
        return TracksPresenterImpl(interactor)
    }

    @Provides
    @TracksScope
    fun provideInteractor(
        requestData: HashMap<String, String>,
        request: Request<TrackListResponse, String>
    ): TracksInteractor {
        return TracksInteractorImpl(requestData, request)
    }

    @Provides
    @TracksScope
    fun provideTrackListRequest(): Request<TrackListResponse, String> {
        return TrackListRequest()
    }

    @TracksScope
    @Provides
    fun provideRequestData(): HashMap<String, String> {
        return HashMap()
    }
}