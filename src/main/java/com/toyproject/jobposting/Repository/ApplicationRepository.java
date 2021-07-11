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

    public void save(Application application){
        List<QualifyInfo> qualifyInfos = application.getQualifyInfos();
        List<SchoolInfo> schoolInfos = application.getSchoolInfos();
        List<IntroduceInfo> introduceInfos = application.getIntroduceInfos();

        for (QualifyInfo qualifyInfo : qualifyInfos) {
            qualifyInfo.setApplication(application);
        }
        for (IntroduceInfo introduceInfo : introduceInfos) {
            introduceInfo.setApplication(application);
        }
        for (SchoolInfo schoolInfo : schoolInfos) {
            schoolInfo.setApplication(application);
        }


        application.setIntroduceInfos(introduceInfos);
        application.setQualifyInfos(qualifyInfos);
        application.setSchoolInfos(schoolInfos);

        em.persist(application);
    }


    public Application findOne(Long id){
        Application findApp = em.find(Application.class, id);
        return findApp;
    }

    public List<Application> findByUser(User user){
        return em.createQuery("select a from Application a where  = :user", Application.class)
                .setParameter("user", user.getId())
                .getResultList();
    }

    public List<IntroduceInfo> findIntroduceInfo(Long id){
        return em.createQuery("select i from IntroduceInfo i where i.application.id = :id", IntroduceInfo.class)
                .setParameter("id", id)
                .getResultList();
    }

    public List<BasicInfo> findBasicInfo(Long id){
        return em.createQuery("select b from BasicInfo b where b.application.id = :id", BasicInfo.class)
                .setParameter("id", id)
                .getResultList();
    }

    public List<QualifyInfo> findQualifyInfo(Long id){
        return em.createQuery("select q from QualifyInfo q where q.application.id = :id", QualifyInfo.class)
                .setParameter("id", id)
                .getResultList();
    }

    public List<SchoolInfo> findSchoolInfo(Long id){
        return em.createQuery("select s from SchoolInfo s where s.application.id = :id", SchoolInfo.class)
                .setParameter("id", id)
                .getResultList();
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
