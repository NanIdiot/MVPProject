package com.example.mvpproject.network;

import com.example.mvpproject.network.service.GoodService;

import java.net.HttpURLConnection;

import io.reactivex.rxjava3.internal.operators.observable.ObservableFilter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static volatile RetrofitClient mInstance;
    public static final String BASE_URL = "https://github.com/edu-lance/edu-lance.github.io";
    private Retrofit retrofit;

    private RetrofitClient() {
    }

    public static RetrofitClient getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitClient.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitClient();
                }
            }
        }
        return mInstance;
    }

    public <T> T getService(Class<T> cls){
        return getRetrofit().create(cls);
    }

    private Retrofit getRetrofit() {
        HttpURLConnection connection =
        if(retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build();
        }
        retrofit.create(GoodService)
        return null;
    }
}
