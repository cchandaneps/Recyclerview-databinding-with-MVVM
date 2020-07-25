package com.example.testapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.testapp.R;
import com.example.testapp.databinding.FragmentEventDetailBinding;
import com.example.testapp.model.EventData;
import com.example.testapp.viewmodel.EventViewModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class EventDetailFragment extends Fragment implements OnMapReadyCallback {

    FragmentEventDetailBinding binding;
    EventViewModel viewModel = new EventViewModel();
    EventData.Event mEvent;

    MapView mapView;
    GoogleMap map;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_detail, container, false);
        binding = FragmentEventDetailBinding.bind(view);
        mapView = binding.mapView;
        mapView.onCreate(savedInstanceState);


        mapView.getMapAsync(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = new ViewModelProvider(getActivity()).get(EventViewModel.class);
        viewModel.getEvent().observe(getViewLifecycleOwner(), new Observer<EventData.Event>() {
            @Override
            public void onChanged(EventData.Event event) {
                binding.setEvent(event);
                mEvent = event;
                LatLng latLng = new LatLng(Double.parseDouble(event.getLat()), Double.parseDouble(event.getLong1()));
                binding.setLatLong(latLng);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng latLng = new LatLng(Double.parseDouble(mEvent.getLat()), Double.parseDouble(mEvent.getLong1()));
        map = googleMap;
        map.addMarker(new MarkerOptions().position(latLng));
        map.setMinZoomPreference(12);
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        map.getUiSettings().setMyLocationButtonEnabled(false);
        map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }


    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}