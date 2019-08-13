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

/*
* "id": "14346300",
      "title": "Campaign Speech",
      "link": "https://www.deezer.com/album/14346300",
      "cover": "https://api.deezer.com/album/14346300/image",
      "cover_small": "https://cdns-images.dzcdn.net/images/cover/0505b7f25dd3b52039cf279e6c7f2f0a/56x56-000000-80-0-0.jpg",
      "cover_medium": "https://cdns-images.dzcdn.net/images/cover/0505b7f25dd3b52039cf279e6c7f2f0a/250x250-000000-80-0-0.jpg",
      "cover_big": "https://cdns-images.dzcdn.net/images/cover/0505b7f25dd3b52039cf279e6c7f2f0a/500x500-000000-80-0-0.jpg",
      "cover_xl": "https://cdns-images.dzcdn.net/images/cover/0505b7f25dd3b52039cf279e6c7f2f0a/1000x1000-000000-80-0-0.jpg",
      "genre_id": 116,
      "fans": 7214,
      "release_date": "2016-10-19",
      "record_type": "single",
      "tracklist": "https://api.deezer.com/album/14346300/tracks",
      "explicit_lyrics": true,
      "type": "album"
* */