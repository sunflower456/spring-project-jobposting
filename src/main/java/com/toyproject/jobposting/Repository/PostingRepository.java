package com.toyproject.jobposting.Repository;

import com.toyproject.jobposting.entity.Posting;
import com.toyproject.jobposting.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostingRepository {

    private final EntityManager em;

    public void save(Posting posting){
        List<Question> findQuestion = posting.getQuestions();
        for (Question question : findQuestion) {
            question.setPosting(posting);
        }
        posting.setQuestions(findQuestion);
        em.persist(posting);
    }

    public Posting findOne(Long id){
        return em.find(Posting.class, id);
    }

    public List<Posting> findPostings(){
        return em.createQuery("select p from Posting p", Posting.class)
                .getResultList();
    }

    public void deletePosting(Long id){
        em.createQuery("delete from Posting p where p.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    public void deleteQuestion(Long id){
        em.createQuery("delete from Question q where q.posting.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
