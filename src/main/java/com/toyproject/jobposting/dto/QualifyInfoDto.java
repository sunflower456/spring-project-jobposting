package com.toyproject.jobposting.dto;

import com.toyproject.jobposting.entity.QualifyInfo;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class QualifyInfoDto {

//    private Long id;
    private String qualiName;
    private String qualiNumber;
    private String qualiOrg;
    private LocalDateTime qualiStaDate;
    private LocalDateTime qualiEndDate; // nullable

    public void toChangeDto(QualifyInfo qualifyInfo){
        this.qualiName = qualifyInfo.getQualiName();
        this.qualiNumber = qualifyInfo.getQualiNumber();
        this.qualiOrg = qualifyInfo.getQualiOrg();
        this.qualiEndDate = qualifyInfo.getQualiEndDate();
        this.qualiStaDate = qualifyInfo.getQualiStaDate();
    }
}
