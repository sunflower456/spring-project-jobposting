package com.toyproject.jobposting.Repository;

import com.toyproject.jobposting.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ApplicationRepository {
    private final EntityManager em;

    public void saveIntroduceInfo(IntroduceInfo introduceInfo){
        em.persist(introduceInfo);
    }
    public void saveQulifyInfo(QualifyInfo qualifyInfo){
        em.persist(qualifyInfo);
    }
    public void saveSchoolInfo(SchoolInfo schoolInfo){
        em.persist(schoolInfo);
    }
    public void saveBasicInfo(BasicInfo basicInfo) {em.persist(basicInfo);}

    public void save(Application application){
        em.persist(application);
    }


    public Application findOne(Long id){
        Application findApp = em.find(Application.class, id);
        return findApp;
    }

    public List<Application> findByPost(Long postingId){
        return em.createQuery("select a from Application a where a.post_app_id = :id", Application.class)
                .setParameter("id", postingId)
                .getResultList();

    }

    public List<Application> findByUser(User user){
        return em.createQuery("select a from Application a where a.user_app_id  = :user", Application.class)
                .setParameter("user", user.getId())
                .getResultList();
    }

    public IntroduceInfo findIntroduceInfo(Long id){
        return em.find(IntroduceInfo.class, id);
    }

    public BasicInfo findBasicInfo(Long id){
        return em.find( BasicInfo.class, id);
    }

    public QualifyInfo findQualifyInfo(Long id){
        return em.find(QualifyInfo.class, id);
    }

    public SchoolInfo findSchoolInfo(Long id){
        return em.find(SchoolInfo.class, id);
    }
    public List<Application> findApps(){
        return em.createQuery("select a from Application a", Application.class)
                .getResultList();
    }

    public void deleteApplication(Long id){
        em.createQuery("delete from Application a where a.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    public void deleteIntroduceInfo(Long id){
        em.createQuery("delete from IntroduceInfo i where i.application.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    public void deleteSchoolinfo(Long id){
        em.createQuery("delete from SchoolInfo s where s.application.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    public void deleteQualifyInfo(Long id){
        em.createQuery("delete from QualifyInfo q where q.application.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
