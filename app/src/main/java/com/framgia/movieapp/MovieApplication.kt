package com.framgia.movieapp

import android.app.Application

/**
 * Created by FRAMGIA\pham.duc.nam on 23/06/2017.
 */

class MovieApplication : Application() {

  override fun onCreate() {
    super.onCreate()
    instance = this
  }

  companion object {
    var instance: MovieApplication? = null
      private set
  }
}
