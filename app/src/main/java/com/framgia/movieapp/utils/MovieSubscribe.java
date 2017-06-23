package com.framgia.movieapp.utils;

import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;

/**
 * Created by FRAMGIA\pham.duc.nam on 23/06/2017.
 */

public abstract class MovieSubscribe<T> extends Subscriber<T> {
    private T object;

    @Override
    public void onCompleted() {
        onRequestFinish();
        onSuccess(object);
    }

    @Override
    public void onError(Throwable e) {
        onRequestFinish();
        if (e instanceof BaseException) {
            onError((BaseException) e);
        } else {
            onError(BaseException.toUnexpectedError(e));
        }
    }

    @Override
    public void onNext(T t) {
        object = t;
    }

    public abstract void onSuccess(T object);

    public abstract void onError(BaseException error);

    /**
     * Runs after request complete or error
     **/
    public void onRequestFinish() {

    }
}
