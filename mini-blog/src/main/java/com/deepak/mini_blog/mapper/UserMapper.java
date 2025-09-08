package com.deepak.mini_blog.mapper;

import com.deepak.mini_blog.dto.UserDto;
import com.deepak.mini_blog.model.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserMapper {
    public User toEntity(UserDto userDto){
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setUserName(userDto.getUserName());
        user.setUserEmail(userDto.getUserEmail());
        user.setUserAbout(userDto.getUserAbout());
        user.setUserPassword(userDto.getUserPassword());
        return user;
    }

    public UserDto toDto(User user){
        UserDto userDto= new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setUserName(user.getUserName());
        userDto.setUserAbout(user.getUserAbout());
        userDto.setUserEmail(user.getUserEmail());
//        userDto.setUserPassword(userDto.getUserPassword());
        return userDto;
    }
}
