import React, { useEffect, useState } from "react";
import { deleteUserById, getAllUsers } from "../api/userApi";

function UserList() {
  const [users, setUsers] = useState([]);

  const loadUsers = async () => {
    try {
      const response = await getAllUsers();
      setUsers(response.data);
    } catch (error) {
      console.error("Error loading users:", error);
    }
  };

  useEffect(() => {
    loadUsers();
  }, []);

  const handleDelete = async (id) => {
    try {
      await deleteUserById(id);
      loadUsers();
    } catch (error) {
      console.error("Error deleting user:", error);
    }
  };

  return (
    <div className="p-4">
      <h2 className="text-lg font-bold mb-3">User List</h2>
      {users.length > 0 ? (
        users.map((u) => (
          <div
            key={u.userId}
            className="flex justify-between border p-2 mb-2 rounded"
          >
            <span>
              <strong>{u.userName}</strong> - {u.userEmail}
            </span>
            <button
              onClick={() => handleDelete(u.userId)}
              className="bg-red-500 text-white px-3 py-1 rounded"
            >
              Delete
            </button>
          </div>
        ))
      ) : (
        <p>No users found.</p>
      )}
    </div>
  );
}

export default UserList;
