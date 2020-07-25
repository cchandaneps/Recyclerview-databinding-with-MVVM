package com.example.testapp.util;

import com.example.testapp.model.EventData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("api_get_all_events.php")
    Call<EventData> getEventList(@Query("results") String result);
}