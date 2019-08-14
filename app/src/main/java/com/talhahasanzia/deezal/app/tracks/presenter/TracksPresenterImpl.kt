package com.talhahasanzia.deezal.app.tracks.presenter

import com.talhahasanzia.deezal.app.tracks.api.Track
import com.talhahasanzia.deezal.app.tracks.contracts.TracksInteractor
import com.talhahasanzia.deezal.app.tracks.contracts.TracksInteractorOut
import com.talhahasanzia.deezal.app.tracks.contracts.TracksPresenter
import com.talhahasanzia.deezal.app.tracks.contracts.TracksView
import javax.inject.Inject

class TracksPresenterImpl @Inject constructor(
    private val interactor: TracksInteractor
) : TracksPresenter, TracksInteractorOut {

    private lateinit var view: TracksView

    override fun initView(view: TracksView) {
        this.view = view
        interactor.initOut(this)
    }

    override fun getTracks(trackListId: String) {
        interactor.fetchTrackList(trackListId)
    }

    override fun onTracksFound(data: List<Track>) {
        if(data.isNotEmpty()){
            view.setTrackList(data)
        }else{
            view.showNoTracksFound()
        }
    }

    override fun onTracksFailure(message: String) {
        view.showError(message)
    }
}