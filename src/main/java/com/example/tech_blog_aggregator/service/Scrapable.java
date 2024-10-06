package com.example.tech_blog_aggregator.service;

import com.example.tech_blog_aggregator.entity.Post;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.time.LocalDate;

public interface Scrapable {

    default Post scrapePost(String url) {
        try {
            final Document doc = Jsoup.connect(url).get();
            final String title = getTitle(doc);
            final String content = getContent(doc);
            final LocalDate publishedDate = getPublishedDate(doc);

            return Post.builder()
                    .title(title)
                    .content(content)
                    .publishedAt(publishedDate)
                    .build();

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    String getTitle(Document doc);

    LocalDate getPublishedDate(Document doc);

    String getContent(Document doc);
}
