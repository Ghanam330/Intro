package com.example.introslider.Chat;

import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.introslider.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class ChatAdapter extends FirebaseRecyclerAdapter<ChatMessage, ChatAdapter.MyViewHolder> {
    private FirebaseRecyclerOptions<ChatMessage> options;

    public ChatAdapter(FirebaseRecyclerOptions<ChatMessage> options) {
        super(options);
        this.options = options;

    }


    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull ChatMessage model) {
      holder.messageText.setText(model.getMessageText());
       holder.messageUser.setText(model.getMessageUser());
       holder. // Format the date before showing it
               messageTime.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)",
               model.getMessageTime()));

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chat_item, parent, false);
        return new ChatAdapter.MyViewHolder(itemView);
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView messageText;
        TextView messageUser;
        TextView messageTime;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
             messageText = (TextView)itemView.findViewById(R.id.message_text);
           messageUser = (TextView)itemView.findViewById(R.id.message_user);
           messageTime = (TextView)itemView.findViewById(R.id.message_time);

        }//constructor
    }// end MyViewHolder
}//end class

