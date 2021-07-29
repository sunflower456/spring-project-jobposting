package com.toyproject.jobposting.service;

import com.toyproject.jobposting.Repository.ApplicationRepository;
import com.toyproject.jobposting.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    @Transactional
    public Long save(Application application){
        applicationRepository.save(application);
        return application.getId();
    }

    public Application findOne(Long id){
        return applicationRepository.findOne(id);
    }

    public List<Application> findByUser(User user){
        return applicationRepository.findByUser(user);
    }

    public List<Application> findByPost(Long postingId){
        return applicationRepository.findByPost(postingId);
    }


    public List<Application> findApps(){
        return applicationRepository.findApps();
    }

   @Transactional
   public void saveBasicInfo(BasicInfo basicInfo){
        applicationRepository.saveBasicInfo(basicInfo);
   }

    @Transactional
    public void saveSchoolInfo(SchoolInfo schoolInfo){
        applicationRepository.saveSchoolInfo(schoolInfo);
    }

    @Transactional
    public void saveQualifyInfo(QualifyInfo qualifyInfo){
        applicationRepository.saveQulifyInfo(qualifyInfo);
    }

    @Transactional
    public void saveIntroduceInfo(IntroduceInfo introduceInfo){
        applicationRepository.saveIntroduceInfo(introduceInfo);
    }

    @Transactional
    public void editBasicInfo(Long id, BasicInfo target){
        BasicInfo basicInfo = applicationRepository.findBasicInfo(id);
        Application application = applicationRepository.findOne(target.getApplication().getId());
        basicInfo.setApplication(application);
        basicInfo.setNation(target.getNation());
        basicInfo.setName(target.getName());
        basicInfo.setAddress(target.getAddress());
        basicInfo.setPhoneNumber(target.getPhoneNumber());
        basicInfo.setEnglishName(target.getEnglishName());

    }

    @Transactional
    public void editSchoolInfo(Long id, SchoolInfo target){
        SchoolInfo schoolInfo = applicationRepository.findSchoolInfo(id);
        Application application = applicationRepository.findOne(target.getApplication().getId());
        schoolInfo.setSchoolStatus(target.getSchoolStatus());
        schoolInfo.setSchoolMajor(target.getSchoolMajor());
        schoolInfo.setApplication(application);
        schoolInfo.setJobTask(target.getJobTask());
        schoolInfo.setOrgName(target.getOrgName());
        schoolInfo.setOrgEndDate(target.getOrgEndDate());
        schoolInfo.setOrgStaDate(target.getOrgStaDate());

    }

    @Transactional
    public void editQualifyInfo(Long id, QualifyInfo target){
        QualifyInfo qualifyInfo = applicationRepository.findQualifyInfo(id);
        Application application = applicationRepository.findOne(target.getApplication().getId());
        qualifyInfo.setApplication(application);
        qualifyInfo.setQualiName(target.getQualiName());
        qualifyInfo.setQualiOrg(target.getQualiOrg());
        qualifyInfo.setQualiNumber(target.getQualiNumber());
        qualifyInfo.setQualiEndDate(target.getQualiEndDate());
        qualifyInfo.setQualiStaDate(target.getQualiStaDate());

    }

    @Transactional
    public void editIntroduceInfo(Long id, IntroduceInfo target){
        IntroduceInfo introduceInfo = applicationRepository.findIntroduceInfo(id);
        Application application = applicationRepository.findOne(target.getApplication().getId());
        introduceInfo.setApplication(application);
        introduceInfo.setAnswer(target.getAnswer());
        introduceInfo.setQuestion(target.getQuestion());
    }

    @Transactional
    public void deleteApp(Long id){
        applicationRepository.deleteApplication(id);
    }


}
