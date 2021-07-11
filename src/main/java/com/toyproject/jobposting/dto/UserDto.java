package com.toyproject.jobposting.dto;

import com.toyproject.jobposting.entity.User;
import com.toyproject.jobposting.entity.UserStatus;
import lombok.Data;


@Data
public class UserDto {
    private Long id;
    private String identity; // id
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private UserStatus userStatus;

}
