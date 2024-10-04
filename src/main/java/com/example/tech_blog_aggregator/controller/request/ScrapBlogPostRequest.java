package com.example.tech_blog_aggregator.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ScrapBlogPostRequest {

    @NotBlank
    private String url;
}
