package com.example.tech_blog_aggregator.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TestServiceTest {

    @Test
    void sumTest() {
        int a = 3;
        int b = 5;

        final TestService testService = new TestService();
        final int sum = testService.sum(a, b);

        Assertions.assertThat(sum).isEqualTo(a + 2);
    }

}