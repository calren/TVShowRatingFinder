package com.caren.tvshowratingfinder.network

import com.squareup.moshi.Json

data class TvShowResponseRatingObject(

    @Json(name = "average")
    val ratingScore: Int?

)