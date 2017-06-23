package com.framgia.movieapp.nowplaying;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.framgia.movieapp.R;
import com.framgia.movieapp.nowplaying.NowPlayingPresenter;
import com.framgia.movieapp.utils.Injection;

/**
 * Created by FRAMGIA\pham.duc.nam on 23/06/2017.
 */

public class NowPlayingFragment extends Fragment implements NowPlayingContract.ViewModel{
    private NowPlayingPresenter mPresenter;

    public NowPlayingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        mPresenter = new NowPlayingPresenter(Injection.provideNowPlaying(getContext()));
        mPresenter.getDataNowPlaying();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_now_playing, container, false);

    }

    @Override
    public void setPresenter(NowPlayingContract.Presenter presenter) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
