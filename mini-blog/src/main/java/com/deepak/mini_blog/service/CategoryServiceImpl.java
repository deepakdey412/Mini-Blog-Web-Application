package com.deepak.mini_blog.service;

import com.deepak.mini_blog.dto.CategoryDto;
import com.deepak.mini_blog.model.Category;
import com.deepak.mini_blog.repository.CategoryRepository;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category newCategory = this.modelMapper.map(categoryDto,Category.class);
        Category savedCategory  = this.categoryRepository.save(newCategory);
        return this.modelMapper.map(savedCategory, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categoryList = this.categoryRepository.findAll();

        // Map each Category entity to CategoryDto
        return categoryList.stream()
                .map(cat -> this.modelMapper.map(cat, CategoryDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public CategoryDto getCategoryById(Integer categoryId) {
        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + categoryId));

        return this.modelMapper.map(category, CategoryDto.class);
    }


    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {

        // 1️⃣ Fetch the category by ID
        Category foundCategory = this.categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + categoryId));

        // 2️⃣ Update fields
        foundCategory.setCategoryTitle(categoryDto.getCategoryTitle());
        foundCategory.setCategoryDescription(categoryDto.getCategoryDescription());

        // 3️⃣ Save updated category
        Category savedCategory = this.categoryRepository.save(foundCategory);

        // 4️⃣ Map to DTO and return
        return this.modelMapper.map(savedCategory, CategoryDto.class);
    }


    @Override
    public void deleteCategory(Integer categoryId) {
        // 1️⃣ Check if the category exists
        Category foundCategory = this.categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + categoryId));

        // 2️⃣ Delete the category
        this.categoryRepository.delete(foundCategory);
    }

}
