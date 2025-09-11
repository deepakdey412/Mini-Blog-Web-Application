import React, { useState } from "react";
import { createUser } from "../api/userApi";

function UserForm({ onSuccess }) {
  const [user, setUser] = useState({
    userName: "",
    userEmail: "",
    userPassword: "",
    userAbout: ""
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
    <div className="container mt-4">
      <div className="card shadow-sm">
        <div className="card-body">
          <h2 className="card-title text-center mb-3">Create New User</h2>
          <form onSubmit={handleSubmit}>
            <div className="mb-3">
              <input
                type="text"
                name="userName"
                value={user.userName}
                onChange={handleChange}
                className="form-control"
                placeholder="Name"
                required
              />
            </div>

            <div className="mb-3">
              <input
                type="email"
                name="userEmail"
                value={user.userEmail}
                onChange={handleChange}
                className="form-control"
                placeholder="Email"
                required
              />
            </div>

            <div className="mb-3">
              <input
                type="password"
                name="userPassword"
                value={user.userPassword}
                onChange={handleChange}
                className="form-control"
                placeholder="Password"
                required
              />
            </div>

            <div className="mb-3">
              <textarea
                name="userAbout"
                value={user.userAbout}
                onChange={handleChange}
                className="form-control"
                placeholder="About"
                rows="3"
              />
            </div>

            <button type="submit" className="btn btn-primary w-100">
              Create User
            </button>
          </form>
        </div>
      </div>
    </div>
  );
}

export default UserForm;
