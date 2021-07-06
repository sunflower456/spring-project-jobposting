package com.toyproject.jobposting.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Question {
    @Id @GeneratedValue
    @Column(name = "question_id")
    private Long id;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posting_id", nullable = false)
    private Posting posting;

    private String question;


    // 연관 관계 편의 메소드 //
//    public void setPosting(Posting posting) {
//        this.posting = posting;
//        posting.getQuestions().add(this);
//    }
}
