package com.prokkypew.sample;

import com.prokkypew.auster.MvpView;

/**
 * Created by alexander_roman on 25.07.16.
 */
public interface MainMvpView extends MvpView {
    void onIpLoaded(String text);
}
