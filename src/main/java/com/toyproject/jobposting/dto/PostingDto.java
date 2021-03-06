package com.toyproject.jobposting.dto;

import com.toyproject.jobposting.entity.JobKind;
import com.toyproject.jobposting.entity.PostStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class PostingDto {

    private Long id;
    private String title;

    private LocalDateTime annoStaDate; // posting announcement start date
    private LocalDateTime annoEndDate; // posting announcement end date

    private JobKind jobKind;
    private String desc;

    private PostStatus postStatus;

    private List<QuestionDto> questions = new ArrayList<>();

}
