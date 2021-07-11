package com.toyproject.jobposting.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.Size;
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

    @Size(max=5000)
    private String desc;

    @Enumerated(EnumType.STRING)
    private JobKind jobkind;

    @Enumerated(EnumType.STRING)
    private PostStatus postStatus;

//    @OneToMany(mappedBy = "posting", cascade = CascadeType.ALL)
//    private List<Application> applications = new ArrayList<>();

    @OneToMany(mappedBy = "posting", cascade = CascadeType.ALL)
    private List<Question> questions = new ArrayList<>();

//    public void addApplication(Application application){
//        applications.add(application);
//    }
    public void addQuestion(Question question){
        questions.add(question);
    }

}
