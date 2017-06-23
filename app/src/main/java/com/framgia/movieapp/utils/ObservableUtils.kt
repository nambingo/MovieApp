package com.framgia.movieapp.utils

import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by FRAMGIA\pham.duc.nam on 23/06/2017.
 */

object ObservableUtils {

  fun <T> applyAsyncSchedulers(): Observable.Transformer<T, T> {
    return Observable.Transformer<T, T> { observable ->
      observable.subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
    }
  }

  fun <T> applySyncSchedulers(): Observable.Transformer<T, T> {
    return Observable.Transformer<T, T> { observable ->
      observable.subscribeOn(Schedulers.immediate())
          .observeOn(Schedulers.immediate())
    }
  }
}
