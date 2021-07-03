package com.toyproject.jobposting.service;

import com.toyproject.jobposting.entity.Posting;
import com.toyproject.jobposting.entity.Question;
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
class PostingServiceTest {

    @Autowired private PostingService postingService;

    @Test
    @Rollback(false)
    public void 채용공고올리기() throws Exception{
        Question q1 = new Question();
        q1.setQuestion("question 1");
        Question q2 = new Question();
        q2.setQuestion("question 2");
        Question q3 = new Question();
        q3.setQuestion("question 3");

        Posting posting = new Posting();
        posting.setTitle("posting 1");
        posting.setDesc("description");
        posting.addQuestion(q1);
        posting.addQuestion(q2);
        posting.addQuestion(q3);

        User user = new User();
        user.setEmail("asdfasf@gmail.com");
        user.setIdentity("herb");
        user.setPassword("1234");
        user.setName("herb");
        user.setUserStatus(UserStatus.ADMIN);

        postingService.savePosting(posting, user);
    }
}