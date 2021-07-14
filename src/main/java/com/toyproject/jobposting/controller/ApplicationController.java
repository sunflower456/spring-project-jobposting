package com.toyproject.jobposting.controller;

import com.toyproject.jobposting.dto.*;
import com.toyproject.jobposting.entity.*;
import com.toyproject.jobposting.service.ApplicationService;
import com.toyproject.jobposting.service.PostingService;
import com.toyproject.jobposting.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ApplicationController {
    private final ApplicationService applicationService;
    private final UserService userService;
    private final PostingService postingService;
    private final ModelMapper modelMapper;

    @GetMapping("/apps")
    public ReadAppResponse apps(){
        List<Application> appList = applicationService.findApps();
        List<AppSaveDto> appDtoList = new ArrayList<>();
        ReadAppResponse<List<AppSaveDto>> response = new ReadAppResponse<>();
        for (Application application : appList) {
            appDtoList.add(modelMapper.map(application, AppSaveDto.class));
        }
        response.setData(appDtoList);
        return response;
    }

    @GetMapping("/apps/{id}")
    public ReadAppResponse appsById(@PathVariable Long id){
        Application application = applicationService.findOne(id);
        AppSaveDto appSaveDto = modelMapper.map(application, AppSaveDto.class);
        ReadAppResponse<AppSaveDto> result = new ReadAppResponse<>();
        result.setData(appSaveDto);
        return result;
    }

    @GetMapping("/apps/posts/{id}")
    public ReadAppResponse appsByPosts(@PathVariable Long id){
        List<Application> appList = applicationService.findByPost(id);
        List<AppSaveDto> appDtoList = new ArrayList<>();
        ReadAppResponse<List<AppSaveDto>> response = new ReadAppResponse<>();
        for (Application application : appList) {
            appDtoList.add(modelMapper.map(application, AppSaveDto.class));
        }
        response.setData(appDtoList);
        return response;
    }

    @PostMapping("/apps")
    public void saveApps(@RequestBody @Valid AppSaveDto request){
        Application app = modelMapper.map(request, Application.class);

        applicationService.save(app);
    }

    @PostMapping("/apps/basic")
    public void saveBasic(@RequestBody @Valid BasicInfoDto request){
        BasicInfo basicInfo = modelMapper.map(request, BasicInfo.class);
        Application application = applicationService.findOne(request.getApplicationId());
        basicInfo.setApplication(application);
        applicationService.saveBasicInfo(basicInfo);
    }

    @PostMapping("/apps/school")
    public void saveSchool(@RequestBody @Valid SchoolInfoDto request){
        SchoolInfo schoolInfo = modelMapper.map(request, SchoolInfo.class);
        Application application = applicationService.findOne(request.getApplicationId());
        schoolInfo.setApplication(application);
        applicationService.saveSchoolInfo(schoolInfo);
    }

    @PostMapping("/apps/qualify")
    public void saveQualify(@RequestBody @Valid QualifyInfoDto request){
        QualifyInfo qualifyInfo = modelMapper.map(request, QualifyInfo.class);
        Application application = applicationService.findOne(request.getApplicationId());
        qualifyInfo.setApplication(application);
        applicationService.saveQualifyInfo(qualifyInfo);
    }

    @PostMapping("/apps/introduce")
    public void saveIntroduce(@RequestBody @Valid IntroduceInfoDto request){
        IntroduceInfo introduceInfo = modelMapper.map(request, IntroduceInfo.class);
        Application application = applicationService.findOne(request.getApplicationId());
        introduceInfo.setApplication(application);
        applicationService.saveIntroduceInfo(introduceInfo);
    }

    @DeleteMapping("/apps/{id}")
    public void removeApps(@PathVariable Long id){
        applicationService.deleteApp(id);
    }

    @Data
    static class ReadAppResponse<T> {
        private T data;
    }

}
