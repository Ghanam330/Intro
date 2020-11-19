package com.example.introslider.Patch.Home.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.introslider.Patch.Home.Adapter.PatchAdapter;
import com.example.introslider.Patch.Home.Model.Patch;
import com.example.introslider.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;


public class PatchFragment extends Fragment {
    private RecyclerView recyclerView;
    PatchAdapter adapter;
    String id;
    Patch patch1;
    public PatchFragment() {
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

        if (getActivity().getIntent()!=null){
            id=getActivity().getIntent().getStringExtra("id");
        }

        recyclerView = view.findViewById(R.id.my_recycler_patch);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        FirebaseRecyclerOptions<Patch> options
                = new FirebaseRecyclerOptions.Builder<Patch>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Patch"), Patch.class)
                .build();



        adapter = new PatchAdapter(options, new PatchAdapter.OnPatchItemClickListener() {
            @Override
            public void OnItemClick(int position) {

                Intent patch=new Intent(getContext(), InformationActivity.class);
                startActivity(patch);


            }
        });


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



