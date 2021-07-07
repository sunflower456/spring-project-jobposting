package com.toyproject.jobposting.dto;

import com.toyproject.jobposting.entity.User;
import com.toyproject.jobposting.entity.UserStatus;
import lombok.Data;


@Data
public class UserDto {
    private String identity; // id
    private String name;
    private String email;
    private String phoneNumber;
    private UserStatus userStatus;

    public void changeToDto(User user){
        this.identity = user.getIdentity();
        this.name = user.getName();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
        this.userStatus = user.getUserStatus();
    }

}
