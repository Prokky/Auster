package com.prokkypew.auster.utils;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.prokkypew.auster.MvpActivity;
import com.prokkypew.auster.MvpView;

public class TestActivity extends MvpActivity<TestPresenter> implements MvpView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @NonNull
    @Override
    protected TestPresenter getPresenter() {
        return new TestPresenter();
    }

    @Override
    public void onError(int errorCode, String errorText) {
        Toast.makeText(this, errorText, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setProgress(boolean visible) {

    }
}
