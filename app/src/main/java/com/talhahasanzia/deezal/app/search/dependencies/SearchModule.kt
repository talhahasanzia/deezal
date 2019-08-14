package com.talhahasanzia.deezal.app.search.dependencies

import com.talhahasanzia.deezal.app.albums.router.AlbumsRouter
import com.talhahasanzia.deezal.app.search.api.SearchArtistRequest
import com.talhahasanzia.deezal.app.search.api.SearchArtistResponse
import com.talhahasanzia.deezal.app.search.contracts.SearchInteractor
import com.talhahasanzia.deezal.app.search.contracts.SearchPresenter
import com.talhahasanzia.deezal.app.search.interactor.SearchInteractorImpl
import com.talhahasanzia.deezal.app.search.presenter.SearchPresenterImpl
import com.talhahasanzia.deezal.commons.network.Request
import dagger.Module
import dagger.Provides

@Module
class SearchModule {

    @SearchScope
    @Provides
    fun providePresenter(searchInteractor: SearchInteractor): SearchPresenter {
        return SearchPresenterImpl(searchInteractor)
    }

    @SearchScope
    @Provides
    fun provideAlbumsRouter(): AlbumsRouter {
        return AlbumsRouter()
    }

    @SearchScope
    @Provides
    fun provideInteractor(
        requestData: HashMap<String, String>,
        request: Request<SearchArtistResponse, String>
    ): SearchInteractor {
        return SearchInteractorImpl(requestData, request)
    }

    @SearchScope
    @Provides
    fun provideSearchRequest(): Request<SearchArtistResponse, String> {
        return SearchArtistRequest()
    }

    @SearchScope
    @Provides
    fun provideRequestData(): HashMap<String, String> {
        return HashMap()
    }

}

