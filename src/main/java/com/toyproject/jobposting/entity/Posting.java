package com.toyproject.jobposting.entity;

import com.sun.istack.NotNull;
import com.toyproject.jobposting.dto.PostingDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Posting {

    @Id @GeneratedValue
    @Column(name = "posting_id")
    private Long id;


    private String title;

    private LocalDateTime annoStaDate; // posting announcement start date
    private LocalDateTime annoEndDate; // posting announcement end date

    private String desc;


    @Enumerated(EnumType.STRING)
    private PostStatus postStatus;

    @OneToMany(mappedBy = "posting", cascade = CascadeType.ALL)
    private List<Application> applications = new ArrayList<>();

    @OneToMany(mappedBy = "posting", cascade = CascadeType.ALL)
    private List<Question> questions = new ArrayList<>();

    public void addApplication(Application application){
        applications.add(application);
    }
    public void addQuestion(Question question){
        questions.add(question);
    }

    public void changeToPosting(PostingDto postingDto){
        this.title = postingDto.getTitle();
        this.annoStaDate = postingDto.getAnnoStaDate();
        this.annoEndDate = postingDto.getAnnoEndDate();
        this.desc = postingDto.getDesc();
        this.postStatus = postingDto.getPostStatus();
        this.applications = postingDto.getApplications();
        this.questions = postingDto.getQuestions();
    }
}
