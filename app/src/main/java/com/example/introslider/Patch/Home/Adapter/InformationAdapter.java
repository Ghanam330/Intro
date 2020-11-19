package com.example.introslider.Patch.Home.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.introslider.Patch.Home.Model.Information;
import com.example.introslider.R;
import com.example.introslider.WebViewActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class InformationAdapter extends FirebaseRecyclerAdapter<Information, InformationAdapter.MyViewHolder> {
    private FirebaseRecyclerOptions<Information> options;

    private OnInformationClickListener listener;
    Context context;

    public InformationAdapter(FirebaseRecyclerOptions<Information> options, Context context) {
        super(options);
        this.options = options;
        this.context = context;


    }


    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull Information model) {
        holder.textContent.setText(model.getContent());
        holder.textName.setText(model.getName());
        // holder.textUrl.setText(model.getUrl());

        holder.textUrl.setText("Url");
        holder.textUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String url = model.getUrl();
                Intent intent = new Intent(context, WebViewActivity.class);
                intent.putExtra("id", url);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });

    }


    public interface OnInformationClickListener {
        void OnItemClick(int position);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.designer_layout, parent, false);
        return new InformationAdapter.MyViewHolder(itemView);
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textContent;
        TextView textName;
        TextView textUrl;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textContent = itemView.findViewById(R.id.txt_blue);
            textName = itemView.findViewById(R.id.txt_black);
            textUrl = itemView.findViewById(R.id.txt_url);

        }//constructor
    }// end MyViewHolder
}//end class

