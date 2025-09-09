package com.deepak.mini_blog.dto;

import com.deepak.mini_blog.model.Post;

import java.util.ArrayList;
import java.util.List;

public class UserDto {

    private Integer userId;
    private String userName;
    private String userEmail;
    private String userAbout;
    private String userPassword;

    private List<Post> posts = new ArrayList<>();

    // Default constructor
    public UserDto() {}

    // Parameterized constructor
    public UserDto(Integer userId, String userName, String userEmail, String userAbout, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userAbout = userAbout;
        this.userPassword = userPassword;
    }

    // Getters and Setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAbout() {
        return userAbout;
    }

    public void setUserAbout(String userAbout) {
        this.userAbout = userAbout;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
