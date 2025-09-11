package com.deepak.mini_blog.service;

import com.deepak.mini_blog.dto.CategoryDto;
import com.deepak.mini_blog.model.Category;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto getAllCategory();
    CategoryDto getCategoryById( Integer categoryId);
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
    void deleteCategory( Integer categoryId);

}
