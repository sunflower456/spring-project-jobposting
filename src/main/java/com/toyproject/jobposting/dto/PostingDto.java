package com.toyproject.jobposting.dto;

import com.toyproject.jobposting.entity.Application;
import com.toyproject.jobposting.entity.PostStatus;
import com.toyproject.jobposting.entity.Posting;
import com.toyproject.jobposting.entity.Question;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class PostingDto {
    private String title;

    private LocalDateTime annoStaDate; // posting announcement start date
    private LocalDateTime annoEndDate; // posting announcement end date

    private String desc;

    private PostStatus postStatus;

    private List<QuestionDto> questions = new ArrayList<>();

}
