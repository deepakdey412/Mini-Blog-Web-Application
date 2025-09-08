package com.deepak.mini_blog.service;

import com.deepak.mini_blog.dto.UserDto;
import com.deepak.mini_blog.mapper.UserMapper;
import com.deepak.mini_blog.model.User;
import com.deepak.mini_blog.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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

    // Get user by id (simple)
    public UserDto getUserById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return userMapper.toDto(user);
    }

//    public Optional<UserDto> getUserById(Integer id) {
//        return userRepository.findById(id)
//                .map(userMapper::toDto);
//    }

    // Update user by id
    public UserDto updateUser(Integer id, UserDto userDto) {
        // Find existing user
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        // Update fields
        existingUser.setUserName(userDto.getUserName());
        existingUser.setUserEmail(userDto.getUserEmail());
        existingUser.setUserAbout(userDto.getUserAbout());
        existingUser.setUserPassword(userDto.getUserPassword());

        // Save updated user
        User updatedUser = userRepository.save(existingUser);

        // Convert to DTO and return
        return userMapper.toDto(updatedUser);
    }


    // Delete user by id
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

}
