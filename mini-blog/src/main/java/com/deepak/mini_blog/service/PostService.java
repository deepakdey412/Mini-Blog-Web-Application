package com.deepak.mini_blog.service;

import com.deepak.mini_blog.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    PostDto createPost(PostDto postDto , Integer userId , Integer categoryId);
    PostDto updatePost( PostDto postDto, Integer postId);
    void deletePost(Integer postId);
    PostDto getPostById(Integer postId);
    List<PostDto> getAllPosts();
}
