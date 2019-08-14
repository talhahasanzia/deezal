package com.talhahasanzia.deezal.app.util

import com.talhahasanzia.deezal.app.albums.api.Album
import com.talhahasanzia.deezal.app.albums.api.AlbumsResponse
import com.talhahasanzia.deezal.app.search.api.Artist
import com.talhahasanzia.deezal.app.search.api.SearchArtistResponse
import com.talhahasanzia.deezal.app.tracks.api.Track
import com.talhahasanzia.deezal.app.tracks.api.TrackListResponse

// I have created a library which does this thing by annotation
// but this is a test so I wasnt sure if it was right thing to do,
// library does this dummy values generation for us and save boiler plate
// library link: https://github.com/talhahasanzia/pojo-booster
object TestUtils {
    fun getDummyArtist(): Artist {
        return Artist(
            "1", "Two Door Cinema Club", "www.sample.com", "picture",
            "picture_small", "picture_medium", "picture_big", "picture_xl",
            1, 1, false, "track_list", "artist"
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

    fun getDummyAlbumResponse(): AlbumsResponse {
        return AlbumsResponse(
            arrayListOf(getDummyAlbum()),
            1,
            ""
        )
    }

    fun getDummyAlbum(): Album {
        return Album(
            "22",
            "some album",
            "www.sample.com",
            "cover",
            "cover",
            "cover",
            "cover",
            "cover",
            27,
            399,
            "12-12-2012",
            "album",
            "track_list",
            "false",
            "album"
        )
    }

    fun getDummyTracksResponse(): TrackListResponse {
        return TrackListResponse(
            arrayListOf(getDummyTrack())
        )
    }

    fun getDummyTrack(): Track {
        return Track(
            "344",
            "Somewhere I belong",
            1,
            1,
            getDummyArtist()
        )
    }

}