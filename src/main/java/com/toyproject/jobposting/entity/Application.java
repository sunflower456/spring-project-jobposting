package com.toyproject.jobposting.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Application {

    @Id @GeneratedValue
    @Column(name = "application_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="posting_id")
    private Posting posting;

    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL)
    private List<SchoolInfo> schoolInfos = new ArrayList<>();

    @OneToMany(mappedBy = "application",cascade = CascadeType.ALL)
    private List<QualifyInfo> qualifyInfos = new ArrayList<>();

    @OneToMany(mappedBy = "application",cascade = CascadeType.ALL)
    private List<IntroduceInfo> introduceInfos = new ArrayList<>();


    // 연관 관계 편의 메소드 //
    public void setUser(User user) {
        this.user = user;
        user.getApplications().add(this);
    }


    // add method //
    public void addSchoolInfo(SchoolInfo schoolInfo) {
        schoolInfos.add(schoolInfo);
    }

    public void addQualifyInfo(QualifyInfo qualifyInfo){
        qualifyInfos.add(qualifyInfo);
    }

    public void addIntroduceInfo(IntroduceInfo introduceInfo){
        introduceInfos.add(introduceInfo);
    }


    // 생성 메소드 //
    public Application createApplication(User user, SchoolInfo schoolInfo, QualifyInfo qualifyInfo, IntroduceInfo introduceInfo){
        Application application = new Application();

        application.setUser(user);
        application.addSchoolInfo(schoolInfo);
        application.addIntroduceInfo(introduceInfo);
        application.addQualifyInfo(qualifyInfo);

        return application;
    }
}
