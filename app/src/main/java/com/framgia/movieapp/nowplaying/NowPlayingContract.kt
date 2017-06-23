package com.framgia.movieapp.nowplaying

import com.framgia.movieapp.base.BasePresenter
import com.framgia.movieapp.base.BaseView

/**
 * Created by FRAMGIA\pham.duc.nam on 23/06/2017.
 */

class NowPlayingContract {
  internal interface ViewModel : BaseView<Presenter>
  interface Presenter : BasePresenter
}
