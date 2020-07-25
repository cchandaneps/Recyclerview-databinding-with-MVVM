package com.example.testapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.testapp.model.EventData;
import com.example.testapp.repository.EventRepository;

public class EventViewModel extends ViewModel {

    private EventRepository mEventRepository = new EventRepository();

    private MutableLiveData<EventData.Event> eventMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<EventData> eventDataMutableLiveData = new MutableLiveData<>();

    public LiveData<EventData> getEvents() {
        eventDataMutableLiveData = mEventRepository.getEvents();
        return eventDataMutableLiveData;
    }

    public LiveData<EventData.Event> getEvent() {
        return this.eventMutableLiveData;
    }

    public void setEvent(int position) {
        EventData.Event event = this.eventDataMutableLiveData.getValue().getEvents().get(position);
        eventMutableLiveData.setValue(event);
    }
}
