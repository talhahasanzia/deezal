package com.talhahasanzia.deezal.app.tracks.interactor

import com.talhahasanzia.deezal.app.tracks.api.TrackListResponse
import com.talhahasanzia.deezal.app.tracks.contracts.TracksInteractorOut
import com.talhahasanzia.deezal.app.util.TestUtils
import com.talhahasanzia.deezal.commons.network.Request
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TracksInteractorImplTest {

    @InjectMocks
    private lateinit var interactor: TracksInteractorImpl

    @Mock
    lateinit var requestData: HashMap<String, String>

    @Mock
    lateinit var request: Request<TrackListResponse, String>

    @Mock
    lateinit var out: TracksInteractorOut

    @Before
    fun setUp() {
        interactor.initOut(out)
    }

    @Test
    fun fetchTrackList_withId_shouldCallRequestExecute() {
        val id = "27"
        interactor.fetchTrackList(id)

        Mockito.verify(request).execute(requestData, interactor)
    }

    @Test
    fun onSuccess_withResponse_shouldCallOnTracksFound() {
        val response = TestUtils.getDummyTracksResponse()
        interactor.onSuccess(response)

        Mockito.verify(out).onTracksFound(response.data)
        Mockito.verify(request).dispose()
    }

    @Test
    fun onFailure_withMessage_shouldCallOnTracksFailure() {
        val message = "Error Message"
        interactor.onFailure(message, -1)

        Mockito.verify(out).onTracksFailure(message)
        Mockito.verify(request).dispose()
    }
}