package com.deepak.mini_blog.service;

import com.deepak.mini_blog.dto.UserDto;
import com.deepak.mini_blog.model.User;
import com.deepak.mini_blog.mapper.UserMapper;
import com.deepak.mini_blog.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    // Create User
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    // Update User
    @Override
    public UserDto userUpdate(UserDto userDto, Integer userId) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        existingUser.setUserName(userDto.getUserName());
        existingUser.setUserEmail(userDto.getUserEmail());
        existingUser.setUserAbout(userDto.getUserAbout());
        existingUser.setUserPassword(userDto.getUserPassword());

        User updatedUser = userRepository.save(existingUser);
        return userMapper.toDto(updatedUser);
    }

    // Get User by ID
    @Override
    public UserDto getUserById(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        return userMapper.toDto(user);
    }

    // Get All Users
    @Override
    public List<UserDto> getAllUser() {
        List<User> getUserList = userRepository.findAll();
        List<UserDto> returnList = new ArrayList<>();
        for (User user : getUserList) {
            returnList.add(userMapper.toDto(user));
        }
        return returnList;
    }

    // Delete User
    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
