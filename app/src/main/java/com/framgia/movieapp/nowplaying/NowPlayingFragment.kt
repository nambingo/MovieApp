package com.framgia.movieapp.nowplaying

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.framgia.movieapp.R
import com.framgia.movieapp.model.NowPlaying
import com.framgia.movieapp.services.NowPlayingRepository
import com.framgia.movieapp.utils.BaseException
import com.framgia.movieapp.utils.Injection
import com.framgia.movieapp.utils.MovieSubscribe
import kotlinx.android.synthetic.main.fragment_now_playing.*
import rx.subscriptions.CompositeSubscription

/**
 * Created by FRAMGIA\pham.duc.nam on 23/06/2017.
 */

class NowPlayingFragment : Fragment(){
  private var mNowPlayingRepository: NowPlayingRepository? = null
  private var mSubscription: CompositeSubscription? = null
  private val mPage = 1

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

  }

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {

    mSubscription = CompositeSubscription()
    mNowPlayingRepository = Injection.provideNowPlaying(context)

    getDataNowPlaying()
    // Inflate the layout for this fragment
    return inflater!!.inflate(R.layout.fragment_now_playing, container, false)

  }

  fun getDataNowPlaying() {
    val subscription = mNowPlayingRepository!!.getNowPlaying(mPage)
        .subscribe(object : MovieSubscribe<NowPlaying>() {
          override fun onSuccess(`object`: NowPlaying) {
            Log.e("NowPlayingPresenter",
                "onSuccess(30) -----> " + `object`.results!![0].title!!)
            mTitle.text = `object`.results!![0].title
          }

          override fun onError(error: BaseException) {
            Log.e("NowPlayingPresenter", "onError(36) -----> ")
          }
        })

    mSubscription?.add(subscription)
  }
}
