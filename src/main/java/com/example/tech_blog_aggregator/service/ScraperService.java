package com.example.tech_blog_aggregator.service;

import com.example.tech_blog_aggregator.entity.BlogPost;
import com.example.tech_blog_aggregator.repository.BlogPostRepository;
import lombok.AllArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ScraperService {

    public final BlogPostRepository blogPostRepository;

    public BlogPost scrapeBlog(String blogUrl) throws IOException{

        final Document doc = Jsoup.connect(blogUrl).get();

        String title = getTitle(doc);
        String content = getContent(doc);
        LocalDateTime publishedAt = LocalDateTime.now();

        final BlogPost post = BlogPost.builder()
                .url(blogUrl)
                .title(title)
                .content(content)
                .PublishedAt(publishedAt)
                .build();

        return blogPostRepository.save(post);
    }

    public String getContent(Document doc) {
        return doc.getElementsByClass("post-content-inner").text();
    }

    public String getTitle(Document doc) {
        Elements es = doc.getElementsByClass("post-header");
        Element e = es.get(0);
        Element h1 = e.getElementsByTag("h1").get(0);
        return h1.text();
    }
}
