package com.framgia.movieapp.services;

import com.framgia.movieapp.model.NowPlaying;
import com.framgia.movieapp.utils.Constant;
import com.framgia.movieapp.utils.ObservableUtils;
import rx.Observable;

/**
 * Created by FRAMGIA\pham.duc.nam on 23/06/2017.
 */

public class NowPlayingRemoteSource {
    private static NowPlayingRemoteSource mInstance;

    public static NowPlayingRemoteSource getInstance() {
        if (mInstance == null) {
            mInstance = new NowPlayingRemoteSource();
        }
        return mInstance;
    }

    public Observable<NowPlaying> getNowLoading(int page) {
        return RequestHelper.getRequestHeader()
                .loadNowPlaying(Constant.API_KEY, page)
                .compose(ObservableUtils.<NowPlaying>applyAsyncSchedulers());
    }
}
