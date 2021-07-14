package com.toyproject.jobposting.dto;

import com.toyproject.jobposting.entity.QualifyInfo;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class QualifyInfoDto {

    private Long id;
    private Long applicationId;
    private String qualiName;
    private String qualiNumber;
    private String qualiOrg;
    private LocalDateTime qualiStaDate;
    private LocalDateTime qualiEndDate; // nullable

}
