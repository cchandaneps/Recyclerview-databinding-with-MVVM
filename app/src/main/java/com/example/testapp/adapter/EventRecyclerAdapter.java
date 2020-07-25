package com.example.testapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.R;
import com.example.testapp.databinding.RecyclerEventListBinding;
import com.example.testapp.model.EventData;

import java.util.List;

public class EventRecyclerAdapter extends RecyclerView.Adapter<EventRecyclerAdapter.EventViewHolder> {

    private List<EventData.Event> events;
    OnItemClickListener onItemClickListener;

    public EventRecyclerAdapter(List<EventData.Event> events, OnItemClickListener onItemClickListener) {
        this.events = events;
        this.onItemClickListener=onItemClickListener;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerEventListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.recycler_event_list, parent, false);
        return new EventViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, final int position) {
        holder.recyclerEventListBinding.setEvent(this.events.get(position));
        holder.recyclerEventListBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    class EventViewHolder extends RecyclerView.ViewHolder {

        private RecyclerEventListBinding recyclerEventListBinding;

        public EventViewHolder(RecyclerEventListBinding recyclerEventListBinding) {
            super(recyclerEventListBinding.getRoot());
            this.recyclerEventListBinding = recyclerEventListBinding;
        }
    }

    public interface OnItemClickListener{
        public void onItemClick(int position);
    }
}
