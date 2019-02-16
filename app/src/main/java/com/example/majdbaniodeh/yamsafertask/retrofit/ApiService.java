package com.example.majdbaniodeh.yamsafertask.retrofit;

import com.example.majdbaniodeh.yamsafertask.model.RootJsonResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("rates")
    Call<RootJsonResult> getResults(@Query("checkin_date") String checkDate,
                                    @Query("checkout_date") String checkOutDate,
                                    @Query("property_id") String propertyId,
                                    @Query("rooms") String rooms,
                                    @Query("adults") String adults,
                                    @Query("children") String children,
                                    @Query("children_ages") String childrenAges,
                                    @Query("api_key") String key,
                                    @Query("udid") String id,
                                    @Query("bundelId") String bundelId,
                                    @Query("version") String version

    );

}
