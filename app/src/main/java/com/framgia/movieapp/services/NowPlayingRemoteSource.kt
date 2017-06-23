package com.framgia.movieapp.services

import com.framgia.movieapp.model.NowPlaying
import com.framgia.movieapp.utils.Constant
import com.framgia.movieapp.utils.ObservableUtils
import rx.Observable

/**
 * Created by FRAMGIA\pham.duc.nam on 23/06/2017.
 */

class NowPlayingRemoteSource {

  fun getNowLoading(page: Int): Observable<NowPlaying> {
    return RequestHelper.requestHeader
        .loadNowPlaying(Constant.API_KEY, page)
        .compose(ObservableUtils.applyAsyncSchedulers<NowPlaying>())
  }

  companion object {
    private var mInstance: NowPlayingRemoteSource? = null

    val instance: NowPlayingRemoteSource
      get() {
        if (mInstance == null) {
          mInstance = NowPlayingRemoteSource()
        }
        return mInstance as NowPlayingRemoteSource
      }
  }
}
