package com.talhahasanzia.deezal.app.search.api

import com.talhahasanzia.deezal.commons.network.BaseResponseDto

data class SearchArtistResponse(
    var data: List<Data>,
    var total: Int,
    var next: String
) : BaseResponseDto()

data class Data(

    var id: String,

    var name: String,

    var link: String,

    var picture: String,

    var picture_small: String,

    var picture_medium: String,

    var picture_big: String,

    var picture_xl: String,

    var nb_album: Int,

    var nb_fan: Int,

    var radio: Boolean,

    var tracklist: String,

    var type: String

)