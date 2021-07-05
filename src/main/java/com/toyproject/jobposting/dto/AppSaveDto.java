package com.toyproject.jobposting.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AppSaveDto {
    // user
//    private UserDto user;
    // post
//    private PostingDto posting;

    private Long userid;
    private Long postingId;
    // school info
    private List<SchoolInfoDto> schoolInfos = new ArrayList<>();

    // introduce info
    private List<IntroduceInfoDto> introduceInfos = new ArrayList<>();

    // qualify info
    private List<QualifyInfoDto> qualifyInfos = new ArrayList<>();



}
