package com.example.introslider.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.introslider.R;
import com.example.introslider.Model.SlideItem;

import java.util.List;

public class SlideAdaPeter extends RecyclerView.Adapter<SlideAdaPeter.OnboardingViewHolder> {
    private List<SlideItem> onboardingItems;

    public SlideAdaPeter(List<SlideItem> onboardingItems) {
        this.onboardingItems = onboardingItems;

    }  // end SlideAdaPter



    @NonNull
    @Override
    public OnboardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_contener, parent, false);
        return new OnboardingViewHolder(itemView);
    } // end  onCreateViewHolder

    @Override
    public void onBindViewHolder(@NonNull OnboardingViewHolder holder, int position) {
        holder.setOnboardingData(onboardingItems.get(position));
    }// end onBindViewHolder

    @Override
    public int getItemCount() {
        return onboardingItems != null ? onboardingItems.size() : 0;
         // return onboardingItems.size();
    } // end  getItemCount()

    public static class OnboardingViewHolder extends RecyclerView.ViewHolder {
        private TextView textTitle, textDescription;
        private ImageView imageOnboarding;

        public OnboardingViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDescription = itemView.findViewById(R.id.textDes);
            imageOnboarding = itemView.findViewById(R.id.img);
        }

        void setOnboardingData(SlideItem onboardingItem) {
            textTitle.setText(onboardingItem.getTitle());
            textDescription.setText(onboardingItem.getDescription());
            imageOnboarding.setImageResource(onboardingItem.getImage());
        }// end setOnboardingData
    }// end  OnboardingViewHolder
}// end class
