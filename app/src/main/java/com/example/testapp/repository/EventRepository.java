package com.example.testapp.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.testapp.model.EventData;
import com.example.testapp.util.ApiClient;
import com.example.testapp.util.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventRepository {

    private MutableLiveData<EventData> mEvents = new MutableLiveData<>();
    private ApiInterface apiInterface;

    public EventRepository() {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }

    public MutableLiveData<EventData> getEvents() {

        Call call = apiInterface.getEventList();
        call.enqueue(new Callback<EventData>() {
            @Override
            public void onResponse(Call<EventData> call, final Response<EventData> response) {
                mEvents.setValue(response.body());
            }

            @Override
            public void onFailure(Call<EventData> call, Throwable t) {
                Log.d("failure:", t.getMessage());
                call.cancel();
            }
        });
        return mEvents;
    }
}
