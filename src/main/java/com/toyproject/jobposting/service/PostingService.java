package com.toyproject.jobposting.service;

import com.toyproject.jobposting.Repository.PostingRepository;
import com.toyproject.jobposting.entity.Posting;
import com.toyproject.jobposting.entity.User;
import com.toyproject.jobposting.entity.UserStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostingService {
    private final PostingRepository postingRepository;

    public void savePosting(Posting posting, User user){
        validateAdmin(user);
        postingRepository.save(posting);
    }

    private void validateAdmin(User user) {
        if(user.getUserStatus() != UserStatus.ADMIN){
            throw new IllegalStateException("일반 사용자는 채용 공고를 작성할 수 없습니다.");
        }
    }

}
