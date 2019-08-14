package com.talhahasanzia.deezal.app.search.presenter

import com.talhahasanzia.deezal.app.search.contracts.SearchInteractor
import com.talhahasanzia.deezal.app.search.contracts.SearchView
import com.talhahasanzia.deezal.app.util.TestUtils
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SearchPresenterImplTest {

    @InjectMocks
    private lateinit var presenter: SearchPresenterImpl

    @Mock
    lateinit var interactor: SearchInteractor

    @Mock
    lateinit var view: SearchView

    @Before
    fun setUp() {
        presenter.initView(view)
    }

    @Test
    fun onTextChanged_emptyText_shouldClearErrors() {
        presenter.onTextChanged("")

        Mockito.verify(view).clearErrors()
    }

    @Test
    fun onTextChanged_validText_shouldGetArtists() {
        val query = "some query"

        presenter.onTextChanged(query)

        Mockito.verify(interactor).getArtists(query)
    }

    @Test
    fun onArtistsFound_emptyData_shouldShowNoArtistFound() {
        presenter.onArtistsFound(ArrayList())

        Mockito.verify(view).showNoArtistsFound()
    }

    @Test
    fun onArtistsFound_validData_shouldSetArtistData() {
        val artist = TestUtils.getDummyArtist()
        val data = arrayListOf(artist)
        presenter.onArtistsFound(data)

        Mockito.verify(view).setArtistsData(data)
    }

    @Test
    fun onArtistFailure_withMessage_shouldShowError() {
        val message = "Error Message"
        presenter.onArtistFailure(message)

        Mockito.verify(view).showError(message)
    }
}