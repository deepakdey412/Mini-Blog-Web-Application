import { useState } from "react";
import UserForm from "../components/UserForm";
import UserList from "../components/UserList";

function Home() {
    const [reload, setReload] = useState(false);

    return (
        <div className="grid grid-cols-2 gap-4 p-6">
            <UserForm onSuccess={() => setReload(!reload)} />
            <UserList key={reload} />
        </div>
    );
}

export default Home;
