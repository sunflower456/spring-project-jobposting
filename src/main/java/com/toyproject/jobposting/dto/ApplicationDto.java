package com.toyproject.jobposting.dto;

import com.toyproject.jobposting.entity.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ApplicationDto {
    private User user;
    private Posting posting;
    private List<SchoolInfo> schoolInfos = new ArrayList<>();
    private List<QualifyInfo> qualifyInfos = new ArrayList<>();
    private List<IntroduceInfo> introduceInfos = new ArrayList<>();

    public void changeToDto(Application application){
        this.user = application.getUser();
        this.posting = application.getPosting();
        this.schoolInfos = application.getSchoolInfos();
        this.qualifyInfos = application.getQualifyInfos();
        this.introduceInfos = application.getIntroduceInfos();
    }
}
