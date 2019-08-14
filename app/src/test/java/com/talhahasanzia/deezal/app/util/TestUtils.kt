package com.talhahasanzia.deezal.app.util

import com.talhahasanzia.deezal.app.search.api.Artist
import com.talhahasanzia.deezal.app.search.api.SearchArtistResponse

object TestUtils {
    fun getDummyArtist(): Artist {
        return Artist(
            "1", "Two Door Cinema Club", "www.sample.com", "picture",
            "picture_small", "picture_medium", "picture_big", "picture_xl",
            1, 1, false, "tracklist", "artist"
        )
    }

    fun getDummySearchResponse(): SearchArtistResponse {
        return SearchArtistResponse(
            arrayListOf(
                getDummyArtist()
            ),
            1,
            ""
        )

    }
}