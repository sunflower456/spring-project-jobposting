package com.toyproject.jobposting.dto;

import com.toyproject.jobposting.entity.IntroduceInfo;
import lombok.Data;

@Data
public class IntroduceInfoDto {

    private Long id;
    private Long applicationId;
    private String question; //
    private String answer;

}
