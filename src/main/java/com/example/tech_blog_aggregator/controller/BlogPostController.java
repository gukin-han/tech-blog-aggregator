package com.example.tech_blog_aggregator.controller;

import com.example.tech_blog_aggregator.controller.request.ScrapBlogPostRequest;
import com.example.tech_blog_aggregator.entity.BlogPost;
import com.example.tech_blog_aggregator.service.ScraperService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/blogPosts")
public class BlogPostController {

    private final ScraperService scraperService;

    @PostMapping("/scrape")
    public BlogPost scrapeBlogPost(@Valid @RequestBody ScrapBlogPostRequest request) throws IOException {
        final String url = request.getUrl();
        return scraperService.scrapeBlog(url);
    }
}
