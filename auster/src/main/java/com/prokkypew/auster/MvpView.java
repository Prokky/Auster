package com.prokkypew.auster;

/**
 * Created by alexander_roman on 30.05.16.
 */
public interface MvpView {
    void onError(int errorCode, String errorText);

    void setProgress(boolean visible);
}
