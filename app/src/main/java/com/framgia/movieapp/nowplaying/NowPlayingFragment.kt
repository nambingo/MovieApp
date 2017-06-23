package com.framgia.movieapp.nowplaying

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.framgia.movieapp.R
import com.framgia.movieapp.nowplaying.NowPlayingPresenter
import com.framgia.movieapp.utils.Injection

/**
 * Created by FRAMGIA\pham.duc.nam on 23/06/2017.
 */

class NowPlayingFragment : Fragment(), NowPlayingContract.ViewModel {
  private var mPresenter: NowPlayingPresenter? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

  }

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {

    mPresenter = NowPlayingPresenter(Injection.provideNowPlaying(context))
    mPresenter!!.getDataNowPlaying()
    // Inflate the layout for this fragment
    return inflater!!.inflate(R.layout.fragment_now_playing, container, false)

  }

  override fun setPresenter(presenter: NowPlayingContract.Presenter) {

  }

  override fun showLoading() {

  }

  override fun hideLoading() {

  }
}// Required empty public constructor
