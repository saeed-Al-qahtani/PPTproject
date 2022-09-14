package com.example.ppt.service;

import com.example.ppt.Repository.NewsRepository;
import com.example.ppt.exception.ApiException;
import com.example.ppt.model.News;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsService {
    private final NewsRepository newsRepository;
    public List<News> getNews(){
        return newsRepository.findAll();
    }

    public void setNews(News news) {
        newsRepository.save(news);
    }
    public News getNewsById(Integer id) {
        News news= newsRepository.findNewsById(id);
        if(news==null){
            throw new ApiException("Wrong user ID!");
        }
        return news;

    }
}
