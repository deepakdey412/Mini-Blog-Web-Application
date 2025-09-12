// src/pages/CreatePost.jsx
import React from "react";
import PostForm from "../components/PostForm";
import { createPost } from "../api/postApi";

const TEMP_CATEGORIES = [
  { categoryId: 1, categoryTitle: "Technology" },
  { categoryId: 2, categoryTitle: "Education" },
  { categoryId: 3, categoryTitle: "Health" },
];

function CreatePost() {
  const handleCreate = async ({ title, content, categoryId }) => {
    const postDto = { title, content };
    const currentDummyUserId = 1; // Replace with actual user ID logic
    await createPost(postDto, currentDummyUserId, categoryId);
    alert("Post created successfully!");
  };

  return (
    <div className="max-w-2xl mx-auto p-6 bg-white rounded-lg shadow-md">
      <h2 className="text-2xl font-bold mb-4">Create Post</h2>
      <PostForm onSubmit={handleCreate} categories={TEMP_CATEGORIES} />
    </div>
  );
}

export default CreatePost;
