package com.deepak.mini_blog.service;

import com.deepak.mini_blog.dto.UserDto;
import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto userUpdate(UserDto userDto, Integer userId);

    UserDto getUserById(Integer userId);

    List<UserDto> getAllUser();

    void deleteUser(Integer userId);
}
