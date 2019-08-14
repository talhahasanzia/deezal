package com.talhahasanzia.deezal.app.search.interactor

import com.talhahasanzia.deezal.app.search.api.SearchArtistResponse
import com.talhahasanzia.deezal.app.search.contracts.SearchInteractorOut
import com.talhahasanzia.deezal.app.util.TestUtils
import com.talhahasanzia.deezal.commons.network.Request
import com.talhahasanzia.deezal.commons.network.ResponseCallback
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SearchInteractorImplTest {

    @InjectMocks
    private lateinit var searchInteractorImpl: SearchInteractorImpl

    @Mock
    private lateinit var out: SearchInteractorOut

    @Mock
    private lateinit var searchArtistRequest: Request<SearchArtistResponse, String>

    @Mock
    private lateinit var requestData: HashMap<String, String>

    @Mock
    private lateinit var responseCallback: ResponseCallback<SearchArtistResponse>

    @Before
    fun setUp() {
        responseCallback = searchInteractorImpl
        searchInteractorImpl.initOut(out)
    }

    @Test
    fun getArtists_query_shouldCallExecute() {
        val query = "Two Door"
        searchInteractorImpl.getArtists(query)

        Mockito.verify(searchArtistRequest).execute(requestData, searchInteractorImpl)
    }

    @Test
    fun onSuccess_withResponse_shouldCallOnArtistsFound() {
        val response = TestUtils.getDummySearchResponse()
        searchInteractorImpl.onSuccess(response)

        Mockito.verify(out).onArtistsFound(response.data)
        Mockito.verify(searchArtistRequest).dispose()
    }

    @Test
    fun onFailure_withErrorMessage_shouldCallOnArtistFailure() {
        val message: String? = "Error message"
        searchInteractorImpl.onFailure(message, -1)

        Mockito.verify(out).onArtistFailure(message!!)
        Mockito.verify(searchArtistRequest).dispose()
    }
}