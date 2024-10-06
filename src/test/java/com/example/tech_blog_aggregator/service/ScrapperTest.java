package com.example.tech_blog_aggregator.service;

import org.assertj.core.api.Assertions;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

class ScrapperTest {

    @Tag("integration")
    @Test
    @DisplayName("Woowahan 블로그 포스트의 날짜를 정확히 반환한다")
    void shouldReturnCorrectPublishedDateForWoowahanPost() throws IOException {
        //given
        String url = "https://techblog.woowahan.com/2527/";
        final Document doc = Jsoup.connect(url).get();

        //when
        final Scrapper woowahan = Scrapper.WOOWAHAN;
        final LocalDate publishedDate = woowahan.getPublishedDate(doc);

        //then
        Assertions.assertThat(publishedDate).isEqualTo(LocalDate.of(2017, 7, 10));
    }
}