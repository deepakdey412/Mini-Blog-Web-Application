import { api1 } from "./api";

// ===== Create a new post =====
export const createPost = (post, userId, categoryId) => {
    return api1.post(`/users/${userId}/categories/${categoryId}`, post);
};

// ===== Get all posts =====
export const getAllPosts = () => {
    return api1.get("/");
};

// ===== Get a post by ID =====
export const getPostById = (postId) => {
    return api1.get(`/${postId}`);
};

// ===== Update a post =====
export const updatePost = (postId, updatedPost) => {
    return api1.put(`/${postId}`, updatedPost);
};

// ===== Delete a post =====
export const deletePost = (postId) => {
    return api1.delete(`/${postId}`);
};
