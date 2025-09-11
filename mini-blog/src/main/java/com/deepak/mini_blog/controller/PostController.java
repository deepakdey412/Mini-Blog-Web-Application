package com.deepak.mini_blog.controller;

import com.deepak.mini_blog.dto.PostDto;
import com.deepak.mini_blog.model.Category;
import com.deepak.mini_blog.model.Post;
import com.deepak.mini_blog.model.User;
import com.deepak.mini_blog.service.PostService;
import com.deepak.mini_blog.service.PostServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }


    // ===== Create a post =====
    @PostMapping("/users/{userId}/categories/{categoryId}")
    public ResponseEntity<PostDto> createPost(
            @RequestBody PostDto postDto,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId) {

        PostDto createdPost = this.postService.createPost(postDto, userId, categoryId);

        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }
    // ===== Get all posts =====
    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts() {
        List<PostDto> posts = this.postService.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    // ===== Get a post by ID =====
    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId) {
        PostDto postDto = this.postService.getPostById(postId);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }


    // ===== Update a post =====
    @PutMapping("/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,
                                              @PathVariable Integer postId){
        PostDto updatedPost = this.postService.updatePost(postDto,postId);
        return ResponseEntity.ok(updatedPost);
    }

    // ===== Delete a post =====
    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Integer postId) {
        this.postService.deletePost(postId);
        return new ResponseEntity<>("Post deleted successfully with ID: " + postId, HttpStatus.OK);
    }

}
