package com.framgia.movieapp.nowplaying;

import android.content.Context;
import android.util.Log;
import com.framgia.movieapp.model.NowPlaying;
import com.framgia.movieapp.services.NowPlayingRepository;
import com.framgia.movieapp.utils.BaseException;
import com.framgia.movieapp.utils.MovieSubscribe;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by FRAMGIA\pham.duc.nam on 23/06/2017.
 */

public class NowPlayingPresenter {
    private CompositeSubscription mSubscription;
    private NowPlayingRepository mNowPlayingRepository;
    private int mPage = 1;

    public NowPlayingPresenter(NowPlayingRepository nowPlayingRepository) {
        this.mNowPlayingRepository = nowPlayingRepository;
        mSubscription = new CompositeSubscription();
    }

    public void getDataNowPlaying() {
        Subscription subscription = mNowPlayingRepository.getNowPlaying(mPage)
                .subscribe(new MovieSubscribe<NowPlaying>() {
                    @Override
                    public void onSuccess(NowPlaying object) {
                        Log.e("NowPlayingPresenter",
                                "onSuccess(30) -----> " + object.getResults().get(0).getTitle());
                    }

                    @Override
                    public void onError(BaseException error) {
                        Log.e("NowPlayingPresenter", "onError(36) -----> ");
                    }
                });

        mSubscription.add(subscription);
    }
}
