package com.toyproject.jobposting.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.toyproject.jobposting.dto.IntroduceInfoDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class IntroduceInfo {
    @Id @GeneratedValue
    @Column(name = "introduceinfo_id")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="application_id", nullable = false)
    private Application application;


    private String question; //
    private String answer;


    // 연관 관계 편의 메소드 //
//    public void setApplication(Application application) {
//        this.application = application;
//        application.getIntroduceInfos().add(this);
//    }
}
