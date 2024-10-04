package com.example.tech_blog_aggregator.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestServiceTest {

    @Test
    @DisplayName("두 정수의 합을 반환한다")
    void sumTest() {
        int a = 3;
        int b = 5;

        final TestService testService = new TestService();
        final int sum = testService.sum(a, b);

        Assertions.assertThat(sum).isEqualTo(a + 2);
    }

}