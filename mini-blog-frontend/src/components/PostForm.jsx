// src/components/PostForm.jsx
import React, { useState } from "react";
import { createPost } from "../api/postApi";

const PostForm = ({ onSubmit, categories }) => {
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");
  const [imageName, setImageName] = useState("");
  const [userId, setUserId] = useState("");
  const [categoryId, setCategoryId] = useState("");
  const [message, setMessage] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!title || !content || !userId || !categoryId) {
      setMessage("Please fill all required fields!");
      return;
    }

    const postData = {
      title,
      content,
      imageName: imageName || "default.png",
    };

    try {
      const response = await createPost(postData, userId, categoryId);
      setMessage(`Post created successfully with ID: ${response.data.postId}`);

      setTitle("");
      setContent("");
      setImageName("");
      setUserId("");
      setCategoryId("");

      if (onSubmit) onSubmit(response.data);
    } catch (error) {
      console.error(error);
      setMessage("Failed to create post. Please try again.");
    }
  };

  return (
    <div className="post-form-container">
      <h2 className="text-xl font-semibold mb-2">Create New Post</h2>
      {message && <p className="mb-2 text-sm text-red-500">{message}</p>}
      <form onSubmit={handleSubmit} className="space-y-4">
        <div>
          <label className="block mb-1">Title:</label>
          <input
            type="text"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
            required
            className="w-full border p-2 rounded"
          />
        </div>

        <div>
          <label className="block mb-1">Content:</label>
          <textarea
            value={content}
            onChange={(e) => setContent(e.target.value)}
            required
            className="w-full border p-2 rounded"
          />
        </div>

        <div>
          <label className="block mb-1">Image Name:</label>
          <input
            type="text"
            value={imageName}
            onChange={(e) => setImageName(e.target.value)}
            placeholder="default.png"
            className="w-full border p-2 rounded"
          />
        </div>

        <div>
          <label className="block mb-1">User ID:</label>
          <input
            type="number"
            value={userId}
            onChange={(e) => setUserId(e.target.value)}
            required
            className="w-full border p-2 rounded"
          />
        </div>

        <div>
          <label className="block mb-1">Category:</label>
          <select
            value={categoryId}
            onChange={(e) => setCategoryId(e.target.value)}
            required
            className="w-full border p-2 rounded"
          >
            <option value="">Select a category</option>
            {categories &&
              categories.map((cat) => (
                <option key={cat.categoryId} value={cat.categoryId}>
                  {cat.categoryTitle}
                </option>
              ))}
          </select>
        </div>

        <button
          type="submit"
          className="px-4 py-2 bg-blue-600 text-white rounded hover:bg-blue-700"
        >
          Create Post
        </button>
      </form>
    </div>
  );
};

export default PostForm;
