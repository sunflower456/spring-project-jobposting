package com.toyproject.jobposting.service;

import com.toyproject.jobposting.Repository.ApplicationRepository;
import com.toyproject.jobposting.Repository.PostingRepository;
import com.toyproject.jobposting.Repository.UserRepository;
import com.toyproject.jobposting.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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


        List<IntroduceInfo> introduceInfos = target.getIntroduceInfos();
        for (IntroduceInfo introduceInfo : introduceInfos) {
            introduceInfo.setApplication(find);
        }

        List<SchoolInfo> schoolInfos = target.getSchoolInfos();
        for (SchoolInfo schoolInfo : schoolInfos) {

            schoolInfo.setApplication(find);

        }
        List<QualifyInfo> qualifyInfos = target.getQualifyInfos();
        for (QualifyInfo qualifyInfo : qualifyInfos) {
            qualifyInfo.setApplication(find);
        }

        applicationRepository.deleteIntroduceInfo(id);
        applicationRepository.deleteQualifyInfo(id);
        applicationRepository.deleteSchoolinfo(id);

        find.setSchoolInfos(schoolInfos);
        find.setIntroduceInfos(introduceInfos);
        find.setQualifyInfos(qualifyInfos);

        return find;
    }
    @Transactional
    public void deleteApp(Long id){
        applicationRepository.deleteApplication(id);
    }


}
