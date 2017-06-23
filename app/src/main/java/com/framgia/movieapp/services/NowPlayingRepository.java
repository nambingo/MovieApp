package com.framgia.movieapp.services;

import android.support.annotation.Nullable;
import com.framgia.movieapp.model.NowPlaying;
import rx.Observable;

/**
 * Created by FRAMGIA\pham.duc.nam on 23/06/2017.
 */

public class NowPlayingRepository {
    @Nullable
    private final NowPlayingRemoteSource mRemoteSource;
    private static NowPlayingRepository mInstance;

    public NowPlayingRepository(NowPlayingRemoteSource remoteSource) {
        mRemoteSource = remoteSource;
    }

    public static NowPlayingRepository getInstance(@Nullable NowPlayingRemoteSource remoteSource) {
        if (mInstance == null) {
            mInstance = new NowPlayingRepository(remoteSource);
        }
        return mInstance;
    }

    public Observable<NowPlaying> getNowPlaying(int page) {
        return mRemoteSource.getNowLoading(page);
    }
}
