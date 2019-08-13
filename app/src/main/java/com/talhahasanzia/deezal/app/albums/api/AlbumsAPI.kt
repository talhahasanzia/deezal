package com.talhahasanzia.deezal.app.albums.api

import com.talhahasanzia.deezal.commons.network.Urls
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface AlbumsAPI {
    @GET(Urls.ALBUMS_BY_ARTIST)
    fun getArtistAlbums(@Path("id") id: String): Single<AlbumsResponse>
}