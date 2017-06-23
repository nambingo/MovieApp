package com.framgia.movieapp.utils

import android.content.Context
import com.framgia.movieapp.services.NowPlayingRemoteSource
import com.framgia.movieapp.services.NowPlayingRepository
import dagger.internal.Preconditions

/**
 * Created by FRAMGIA\pham.duc.nam on 23/06/2017.
 */

object Injection {

  fun provideNowPlaying(context: Context): NowPlayingRepository {
    Preconditions.checkNotNull(context)
    return NowPlayingRepository.getInstance(NowPlayingRemoteSource.instance)
  }
}
