package com.example.introslider.Home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.introslider.ItemClickListener;
import com.example.introslider.R;


import java.util.List;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.MyViewHolder> {
    private Context mContext;
    private List<Home> mDate;



    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_Home_Title;
        ImageView img_Home;
        CardView cardView;

        public MyViewHolder(@NonNull View View) {
            super(View);
            tv_Home_Title = View.findViewById(R.id.text_title);
            img_Home = View.findViewById(R.id.img_home);
            cardView = View.findViewById(R.id.card_view);
        }//constructor
    }// end MyViewHolder

    public HomeRecyclerViewAdapter(Context context, List<Home> mDate) {
        this.mContext = context;
        this.mDate = mDate;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_cardview, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        final Home home= mDate.get(position);
        holder.tv_Home_Title.setText(home.getTitle());
        holder.img_Home.setImageResource(home.getImage());


        // set click listener
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), ItemClickListener.class);
               // intent.putExtra("Book",mDate.get(position).toString());
               // intent.putExtra("title",mDate.get(position).getTitle());
               //intent.putExtra("image",mDate.get(position).getImage());
                intent.putExtra("date",mDate.get(position).getDate());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDate != null ? mDate.size() : 0;
      //  ruretn mDate.size();
    }


}// end class
