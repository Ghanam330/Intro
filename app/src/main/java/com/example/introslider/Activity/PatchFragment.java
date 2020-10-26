package com.example.introslider.Activity;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.introslider.Adapter.PatchAdapter;
import com.example.introslider.Model.Patch;
import com.example.introslider.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;


public class PatchFragment extends Fragment {
private RecyclerView recyclerView;
PatchAdapter adapter;

    public PatchFragment(){
        // Required empty public constructor
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.patch_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.my_recycler_patch);

        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        FirebaseRecyclerOptions<Patch> options
                = new FirebaseRecyclerOptions.Builder<Patch>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Patch"), Patch.class)
                .build();


        adapter = new PatchAdapter(options);
        recyclerView.setAdapter(adapter);


    }
    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}// end class




/*
homeList.add(new Home(getString(R.string.webDeveloper),R.drawable.web));
        homeList.add(new Home(getString(R.string.web_designer),R.drawable.web222));
        homeList.add(new Home(getString(R.string.MobileApplication),  R.drawable.phone));
        homeList.add(new Home(getString(R.string.Iphone),  R.drawable.iphone));
        homeList.add(new Home(getString(R.string.DesktopApplications),  R.drawable.windows333));
        homeList.add(new Home(getString(R.string.Gaming),R.drawable.gaming));
 */


