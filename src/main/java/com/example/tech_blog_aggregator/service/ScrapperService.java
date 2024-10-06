package com.example.tech_blog_aggregator.service;

import com.example.tech_blog_aggregator.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ScrapperService {

    public final PostRepository postRepository;

    public boolean scrapePost(String url) {

        return true;
    }

}
