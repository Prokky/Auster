package com.prokkypew.sample;

import com.prokkypew.auster.MvpPresenter;
import com.prokkypew.sample.api.IpApi;
import com.prokkypew.sample.api.IpObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by alexander_roman on 25.07.16.
 */
public class MainMvpPresenter extends MvpPresenter<MainMvpView> {
    public MainMvpPresenter() {

    }

    public void loadIp() {
        checkViewAttached();
        getMvpView().setProgress(true);
        IpApi.getApi().getIp().enqueue(new Callback<IpObject>() {
            @Override
            public void onResponse(Call<IpObject> call, Response<IpObject> response) {
                checkViewAttached();
                getMvpView().setProgress(false);
                getMvpView().onIpLoaded(response.body().getText());
            }

            @Override
            public void onFailure(Call<IpObject> call, Throwable t) {
                checkViewAttached();
                getMvpView().setProgress(false);
                getMvpView().onError(0, t.getLocalizedMessage());
            }
        });
    }
}
