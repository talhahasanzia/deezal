package com.talhahasanzia.deezal.app.tracks.api

import com.talhahasanzia.deezal.commons.network.Urls
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface TracksAPI {
    @GET(Urls.TRACKS_BY_ALBUM)
    fun getTracksByAlbum(@Path("id") trackListId: String): Single<TrackListResponse>
}