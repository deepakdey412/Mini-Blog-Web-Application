package com.deepak.mini_blog.repository;

import com.deepak.mini_blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category , Integer> {
}
