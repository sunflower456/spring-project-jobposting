package com.toyproject.jobposting.controller;

import com.toyproject.jobposting.dto.AppSaveDto;
import com.toyproject.jobposting.dto.ApplicationDto;
import com.toyproject.jobposting.dto.PostingDto;
import com.toyproject.jobposting.entity.Application;
import com.toyproject.jobposting.entity.Posting;
import com.toyproject.jobposting.entity.User;
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

    @PostMapping("/apps")
    public void saveApps(@RequestBody @Valid AppSaveDto request){
        Application app = modelMapper.map(request, Application.class);

        applicationService.save(app);
    }

    @PutMapping("/apps/{id}")
    public void editApps(@RequestBody @Valid AppSaveDto request, @PathVariable Long id){
        Application application = modelMapper.map(request, Application.class);
        applicationService.updateApp(id, application);
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
