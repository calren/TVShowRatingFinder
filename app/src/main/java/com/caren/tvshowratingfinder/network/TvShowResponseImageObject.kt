package com.caren.tvshowratingfinder.network

import com.squareup.moshi.Json

data class TvShowResponseImageObject(
    @Json(name = "medium")
    val imageUrl: String?
)