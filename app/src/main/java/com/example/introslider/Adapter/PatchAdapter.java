package com.example.introslider.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.introslider.Activity.Informations;
import com.example.introslider.Model.Patch;
import com.example.introslider.R;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

public class PatchAdapter extends FirebaseRecyclerAdapter<Patch, PatchAdapter.MyViewHolder> {
    private FirebaseRecyclerOptions<Patch> options;

    public PatchAdapter(FirebaseRecyclerOptions<Patch> options) {
        super(options);
        this.options = options;

    }


    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull Patch model) {
        holder.txtMenuName.setText(model.getName());
        Picasso.get().load(model.getImage())
                .into(holder.imageMenu);

        PatchAdapter adapter;
        adapter = new PatchAdapter(options);
        holder.itemView.setOnClickListener(v -> {
            Intent patch=new Intent(v.getContext(), Informations.class);
         //  patch.putExtra("PatchId",adapter.getRef(position).getKey());
            holder.itemView.getContext().startActivity(patch);
        });
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.patch_item, parent, false);
        return new PatchAdapter.MyViewHolder(itemView);
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtMenuName;
        public ImageView imageMenu;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtMenuName = itemView.findViewById(R.id.title_patch);
            imageMenu = itemView.findViewById(R.id.image_patch);


        }//constructor
    }// end MyViewHolder
}//end class

