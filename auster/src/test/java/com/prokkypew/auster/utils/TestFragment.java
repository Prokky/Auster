package com.prokkypew.auster.utils;

import android.support.annotation.NonNull;

import com.prokkypew.auster.MvpFragment;
import com.prokkypew.auster.MvpView;

public class TestFragment extends MvpFragment<TestPresenter> implements MvpView {

    @NonNull
    @Override
    protected TestPresenter getPresenter() {
        return new TestPresenter();
    }

    @Override
    public void onError(int errorCode, String errorText) {

    }

    @Override
    public void setProgress(boolean visible) {

    }
}
