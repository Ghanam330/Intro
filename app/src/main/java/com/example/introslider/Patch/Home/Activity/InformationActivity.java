package com.example.introslider.Patch.Home.Activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.introslider.Patch.Home.Adapter.InformationAdapter;
import com.example.introslider.Patch.Home.Model.Information;
import com.example.introslider.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class InformationActivity extends AppCompatActivity {
    ImageView imageView;
    TextView tv1;

    RecyclerView recyclerView;
    InformationAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.information_acttivty);
        imageView = findViewById(R.id.img_track);
        tv1 = findViewById(R.id.txt_track);
        tv1.setText(getIntent().getStringExtra("name"));


        recyclerView = findViewById(R.id.my_recycler_info);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<Information> options
                = new FirebaseRecyclerOptions.Builder<Information>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("FrontEnd"), Information.class)
                .build();

        adapter=new InformationAdapter(options,getApplicationContext());
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

}
