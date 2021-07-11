package com.toyproject.jobposting.controller;

import com.toyproject.jobposting.dto.LoginDto;
import com.toyproject.jobposting.dto.UserDto;
import com.toyproject.jobposting.entity.User;
import com.toyproject.jobposting.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    @GetMapping("/users")
    public ReadUserResponse users(){
        List<User> userList = userService.findUser();
        List<UserDto> userDtoList = new ArrayList<>();
        ReadUserResponse<List<UserDto>> response = new ReadUserResponse<>();
        for (User user : userList) {
            UserDto userDto = modelMapper.map(user, UserDto.class);
            userDtoList.add(userDto);
        }
        response.setData(userDtoList);
        return response;
    }

    @GetMapping("/users/{id}")
    public ReadUserResponse userById(@PathVariable Long id){
        User user = userService.findOne(id);
        UserDto userDto = modelMapper.map(user, UserDto.class);
        ReadUserResponse<List<UserDto>> result = new ReadUserResponse<>();
        List<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(userDto);
        result.setData(userDtoList);
        // null pointer exception 처리
        return result;
    }

    @PostMapping("/users/login")
    public ReadUserResponse userByIdentity(@RequestBody @Valid LoginDto request) {
        List<User> temp = userService.findByIdentity(request);
        ReadUserResponse<UserDto> result = new ReadUserResponse<>();
        System.out.println("temp size = " + temp.size());
        if(temp.size()!=0){
            result.setData(modelMapper.map(temp.get(0), UserDto.class));
        } else {
            // user not found exception
        }
        return result;
    }
    @PostMapping("/users")
    public void saveUser(@RequestBody @Valid UserDto request){
        User user = modelMapper.map(request, User.class);
        userService.save(user);

    }

    @PutMapping("/users/{id}")
    public void editUser(@RequestBody @Valid UserDto request, @PathVariable Long id){
        User user = modelMapper.map(request, User.class);

        userService.updateUser(id, user);
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
