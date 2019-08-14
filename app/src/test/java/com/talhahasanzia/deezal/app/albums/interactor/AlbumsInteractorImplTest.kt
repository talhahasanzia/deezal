package com.talhahasanzia.deezal.app.albums.interactor

import com.talhahasanzia.deezal.app.albums.api.AlbumsResponse
import com.talhahasanzia.deezal.app.albums.contracts.AlbumsInteractorOut
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
class AlbumsInteractorImplTest {

    @InjectMocks
    private lateinit var interactor: AlbumsInteractorImpl

    @Mock
    lateinit var requestData: HashMap<String, String>

    @Mock
    lateinit var albumRequest: Request<AlbumsResponse, String>

    @Mock
    lateinit var out: AlbumsInteractorOut

    @Before
    fun setup() {
        interactor.initOut(out)
    }

    @Test
    fun fetchAlbumsByArtistId_givenIdAndRequestData_shouldAlbumRequestExecute() {
        val id = "22"
        interactor.fetchAlbumsByArtistId(id)

        Mockito.verify(albumRequest).execute(requestData, interactor)
    }

    @Test
    fun onSuccess_withResponse_shouldCallOnAlbumsFound() {
        val albumResponse = TestUtils.getDummyAlbumResponse()
        interactor.onSuccess(albumResponse)

        Mockito.verify(out).onAlbumsFound(albumResponse.data)
        Mockito.verify(albumRequest).dispose()
    }

    @Test
    fun onFailure_withErrorMessage_shouldCallOnAlbumsFailure() {
        val message = "Error Message"
        interactor.onFailure(message, -1)

        Mockito.verify(out).onAlbumsFailure(message)
        Mockito.verify(albumRequest).dispose()
    }
}