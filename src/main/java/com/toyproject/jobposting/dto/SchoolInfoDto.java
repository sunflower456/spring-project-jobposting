package com.toyproject.jobposting.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.toyproject.jobposting.entity.Application;
import com.toyproject.jobposting.entity.SchoolInfo;
import com.toyproject.jobposting.entity.SchoolStatus;
import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
public class SchoolInfoDto {

//    private Long id;
    private SchoolStatus schoolStatus;
    private String orgName;
    private String schoolMajor; // only when school
    private LocalDateTime orgStaDate;
    private LocalDateTime orgEndDate;
    private String jobTask; // only when career

    public void toChangeDto(SchoolInfo schoolInfo){
        this.jobTask = schoolInfo.getJobTask();
        this.schoolMajor = schoolInfo.getSchoolMajor();
        this.orgEndDate = schoolInfo.getOrgEndDate();
        this.schoolStatus = schoolInfo.getSchoolStatus();
        this.orgName = schoolInfo.getOrgName();
        this.orgStaDate = schoolInfo.getOrgStaDate();
    }
}
