package com.caren.tvshowratingfinder.network

import com.squareup.moshi.Json

// https://api.tvmaze.com/singlesearch/shows?q=squid%20game
data class TvShowResponseObject(

    @Json(name = "name")
    val name: String?,

    @Json(name = "rating")
    val rating: TvShowResponseRatingObject,

    @Json(name = "summary")
    val summary: String,

    @Json(name = "image")
    val image: TvShowResponseImageObject,
)