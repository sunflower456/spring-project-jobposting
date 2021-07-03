package com.toyproject.jobposting.Repository;

import com.toyproject.jobposting.entity.Application;
import com.toyproject.jobposting.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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

    public List<User> findUsers(){
        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }

    public User findOne(Long id){
        return em.find(User.class, id);
    }

    public void deleteUser(Long id){
        em.createQuery("delete from User u where u.id = :id")
                .setParameter("id", id)
                .executeUpdate();

    }
}
