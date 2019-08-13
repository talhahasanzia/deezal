package com.talhahasanzia.deezal.app.albums.api

import com.talhahasanzia.deezal.commons.network.BaseResponseDto
import java.io.Serializable

data class AlbumsResponse(
    var data: List<Album>,
    var total: Int,
    var next: String
) : BaseResponseDto(), Serializable

data class Album(
    var id: String,
    var title: String,
    var link: String,
    var cover: String,
    var cover_small: String,
    var cover_medium: String,
    var cover_big: String,
    var cover_xl: String,
    var genre_id: Int,
    var fans: Int,
    var release_date: String,
    var record_type: String,
    var track_list: String,
    var explicit_lyrics: String,
    var type: String
) : Serializable