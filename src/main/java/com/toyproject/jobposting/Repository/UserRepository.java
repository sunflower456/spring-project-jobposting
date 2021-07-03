package com.toyproject.jobposting.Repository;

import com.toyproject.jobposting.entity.Application;
import com.toyproject.jobposting.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final EntityManager em;

    public void save(User user){
        em.persist(user);
    }

    public List<User> findByIdentity(String identity) {
        List<User> users = em.createQuery("select u from User u where u.identity = :identity", User.class)
                .setParameter("identity", identity)
                .getResultList();
        return users;
    }
}
