package com.toyproject.jobposting.dto;

import com.toyproject.jobposting.entity.SchoolInfo;
import com.toyproject.jobposting.entity.SchoolStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SchoolInfoDto {

    private Long id;
    private Long applicationId;
    private SchoolStatus schoolStatus;
    private String orgName;
    private String schoolMajor; // only when school
    private LocalDateTime orgStaDate;
    private LocalDateTime orgEndDate;
    private String jobTask; // only when career

}
