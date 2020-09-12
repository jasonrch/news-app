package com.example.news.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news.R;
import com.example.news.adapters.NewsAdapter;
import com.example.news.models.Article;
import com.example.news.util.Constants;
import com.example.news.viewmodels.NewsViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private NewsAdapter mRecyclerAdapter;
    private NewsViewModel mNewsViewModel;
    private List<Article> mArticles = new ArrayList<>();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initWidgets(view);
        initRecyclerView(view);
        updateData();
    }

    private void initWidgets(View view) {
        mNewsViewModel = new NewsViewModel();
        mRecyclerView = view.findViewById(R.id.top_news_recycler);
    }

    private void initRecyclerView(View view) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mRecyclerAdapter = new NewsAdapter(view.getContext(), mArticles);
        mRecyclerView.setAdapter(mRecyclerAdapter);
    }

    private void updateData() {
        mNewsViewModel.getTopNewsData(Constants.COUNTRY_US, Constants.API_KEY).observe(getViewLifecycleOwner(), newsResponse -> {
            mArticles.clear();
            mArticles.addAll(newsResponse.getArticles());
            mRecyclerAdapter.notifyDataSetChanged();
        });
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}