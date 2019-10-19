package com.EzraSmithTambunan.smkcoding.connection


import com.EzraSmithTambunan.smkcoding.model.ResponseMovieModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieInterface {

    @GET("movie/now_playing")
    fun getListMovieNowPlaying(

        @Query("api_key")
        apiKey: String
    ): Observable<ResponseMovieModel>
}