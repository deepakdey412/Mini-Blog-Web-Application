package com.deepak.mini_blog.dto;

import java.util.Date;

public class PostDto {

    private Integer postId;
    private String title;
    private String content;
    private String imageName;
    private Date createdDate;
    private UserDto user;      // User details included
    private CategoryDto category;  // Commented out for now

    // Default constructor
    public PostDto() {}

    // Parameterized constructor
    public PostDto(Integer postId, String title, String content, String imageName, Date createdDate, UserDto user/*, CategoryDto category*/) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.imageName = imageName;
        this.createdDate = createdDate;
        this.user = user;
        this.category = category;  // Commented out
    }

    // Getters & Setters
    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", imageName='" + imageName + '\'' +
                ", createdDate=" + createdDate +
                ", user=" + user +
                ", category=" + category +
                '}';
    }
}
