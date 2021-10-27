package com.caren.tvshowratingfinder.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.tvmaze.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val networkLoggingInterceptor =
    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .client(OkHttpClient.Builder().addInterceptor(networkLoggingInterceptor).build())
    .baseUrl(BASE_URL)
    .build()

interface TVMazeApiService {

    // https://api.tvmaze.com/singlesearch/shows?q=tvshowname
    @GET("singlesearch/shows")
    suspend fun getTvShow(@Query("q") showName: String): TvShowResponseObject

}

object TVMazeApi {
    val retrofitService: TVMazeApiService by
    lazy { retrofit.create(TVMazeApiService::class.java) }
}
