package com.example.introslider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.introslider.MainActivity;
import com.example.introslider.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ItemClickListener extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_click_listener);
    TextView textView=findViewById(R.id.textview);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            Intent intent = getIntent();
          String title=Objects.requireNonNull(Objects.requireNonNull(intent.getExtras().getString("title")));
          String Date=Objects.requireNonNull(Objects.requireNonNull(intent.getExtras().getString("date")));
          int image1=intent.getExtras().getInt("image");
          //String Date2=(Objects.requireNonNull(intent.getExtras()).getString("mohamed", "Ghanam"));
        textView.setText(Date);

    }
}