package com.example.ppt.controller;

import com.example.ppt.Dto.ApiResponse;
import com.example.ppt.model.News;
import com.example.ppt.model.Support;
import com.example.ppt.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/v1/news")
@RestController
@RequiredArgsConstructor
public class NewsController {
    private final NewsService newsService;

    @GetMapping
    public ResponseEntity getNews() {
        return ResponseEntity.status(200).body(newsService.getNews());
    }

    @PostMapping("/addn")
    public ResponseEntity setNews(@RequestBody @Valid News news) {
        newsService.setNews(news);
        return ResponseEntity.status(201).body(new ApiResponse("news added", 201));

    }
    @GetMapping("/id")
    public ResponseEntity<News> getNewsById(@PathVariable @Valid Integer id){
        News news=newsService.getNewsById(id);
        return ResponseEntity.status(200).body(news);
    }
}