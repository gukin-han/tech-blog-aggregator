package com.example.tech_blog_aggregator.service;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public enum Scrapper implements Scrapable {

    WOOWAHAN("techblog.woowahan.com") {
        @Override
        public String getTitle(Document doc) {
            Elements es = doc.getElementsByClass("post-header");
            Element e = es.get(0);
            Element h1 = e.getElementsByTag("h1").get(0);
            return h1.text();
        }

        @Override
        public LocalDate getPublishedDate(Document doc) {
            final Elements elementsByClass = doc.getElementsByClass("post-header-author");
            final Elements elementsByTag = elementsByClass.get(0).getElementsByTag("span");
            final Element element = elementsByTag.get(0);
            final String scrappedDate = element.text();
            return LocalDate.parse(scrappedDate, DateTimeFormatter.ofPattern("MMM.d.uuuu"));
        }

        @Override
        public String getContent(Document doc) {
            return doc.getElementsByClass("post-content-inner").text();
        }
    }
    ,
    NETFLIX("netflixtechblog.com") {
        @Override
        public String getTitle(Document doc) {
            return null;
        }

        @Override
        public LocalDate getPublishedDate(Document doc) {
            return null;
        }

        @Override
        public String getContent(Document doc) {
            return null;
        }
    };

    private final String domain;


    Scrapper(String domain) {
        this.domain = domain;
    }
}
