package com.framgia.movieapp.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import com.framgia.movieapp.services.NowPlayingRemoteSource;
import com.framgia.movieapp.services.NowPlayingRepository;
import dagger.internal.Preconditions;

/**
 * Created by FRAMGIA\pham.duc.nam on 23/06/2017.
 */

public class Injection {

    public static NowPlayingRepository provideNowPlaying(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        return NowPlayingRepository.getInstance(NowPlayingRemoteSource.getInstance());
    }
}
