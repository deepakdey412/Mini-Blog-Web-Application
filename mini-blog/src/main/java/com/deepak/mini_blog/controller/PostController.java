package com.deepak.mini_blog.controller;

import com.deepak.mini_blog.dto.PostDto;
import com.deepak.mini_blog.model.Category;
import com.deepak.mini_blog.model.User;
import com.deepak.mini_blog.service.PostServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostServiceImpl postService;

    public PostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @PostMapping("/users/{userId}/categories/{categoryId}")
    public ResponseEntity<PostDto> createPost(
            @RequestBody PostDto postDto,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId) {

        PostDto createdPost = this.postService.createPost(postDto, userId, categoryId);

        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @PutMapping("/users/{userId}/categories/{categoryId}")

}
