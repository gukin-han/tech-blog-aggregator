package com.example.tech_blog_aggregator.repository;

import com.example.tech_blog_aggregator.entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}
