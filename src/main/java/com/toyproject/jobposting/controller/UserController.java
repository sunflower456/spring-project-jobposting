package com.toyproject.jobposting.controller;

import com.toyproject.jobposting.dto.UserDto;
import com.toyproject.jobposting.entity.User;
import com.toyproject.jobposting.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ReadUserResponse users(){
        List<User> userList = userService.findUser();
        List<UserDto> userDtoList = new ArrayList<>();
        ReadUserResponse<List<UserDto>> response = new ReadUserResponse<>();
        for (User user : userList) {
            userDtoList.add(user.toDto());
        }
        response.setData(userDtoList);
        return response;
    }

    @GetMapping("/users/{id}")
    public ReadUserResponse userById(@PathVariable Long id){
        User user = userService.findOne(id);
        ReadUserResponse<List<UserDto>> result = new ReadUserResponse<>();
        List<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(user.toDto());
        result.setData(userDtoList);
        // null pointer exception 처리
        return result;
    }

    @PostMapping("/users")
    public void saveUser(@RequestBody @Valid UserDto request){
        userService.save(request.toEntity());

    }

    @PutMapping("/users/{id}")
    public void editUser(@RequestBody @Valid UserDto request, @PathVariable Long id){
        userService.updateUser(id, request.toEntity());
    }

    @DeleteMapping("/users/{id}")
    public void removeUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @Data
    static class ReadUserResponse<T> {
        private T data;

    }

}
