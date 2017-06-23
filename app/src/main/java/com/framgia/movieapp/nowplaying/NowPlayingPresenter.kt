package com.framgia.movieapp.nowplaying

import android.content.Context
import android.util.Log
import com.framgia.movieapp.model.NowPlaying
import com.framgia.movieapp.services.NowPlayingRepository
import com.framgia.movieapp.utils.BaseException
import com.framgia.movieapp.utils.MovieSubscribe
import rx.Subscription
import rx.subscriptions.CompositeSubscription

/**
 * Created by FRAMGIA\pham.duc.nam on 23/06/2017.
 */

class NowPlayingPresenter(private val mNowPlayingRepository: NowPlayingRepository) {
  private val mSubscription: CompositeSubscription
  private val mPage = 1

  init {
    mSubscription = CompositeSubscription()
  }

  fun getDataNowPlaying() {
    val subscription = mNowPlayingRepository.getNowPlaying(mPage)
        .subscribe(object : MovieSubscribe<NowPlaying>() {
          override fun onSuccess(`object`: NowPlaying) {
            Log.e("NowPlayingPresenter",
                "onSuccess(30) -----> " + `object`.results!![0].title!!)
          }

          override fun onError(error: BaseException) {
            Log.e("NowPlayingPresenter", "onError(36) -----> ")
          }
        })

    mSubscription.add(subscription)
  }
}
