package com.toyproject.jobposting.dto;

import com.toyproject.jobposting.entity.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ApplicationDto {
    private Long id;
    private Long userId;
    private Long postingId;
    private List<BasicInfo> basicInfos = new ArrayList<>();
    private List<SchoolInfo> schoolInfos = new ArrayList<>();
    private List<QualifyInfo> qualifyInfos = new ArrayList<>();
    private List<IntroduceInfo> introduceInfos = new ArrayList<>();

}
