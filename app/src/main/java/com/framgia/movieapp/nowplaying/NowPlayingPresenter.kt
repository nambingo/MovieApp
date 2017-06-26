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
  private var mSubscription: CompositeSubscription? = null
  private val mNowView: NowPlayingContract.ViewModel? = null
  private val mPage = 1
  private var mText:String = ""

  init {
    mSubscription = CompositeSubscription()
  }

  fun getDataNowPlaying() {
    val subscription = mNowPlayingRepository.getNowPlaying(mPage)
        .subscribe(object : MovieSubscribe<NowPlaying>() {
          override fun onSuccess(`object`: NowPlaying) {
            Log.e("NowPlayingPresenter",
                "onSuccess(30) -----> " + `object`.results!![0].title!!)
            mText = `object`.results!!.get(0).title!!
            mNowView?.setText(mText)
          }

          override fun onError(error: BaseException) {
            Log.e("NowPlayingPresenter", "onError(36) -----> ")
          }
        })

    mSubscription?.add(subscription)
  }
}
