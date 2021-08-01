package com.toyproject.jobposting.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Embeddable
@Getter @Setter
public class Question {
    private String question1;
    private String question2;
    private String question3;
    private String question4;
    private String question5;


}
