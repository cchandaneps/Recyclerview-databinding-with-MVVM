package com.example.testapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.R;
import com.example.testapp.adapter.EventRecyclerAdapter;
import com.example.testapp.databinding.FragmentEventListBinding;
import com.example.testapp.model.EventData;
import com.example.testapp.viewmodel.EventViewModel;


public class EventListFragment extends Fragment implements EventRecyclerAdapter.OnItemClickListener {

    EventViewModel viewModel = new EventViewModel();
    FragmentEventListBinding binding;
    EventData mEventData;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_list, container, false);
        binding = FragmentEventListBinding.bind(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = new ViewModelProvider(getActivity()).get(EventViewModel.class);
        viewModel.getEvents().observe(getViewLifecycleOwner(), new Observer<EventData>() {
            @Override
            public void onChanged(EventData eventData) {
                mEventData = eventData;
                updateUI(eventData);
            }
        });
    }

    private void updateUI(EventData eventData) {
        RecyclerView recyclerView = binding.recyclerEvents;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        EventRecyclerAdapter eventRecyclerAdapter = new EventRecyclerAdapter(eventData.getEvents(), this);
        recyclerView.setAdapter(eventRecyclerAdapter);
        eventRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {
        viewModel.setEvent(position);
        NavHostFragment.findNavController(this).navigate(R.id.action_eventListFragment_to_eventDetailFragment);
    }
}