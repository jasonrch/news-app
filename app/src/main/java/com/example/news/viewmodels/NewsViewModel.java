package com.example.news.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.news.models.NewsResponse;
import com.example.news.repositories.NewsRepository;


public class NewsViewModel extends ViewModel {
    private NewsRepository newsRepository;

    public NewsViewModel() {
        newsRepository = new NewsRepository();
    }

    public LiveData<NewsResponse> getTopNewsData(String country, String key) {
        return newsRepository.getTopNews(country, key);
    }

    public LiveData<NewsResponse> getNewsByWordData(String country, String key) {
        return newsRepository.getNewsByWord(country, key);
    }
}
