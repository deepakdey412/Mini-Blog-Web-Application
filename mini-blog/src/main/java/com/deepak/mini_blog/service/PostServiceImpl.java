package com.deepak.mini_blog.service;

import com.deepak.mini_blog.dto.PostDto;

import java.util.List;

public class PostServiceImpl implements PostService{

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        return null;
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public PostDto getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<PostDto> getAllPosts() {
        return List.of();
    }
}
