package com.framgia.movieapp.utils

import rx.Subscriber
import rx.Subscription
import rx.exceptions.Exceptions

/**
 * Created by FRAMGIA\pham.duc.nam on 23/06/2017.
 */

abstract class MovieSubscribe<T> : Subscriber<T>() {
  private var `object`: T? = null

  override fun onCompleted() {
    onRequestFinish()
    onSuccess(`object`!!)
  }

  override fun onError(e: Throwable) {
    onRequestFinish()
    if (e is BaseException) {
      onError(e)
    } else {
      onError(BaseException.toUnexpectedError(e))
    }
  }

  override fun onNext(t: T) {
    `object` = t
  }

  abstract fun onSuccess(`object`: T)

  abstract fun onError(error: BaseException)

  /**
   * Runs after request complete or error
   */
  fun onRequestFinish() {

  }
}
