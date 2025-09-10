import React, { useState } from "react";
import { createUser } from "../api/api";
import "./UserForm.css";


function UserForm({ onSuccess }) {
  const [user, setUser] = useState({
    name: "",
    email: "",
    password: "",
    about: ""
  });

  const handleChange = (e) => {
    setUser({
      ...user,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await createUser(user);
      alert("User Created");
      onSuccess();
    } catch (err) {
      alert("Failed to Create User. Please try again");
      console.error(err);
    }
  };

  return (
    <form className="user-form" onSubmit={handleSubmit}>
      <h2>Create New User</h2>

      <input
        type="text"
        name="name"
        value={user.name}
        onChange={handleChange}
        placeholder="Name"
        required
      />

      <input
        type="email"
        name="email"
        value={user.email}
        onChange={handleChange}
        placeholder="Email"
        required
      />

      <input
        type="password"
        name="password"
        value={user.password}
        onChange={handleChange}
        placeholder="Password"
        required
      />

      <textarea
        name="about"
        value={user.about}
        onChange={handleChange}
        placeholder="About"
      />

      <button type="submit">Create User</button>
    </form>
  );
}

export default UserForm;
