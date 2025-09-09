package com.deepak.mini_blog.controller;

import com.deepak.mini_blog.dto.ApiResponse;
import com.deepak.mini_blog.dto.UserDto;
import com.deepak.mini_blog.mapper.UserMapper;
import com.deepak.mini_blog.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserMapper userMapper;
    private final UserService userService;


    public UserController(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    //Create user api
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto createUser = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUser, HttpStatus.CREATED);
    }

    //User upadte
    @PostMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(  @RequestBody UserDto userDto ,@PathVariable Integer userId){
        UserDto userUpdated = this.userService.userUpdate(userDto, userId);
        return ResponseEntity.ok(userUpdated);
    }
    // Delete user
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUserById(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(new ApiResponse(true , "User Deleted successfully!"), HttpStatus.OK);
    }

    // Get all users
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUser() {
        List<UserDto> list = userService.getAllUser();
        if (list.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content
        }
        return ResponseEntity.ok(list); // 200 OK
    }
    // Get user by id
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){
        return  ResponseEntity.ok(this.userService.getUserById(userId));
    }


}
