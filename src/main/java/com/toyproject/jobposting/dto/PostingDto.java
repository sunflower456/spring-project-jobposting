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

    private List<Question> questions = new ArrayList<>();

    public void changeToDto(Posting posting){
        this.title = posting.getTitle();
        this.annoStaDate = posting.getAnnoStaDate();
        this.annoEndDate = posting.getAnnoEndDate();
        this.desc = posting.getDesc();
        this.postStatus = posting.getPostStatus();
        this.questions = posting.getQuestions();
    }
}
