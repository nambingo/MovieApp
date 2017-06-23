package com.framgia.movieapp.services;

import com.framgia.movieapp.utils.Constant;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by FRAMGIA\pham.duc.nam on 23/06/2017.
 */

public class RequestHelper {
    private static final int CONNECTION_TIMEOUT = 30;

    public static ApiServices getRequestHeader() {
        return getRequest(Constant.URL_BASE);
    }

    public static ApiServices getRequest(String url) {
        HttpLoggingInterceptor logging = getHttpLoggingInterceptor();

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS);
        httpClient.readTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS);
        httpClient.addInterceptor(logging);

        Retrofit retrofit =
                new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(url)
                        .client(httpClient.build())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();
        return retrofit.create(ApiServices.class);
    }

    private static HttpLoggingInterceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(Constant.DEBUG ? HttpLoggingInterceptor.Level.BODY
                : HttpLoggingInterceptor.Level.NONE);
        return interceptor;
    }
}
