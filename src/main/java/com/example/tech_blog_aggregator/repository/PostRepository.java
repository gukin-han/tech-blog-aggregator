package com.example.tech_blog_aggregator.repository;

import com.example.tech_blog_aggregator.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
