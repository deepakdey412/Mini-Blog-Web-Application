package com.deepak.mini_blog.service;

import com.deepak.mini_blog.dto.UserDto;
import com.deepak.mini_blog.mapper.UserMapper;
import com.deepak.mini_blog.model.User;
import com.deepak.mini_blog.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    //Create User
    public UserDto createUser(UserDto userDto){

        //convert Dto->Entity and store in Entitiy object
        User user = userMapper.toEntity(userDto);

        //Saved the Entity object in DB and save its copy in other Entity object
        User savedUser = userRepository.save(user);

        //Conveting the Entity->DTO and return it to the controller
        return userMapper.toDto(savedUser);
    }

    //Get All Users
    public List<UserDto> getAllUser(){
        List<User> getUserlist = userRepository.findAll();

        List<UserDto> returnList = new ArrayList<>();

        for (User user : getUserlist){
            returnList.add(userMapper.toDto(user));
        }
        return returnList;
    }

    //Get user by id
//    public Optional<UserDto> getUserById(Integer id){
//        Optional<User> foundUser = userRepository.findById(id);
////        Optional<UserDto> foundedUser = userMapper.toDto(foundUser);
//
////        return Optional.ofNullable( userMapper.toDto(foundUser));
//    }

    //Delete user by id
    public void deleteUser(int id){
//        Optional<User> foundUser = userRepository.findById(id);
        userRepository.deleteById(id);

    }

}
