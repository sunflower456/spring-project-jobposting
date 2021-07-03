package com.toyproject.jobposting.service;

import com.toyproject.jobposting.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class) // junit 실행할 때 spring이랑 실행할때
@Transactional
class ApplicationServiceTest {

    @Autowired private ApplicationService applicationService;
    @Autowired private UserService userService;

    @Test
    @Rollback(false)
    public void 지원서작성() throws Exception{
        User user = userService.findByIdentity("hongcha").get(0);

    }
}