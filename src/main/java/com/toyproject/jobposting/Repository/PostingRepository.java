package com.toyproject.jobposting.Repository;

import com.toyproject.jobposting.entity.Posting;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class PostingRepository {

    private final EntityManager em;

    public void save(Posting posting){
        em.persist(posting);
    }
}
