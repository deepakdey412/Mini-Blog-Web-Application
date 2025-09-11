import React, { useState } from "react";
import { createPost } from "../api/postApi"; // adjust path according to your project structure

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

      // Reset form
      setTitle("");
      setContent("");
      setImageName("");
      setUserId("");
      setCategoryId("");

      if (onSubmit) onSubmit(response.data); // optional callback
    } catch (error) {
      console.error(error);
      setMessage("Failed to create post. Please try again.");
    }
  };

  return (
    <div className="post-form-container">
      <h2>Create New Post</h2>
      {message && <p>{message}</p>}
      <form onSubmit={handleSubmit}>
        <div>
          <label>Title:</label>
          <input
            type="text"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
            required
          />
        </div>

        <div>
          <label>Content:</label>
          <textarea
            value={content}
            onChange={(e) => setContent(e.target.value)}
            required
          />
        </div>

        <div>
          <label>Image Name:</label>
          <input
            type="text"
            value={imageName}
            onChange={(e) => setImageName(e.target.value)}
            placeholder="default.png"
          />
        </div>

        <div>
          <label>User ID:</label>
          <input
            type="number"
            value={userId}
            onChange={(e) => setUserId(e.target.value)}
            required
          />
        </div>

        <div>
          <label>Category:</label>
          <select
            value={categoryId}
            onChange={(e) => setCategoryId(e.target.value)}
            required
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

        <button type="submit">Create Post</button>
      </form>
    </div>
  );
};

export default PostForm;
