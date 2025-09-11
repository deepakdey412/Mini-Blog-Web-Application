import axios from "axios";

// Axios instance for user-related API calls
export const api = axios.create({
    baseURL: "http://localhost:8080/api/user"
});

// Axios instance for post-related API calls
export const api1 = axios.create({
    baseURL: "http://localhost:8080/api/posts"
});
