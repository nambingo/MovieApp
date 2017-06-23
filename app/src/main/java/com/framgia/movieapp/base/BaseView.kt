package com.framgia.movieapp.base

/**
 * Created by FRAMGIA\pham.duc.nam on 23/06/2017.
 */

interface BaseView<T> {
  fun setPresenter(t: T)

  fun showLoading()

  fun hideLoading()
}
