package com.toyproject.jobposting.service;

import com.toyproject.jobposting.Repository.ApplicationRepository;
import com.toyproject.jobposting.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Basic;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    @Transactional
    public void save(Application application){
        applicationRepository.save(application);
    }

    public Application findOne(Long id){
        return applicationRepository.findOne(id);
    }

    public List<Application> findByUser(User user){
        return applicationRepository.findByUser(user);
    }

    public List<Application> findApps(){
        return applicationRepository.findApps();
    }

    @Transactional
    public Application updateApp(Long id, Application target){
        Application find = applicationRepository.findOne(id);


        // 변경 감지
        List<IntroduceInfo> introduceInfos = target.getIntroduceInfos();
        List<IntroduceInfo> findIntroduceInfos = applicationRepository.findIntroduceInfo(id);
        for (IntroduceInfo introduceInfo : introduceInfos) {
            introduceInfo.setApplication(find);
            for (IntroduceInfo findInfo : findIntroduceInfos) {
                findInfo.setApplication(find);
                System.out.println("findInfo = " + findInfo.getId());
                findInfo.setQuestion(introduceInfo.getQuestion());
                findInfo.setAnswer(introduceInfo.getAnswer());
            }

            //applicationRepository.saveIntroduceInfo(findInfo);
        }

        List<SchoolInfo> schoolInfos = target.getSchoolInfos();
        List<SchoolInfo> findSchoolInfos = applicationRepository.findSchoolInfo(id);
        for (SchoolInfo schoolInfo : schoolInfos) {
            schoolInfo.setApplication(find);
            for (SchoolInfo findInfo : findSchoolInfos) {
                findInfo.setSchoolMajor(schoolInfo.getSchoolMajor());
                findInfo.setSchoolStatus(schoolInfo.getSchoolStatus());
                findInfo.setOrgName(schoolInfo.getOrgName());
                findInfo.setOrgStaDate(schoolInfo.getOrgStaDate());
                findInfo.setOrgEndDate(schoolInfo.getOrgEndDate());
                findInfo.setJobTask(schoolInfo.getJobTask());
                findInfo.setApplication(find);
            }

            //applicationRepository.saveSchoolInfo(findInfo);

        }
        List<QualifyInfo> qualifyInfos = target.getQualifyInfos();
        List<QualifyInfo> findQualifyInfos = applicationRepository.findQualifyInfo(id);
        for (QualifyInfo qualifyInfo : qualifyInfos) {
            qualifyInfo.setApplication(find);
            for (QualifyInfo findInfo : findQualifyInfos) {
                findInfo.setApplication(find);
                findInfo.setQualiStaDate(qualifyInfo.getQualiStaDate());
                findInfo.setQualiOrg(qualifyInfo.getQualiOrg());
                findInfo.setQualiNumber(qualifyInfo.getQualiNumber());
                findInfo.setQualiEndDate(qualifyInfo.getQualiEndDate());
                findInfo.setQualiName(qualifyInfo.getQualiName());
            }

            //applicationRepository.saveQulifyInfo(findInfo);
        }

        List<BasicInfo> basicInfos = target.getBasicInfos();
        List<BasicInfo> findBasicInfos = applicationRepository.findBasicInfo(id);
        for (BasicInfo basicInfo : basicInfos) {
            basicInfo.setApplication(find);
            for (BasicInfo findInfo : findBasicInfos) {
                findInfo.setApplication(find);
                findInfo.setAddress(basicInfo.getAddress());
                findInfo.setEnglishName(basicInfo.getEnglishName());
                findInfo.setName(basicInfo.getName());
                findInfo.setNation(basicInfo.getNation());
                findInfo.setPhoneNumber(basicInfo.getPhoneNumber());
            }
        }

        find.setSchoolInfos(findSchoolInfos);
        find.setIntroduceInfos(findIntroduceInfos);
        find.setQualifyInfos(findQualifyInfos);

        return find;
    }
    @Transactional
    public void deleteApp(Long id){
        applicationRepository.deleteApplication(id);
    }


}
