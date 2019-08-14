package com.talhahasanzia.deezal.app.albums.presenter

import com.talhahasanzia.deezal.app.albums.contracts.AlbumsInteractor
import com.talhahasanzia.deezal.app.albums.contracts.AlbumsView
import com.talhahasanzia.deezal.app.util.TestUtils
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AlbumsPresenterImplTest {

    @InjectMocks
    private lateinit var presenter: AlbumsPresenterImpl

    @Mock
    lateinit var interactor: AlbumsInteractor

    @Mock
    lateinit var view: AlbumsView

    @Before
    fun setUp() {
        presenter.initView(view)
    }

    @Test
    fun getAlbumsByArtist_withArtistId_shouldFetchAlbumsByArtist() {
        val id = "27"
        presenter.getAlbumByArtist(id)

        Mockito.verify(interactor).fetchAlbumsByArtistId(id)
    }

    @Test
    fun onAlbumsFound_emptyData_shouldShowNoAlbumFound() {
        presenter.onAlbumsFound(ArrayList())

        Mockito.verify(view).showNoAlbumsFound()
    }

    @Test
    fun onAlbumsFound_validData_shouldSetAlbumData() {
        val albums = TestUtils.getDummyAlbum()
        val data = arrayListOf(albums)
        presenter.onAlbumsFound(data)

        Mockito.verify(view).setAlbums(data)
    }

    @Test
    fun onAlbumsFailure_withMessage_shouldShowError() {
        val message = "Error Message"
        presenter.onAlbumsFailure(message)

        Mockito.verify(view).showError(message)
    }
}