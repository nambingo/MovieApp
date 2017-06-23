package com.framgia.movieapp.services

import com.framgia.movieapp.model.NowPlaying
import com.framgia.movieapp.utils.Constant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

/**
 * Created by FRAMGIA\pham.duc.nam on 23/06/2017.
 */

interface ApiServices {
  @GET("now_playing")
  fun loadNowPlaying(@Query("api_key") api_key: String,
      @Query("page") page: Int): Observable<NowPlaying>
}
