package com.framgia.movieapp.services

import com.framgia.movieapp.model.NowPlaying
import rx.Observable

/**
 * Created by FRAMGIA\pham.duc.nam on 23/06/2017.
 */

class NowPlayingRepository(private val mRemoteSource: NowPlayingRemoteSource?) {

  fun getNowPlaying(page: Int): Observable<NowPlaying> {
    return mRemoteSource!!.getNowLoading(page)
  }

  companion object {
    private var mInstance: NowPlayingRepository? = null

    fun getInstance(remoteSource: NowPlayingRemoteSource?): NowPlayingRepository {
      if (mInstance == null) {
        mInstance = NowPlayingRepository(remoteSource)
      }
      return mInstance as NowPlayingRepository
    }
  }
}
