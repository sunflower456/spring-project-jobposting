package com.toyproject.jobposting.service;

import com.toyproject.jobposting.Repository.PostingRepository;
import com.toyproject.jobposting.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostingService {
    private final PostingRepository postingRepository;

    @Transactional
    public void savePosting(Posting posting, User user){
        validateAdmin(user);
        postingRepository.save(posting);
    }

    private void validateAdmin(User user) {
        if(user.getUserStatus() != UserStatus.ADMIN){
            throw new IllegalStateException("일반 사용자는 채용 공고를 작성할 수 없습니다.");
        }
    }
    public Posting findOne(Long id){
        return postingRepository.findOne(id);
    }

    public List<Posting> findPostings(){
        return postingRepository.findPostings();
    }

    @Transactional
    public Posting updatePosting(Long id, Posting target){
        Posting find = postingRepository.findOne(id);

        List<Question> findQuestions = target.getQuestions();
        for (Question findQuestion : findQuestions) {
            findQuestion.setPosting(find);
        }
        postingRepository.deleteQuestion(id);
        find.setTitle(target.getTitle());
        find.setDesc(target.getDesc());
        find.setQuestions(findQuestions);
        find.setPostStatus(target.getPostStatus());
        find.setAnnoEndDate(target.getAnnoEndDate());
        find.setAnnoStaDate(target.getAnnoStaDate());
        return find;

    }

    @Transactional
    public void deletePosting(Long id){
        postingRepository.deletePosting(id);
    }
}
