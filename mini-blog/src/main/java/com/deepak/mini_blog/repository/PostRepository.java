package com.deepak.mini_blog.repository;

import com.deepak.mini_blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
