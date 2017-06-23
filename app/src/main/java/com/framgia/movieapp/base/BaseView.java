package com.framgia.movieapp.base;

/**
 * Created by FRAMGIA\pham.duc.nam on 23/06/2017.
 */

public interface BaseView<T> {
    void setPresenter(T t);

    void showLoading();

    void hideLoading();
}
