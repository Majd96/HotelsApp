package com.example.majdbaniodeh.yamsafertask.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {

    private static ApiService apiService;

    public static ApiService getResults() {
        Gson gson = new GsonBuilder().create();
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

        apiService = new Retrofit.Builder()
                .baseUrl("https://api.yamsafer.me/en/api/v3/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .callFactory(httpClientBuilder.build())
                .build().create(ApiService.class);

        return apiService;

    }
}
