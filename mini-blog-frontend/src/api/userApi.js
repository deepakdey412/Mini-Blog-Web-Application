import {api} from './api'
//Create user 
export const createUser = (user)=>api.post("/",user);

//Get all users
export const getAllUsers = ()=>api.get("/");

//Get user by id
export const getUserById = (id)=>api.get(`/${id}`);

//Update user by id
export const updateUserById = (id,user)=>api.put(`/${id}`,user);

//Delete user by id
export const deleteUserById = (id)=>api.delete(`/${id}`);