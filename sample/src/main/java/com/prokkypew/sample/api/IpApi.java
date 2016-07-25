package com.prokkypew.sample.api;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alexander_roman on 25.07.16.
 */
public class IpApi {
    private static IpInterface mApi;
    private final static String URL = "http://ip-api.com";

    public static IpInterface getApi() {
        if (mApi == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build();
            Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                    .baseUrl(URL)
                    .client(client)
                    .build();
            mApi = retrofit.create(IpInterface.class);
        }
        return mApi;
    }

    private static OkHttpClient createOk() {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }
}
