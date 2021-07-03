package com.toyproject.jobposting.service;

import com.toyproject.jobposting.Repository.ApplicationRepository;
import com.toyproject.jobposting.entity.Application;
import com.toyproject.jobposting.entity.User;
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
    public void save(Application application){
        applicationRepository.save(application);
    }

    public Application findOne(Long id){
        return applicationRepository.findOne(id);
    }

    public List<Application> findByUser(User user){
        return applicationRepository.findByUser(user);
    }
}
