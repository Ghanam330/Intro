package com.example.introslider.Home;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.GridLayoutManager;

import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.introslider.R;


import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    List<Home> homeList;
    HomeRecyclerViewAdapter homeRecyclerViewAdapter;

    public HomeFragment(){
        // Required empty public constructor
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeList = new ArrayList<>();
        homeList.add(new Home(getString(R.string.webDeveloper),"date",R.drawable.web));
        homeList.add(new Home(getString(R.string.web_designer),"date",R.drawable.web222));
        homeList.add(new Home(getString(R.string.MobileApplication),"date",  R.drawable.phone));
        homeList.add(new Home(getString(R.string.Iphone),"date",  R.drawable.iphone));
        homeList.add(new Home(getString(R.string.DesktopApplications),"date",  R.drawable.windows333));
        homeList.add(new Home(getString(R.string.Gaming),"date",R.drawable.gaming));
        RecyclerView recyclerView = view.findViewById(R.id.my_recycler_view);
        recyclerView.setAdapter(homeRecyclerViewAdapter);
        HomeRecyclerViewAdapter myAdapter = new HomeRecyclerViewAdapter(requireContext(), homeList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(myAdapter);


    }

}// end class







