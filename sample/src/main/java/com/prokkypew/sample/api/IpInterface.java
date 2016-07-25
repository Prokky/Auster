package com.prokkypew.sample.api;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by alexander_roman on 25.07.16.
 */
public interface IpInterface {
    @GET("/json")
    Call<IpObject> getIp();
}
