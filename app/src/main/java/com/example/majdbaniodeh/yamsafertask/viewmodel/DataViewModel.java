package com.example.majdbaniodeh.yamsafertask.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.majdbaniodeh.yamsafertask.model.Accommodation;
import com.example.majdbaniodeh.yamsafertask.model.RootJsonResult;
import com.example.majdbaniodeh.yamsafertask.retrofit.ApiService;
import com.example.majdbaniodeh.yamsafertask.retrofit.RetrofitBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataViewModel {
    private static final String TAG = DataViewModel.class.getName();


    private MutableLiveData<ArrayList<Accommodation>> dataObservable;

    public DataViewModel() {

    }


    public MutableLiveData<ArrayList<Accommodation>> getDataObservable() {
        if (dataObservable == null) {
            dataObservable = new MutableLiveData<>();
            loadTheDataFromServer();
        }
        return dataObservable;
    }

    private void loadTheDataFromServer() {


        ApiService apiService = RetrofitBuilder.getResults();
        final Call<RootJsonResult> call = apiService.getResults("03/13/2019",
                "03/14/2019",
                "130737",
                "1",
                "2",
                "0",
                "0",
                "5c75aabcc20a33be13a4466f155d9c7c",
                "61777288",
                "me.yamsafer.Yamsafer",
                "2.2"


        );


        call.enqueue(new Callback<RootJsonResult>() {
            @Override
            public void onResponse(Call<RootJsonResult> call, Response<RootJsonResult> response) {
                if (response.isSuccessful()) {
                    RootJsonResult object = response.body();

                    dataObservable.setValue(object.getAccommodationList());
                }

            }

            @Override
            public void onFailure(Call<RootJsonResult> call, Throwable t) {
                Log.e(TAG, t.getMessage());

            }
        });

    }


}
