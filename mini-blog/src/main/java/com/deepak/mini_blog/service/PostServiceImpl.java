package com.deepak.mini_blog.service;

import com.deepak.mini_blog.dto.PostDto;
import com.deepak.mini_blog.model.Category;
import com.deepak.mini_blog.model.Post;
import com.deepak.mini_blog.model.User;
import com.deepak.mini_blog.repository.CategoryRepository;
import com.deepak.mini_blog.repository.PostRepository;
import com.deepak.mini_blog.repository.UserRepository;
import org.aspectj.weaver.ast.Literal;
import org.modelmapper.ModelMapper;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PostServiceImpl implements PostService {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    public PostServiceImpl(UserRepository userRepository, CategoryRepository categoryRepository, PostRepository postRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

        // 1️⃣ Fetch User
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));

        // 2️⃣ Fetch Category
        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + categoryId));

        // 3️⃣ Map PostDto to Post entity
        Post post = this.modelMapper.map(postDto, Post.class);

        // 4️⃣ Set additional fields
        post.setImageName("default.png");       // default image
        post.setCreatedDate(new Date());        // current date
        post.setUser(user);                     // set fetched user
        post.setCategory(category);             // set fetched category

        // 5️⃣ Save Post
        Post savedPost = this.postRepository.save(post);

        // 6️⃣ Map back to PostDto to return
        PostDto savedPostDto = this.modelMapper.map(savedPost, PostDto.class);

        return savedPostDto;
    }


    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {

        // 1️⃣ Fetch existing post
        Post foundPost = this.postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found with id: " + postId));

        // 2️⃣ Update fields (you can add null checks if needed)
        foundPost.setTitle(postDto.getTitle());
        foundPost.setContent(postDto.getContent());
        foundPost.setImageName(postDto.getImageName());

        // Optional: update category if present in DTO
        if (postDto.getCategory() != null) {
            Category category = this.categoryRepository.findById(postDto.getCategory().getCategoryId())
                    .orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + postDto.getCategory().getCategoryId()));
            foundPost.setCategory(category);
        }

        // 3️⃣ Save updated post
        Post updatedPost = this.postRepository.save(foundPost);

        // 4️⃣ Map to DTO and return
        return this.modelMapper.map(updatedPost, PostDto.class);
    }


    @Override
    public void deletePost(Integer postId) {
        Post foundPost = this.postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("Post not found by this id " + postId));
        postRepository.delete(foundPost);
    }

    @Override
    public PostDto getPostById(Integer postId) {
        Post post = this.postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("Post not found by this id " + postId));
        PostDto foundPost = this.modelMapper.map(post, PostDto.class);
        return foundPost;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> listPost = this.postRepository.findAll();

        // Map each Post entity to PostDto
        return listPost.stream()
                .map(post -> this.modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList()); // Use toList() if you want a modifiable list
    }

}
