package com.toyproject.jobposting.Repository;

import com.toyproject.jobposting.entity.Application;
import com.toyproject.jobposting.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ApplicationRepository {
    private final EntityManager em;

    public void save(Application application){
        em.persist(application);
    }

    public Application findOne(Long id){
        Application findApp = em.find(Application.class, id);
        return findApp;
    }

    public List<Application> findByUser(User user){
        return em.createQuery("select a from Application a where a.user = :user", Application.class)
                .setParameter("user", user)
                .getResultList();
    }
}
