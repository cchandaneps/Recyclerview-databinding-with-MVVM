package com.example.testapp.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.example.testapp.R;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class EventData implements Serializable {
    public int getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(int messageCode) {
        this.messageCode = messageCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @SerializedName("message_code")
    int messageCode;

    @SerializedName("message")
    String message;

    @SerializedName("response")
    List<Event> events;

    public class Event {
        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getEventFlyer() {
            return eventFlyer;
        }

        public void setEventFlyer(String eventFlyer) {
            this.eventFlyer = eventFlyer;
        }

        public String getEventName() {
            return eventName;
        }

        public void setEventName(String eventName) {
            this.eventName = eventName;
        }

        public String getEventVenue() {
            return eventVenue;
        }

        public void setEventVenue(String eventVenue) {
            this.eventVenue = eventVenue;
        }

        public String getFromAge() {
            return fromAge;
        }

        public void setFromAge(String fromAge) {
            this.fromAge = fromAge;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLong1() {
            return long1;
        }

        public void setLong1(String long1) {
            this.long1 = long1;
        }

        public String getPost_event_id() {
            return post_event_id;
        }

        public void setPost_event_id(String post_event_id) {
            this.post_event_id = post_event_id;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getStarTime() {
            return starTime;
        }

        public void setStarTime(String starTime) {
            this.starTime = starTime;
        }

        public String getToAge() {
            return toAge;
        }

        public void setToAge(String toAge) {
            this.toAge = toAge;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        @SerializedName("address")
        String address;

        @SerializedName("color")
        String color;

        @SerializedName("description")
        String description;

        @SerializedName("end_date")
        String endDate;

        @SerializedName("end_time")
        String endTime;

        @SerializedName("event_flyer")
        String eventFlyer;

        @SerializedName("event_name")
        String eventName;

        @SerializedName("event_venue")
        String eventVenue;

        @SerializedName("from_age")
        String fromAge;

        @SerializedName("lat")
        String lat;

        @SerializedName("long1")
        String long1;

        @SerializedName("post_event_id")
        String post_event_id;

        @SerializedName("start_date")
        String startDate;

        @SerializedName("start_time")
        String starTime;

        @SerializedName("to_age")
        String toAge;

        @SerializedName("user_id")
        String userId;


    }

    @BindingAdapter({ "image" })
    public static void loadImage(ImageView imageView, String imageURL) {
        Glide.with(imageView.getContext())
                .load(imageURL)
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView);
    }

}
