package com.toyproject.jobposting.service;

import com.toyproject.jobposting.entity.User;
import com.toyproject.jobposting.entity.UserStatus;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class) // junit 실행할 때 spring이랑 실행할때
@Transactional
class UserServiceTest {

    @Autowired private UserService userService;

    @Test
    @Rollback(false)
    public void 회원가입() throws Exception{
        User user = new User();
        user.setEmail("asdfasf@gmail.com");
        user.setIdentity("herb");
        user.setPassword("1234");
        user.setName("herb");
        user.setPhoneNumber("010-1234-1234");
        user.setUserStatus(UserStatus.ADMIN);

        userService.save(user);
    }

}