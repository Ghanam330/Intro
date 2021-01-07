package com.example.introslider.Patch.Home.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.introslider.Patch.Home.Model.Patch;
import com.example.introslider.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

public class PatchAdapter extends FirebaseRecyclerAdapter<Patch, PatchAdapter.MyViewHolder> {
    private FirebaseRecyclerOptions<Patch> options;
      // Context context;
    private OnPatchItemClickListener listener;

    public PatchAdapter(FirebaseRecyclerOptions<Patch> options, OnPatchItemClickListener listener) {
        super(options);
        this.options = options;
        this.listener = listener;


    }


    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull Patch model) {

        holder.txtMenuName.setText(model.getName());
        Picasso.get().load(model.getImage())
                .into(holder.imageMenu);


        holder.mView.setOnClickListener(v -> {
            listener.OnItemClick(position);







           /*
        Intent patch=new Intent(v.getContext(), InformationActivity.class);
     //  patch.putExtra("PatchId",adapter.getRef(position).getKey());

                Intent intent =new Intent(context, InformationActivity.class);
                intent.putExtra("name",model.getName());
              //  intent.putExtra("Image",model.getImage());
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

                 */
        });

    }

    public interface OnPatchItemClickListener {
        void OnItemClick(int position);
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
        View mView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            txtMenuName = itemView.findViewById(R.id.title_patch);
            imageMenu = itemView.findViewById(R.id.image_patch);


        }//constructor
    }// end MyViewHolder
}//end class

