package com.deepak.mini_blog.service;

import com.deepak.mini_blog.dto.CategoryDto;
import com.deepak.mini_blog.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    List<CategoryDto> getAllCategory();
    CategoryDto getCategoryById( Integer categoryId);
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
    void deleteCategory( Integer categoryId);

}
