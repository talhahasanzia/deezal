package com.talhahasanzia.deezal.app.tracks.api

import com.talhahasanzia.deezal.commons.network.BaseResponseDto
import java.io.Serializable

data class TrackListResponse(
    var data: List<Track>
) : BaseResponseDto(), Serializable

data class Track(
    var id: String
) : BaseResponseDto(), Serializable