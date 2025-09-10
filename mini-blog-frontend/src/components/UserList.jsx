import React, { useEffect, useState } from "react";
import { deleteUserById, getUsers } from "../api/userApi"; // Adjust path

function UserList() {
    const [users, setUsers] = useState([]);

    const loadUsers = async () => {
        const response = await getUsers();
        setUsers(response.data);
    };

    useEffect(() => {
        loadUsers();
    }, []);

    const handleDelete = async (id) => {
        await deleteUserById(id);
        loadUsers();
    };

    return (
        <div className="p-4">
            <h2 className="text-lg font-bold mb-3">User List</h2>
            {
                users.map((u) => (
                    <div key={u.id} className="flex justify-between border p-2 mb-2 rounded">
                        <span>
                            {u.name} - {u.email}
                        </span>
                        <button
                            onClick={() => handleDelete(u.id)}
                            className="bg-red-500 text-white px-3 py-1 rounded"
                        >
                            Delete
                        </button>
                    </div>
                ))
            }
        </div>
    );
}

export default UserList;
