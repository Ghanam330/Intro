package com.example.introslider.Article;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.introslider.Home.Home;
import com.example.introslider.Home.HomeRecyclerViewAdapter;
import com.example.introslider.R;

import java.util.ArrayList;
import java.util.List;


public class ArticleFragment extends Fragment {
    List<Home> articleList;
    HomeRecyclerViewAdapter articleViewAdapter;
    public ArticleFragment(){
        // Required empty public constructor
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home2,container,false);
    }// end onCreateView

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        articleList=new ArrayList<>();
        articleList.add(new Home(getString(R.string.webDeveloper),"date", R.drawable.web));
        RecyclerView recyclerView = view.findViewById(R.id.my_recycler_view);
        recyclerView.setAdapter(articleViewAdapter);
     HomeRecyclerViewAdapter myAdapter=new HomeRecyclerViewAdapter(requireContext(),articleList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(myAdapter);
    }// end onViewCreated
}// end class Fragment