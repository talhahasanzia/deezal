package com.talhahasanzia.deezal.app.tracks.presenter

import com.talhahasanzia.deezal.app.tracks.contracts.TracksInteractor
import com.talhahasanzia.deezal.app.tracks.contracts.TracksView
import com.talhahasanzia.deezal.app.util.TestUtils
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TracksPresenterImplTest {

    @InjectMocks
    private lateinit var presenter: TracksPresenterImpl

    @Mock
    lateinit var interactor: TracksInteractor

    @Mock
    lateinit var view: TracksView

    @Before
    fun setUp() {
        presenter.initView(view)
    }

    @Test
    fun getTracks_withAlbumId_shouldFetchTracks() {
        val id = "334"
        presenter.getTracks(id)

        Mockito.verify(interactor).fetchTrackList(id)
    }

    @Test
    fun onTracksFound_emptyData_shouldShowNoTracksFound() {
        presenter.onTracksFound(ArrayList())

        Mockito.verify(view).showNoTracksFound()
    }

    @Test
    fun onTracksFound_validData_shouldSetTrackList() {
        val tracks = TestUtils.getDummyTrack()
        val data = arrayListOf(tracks)
        presenter.onTracksFound(data)

        Mockito.verify(view).setTrackList(data)
    }

    @Test
    fun onTracksFailure_withMessage_shouldShowError() {
        val message = "Error Message"
        presenter.onTracksFailure(message)

        Mockito.verify(view).showError(message)
    }
}