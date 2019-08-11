package com.talhahasanzia.deezal.app.search.api

import com.talhahasanzia.deezal.commons.network.Urls
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchAPI {
    @GET(Urls.SEARCH_ARTIST)
    fun getArtistBySearch(@Query("q") query : String) : Single<SearchArtistResponse>
}