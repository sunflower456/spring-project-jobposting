package com.toyproject.jobposting.dto;

import lombok.Data;

import javax.persistence.Basic;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class AppSaveDto {
    // user
//    private UserDto user;
    // post
//    private PostxingDto posting;

    private Long id;

    @NotNull
    private Long user_app_id;
    @NotNull
    private Long post_app_id;

    private List<BasicInfoDto> basicInfos = new ArrayList<>();

    // school info
    private List<SchoolInfoDto> schoolInfos = new ArrayList<>();

    // introduce info
    private List<IntroduceInfoDto> introduceInfos = new ArrayList<>();

    // qualify info
    private List<QualifyInfoDto> qualifyInfos = new ArrayList<>();



}
