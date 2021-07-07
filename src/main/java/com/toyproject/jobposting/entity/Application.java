package com.toyproject.jobposting.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Application {

    @Id @GeneratedValue
    @Column(name = "application_id")
    private Long id;

    @Column(name="user_id")
    private Long user_app_id;
    @Column(name="posting_id")
    private Long post_app_id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="user_id")
//    private User user;
//
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="posting_id")
//    private Posting posting;

    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL)
    private List<SchoolInfo> schoolInfos = new ArrayList<>();

    @OneToMany(mappedBy = "application",cascade = CascadeType.ALL)
    private List<QualifyInfo> qualifyInfos = new ArrayList<>();

    @OneToMany(mappedBy = "application",cascade = CascadeType.ALL)
    private List<IntroduceInfo> introduceInfos = new ArrayList<>();


    // 연관 관계 편의 메소드 //
//    public void setUser(User user) {
//        this.user = user;
//        if (!user.getApplications().isEmpty()) {
//            user.getApplications().add(this);
//        }
//    }
//
//    public void setPosting(Posting posting){
//        this.posting = posting;
//        if (!posting.getApplications().isEmpty()) {
//            posting.getApplications().add(this);
//        }
//
//    }


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
    public static Application createApplication(List<SchoolInfo> schoolInfo,
                                         List<QualifyInfo> qualifyInfo, List<IntroduceInfo> introduceInfo){
        Application application = new Application();

        for (SchoolInfo info : schoolInfo) {
            application.addSchoolInfo(info);
        }

        for (QualifyInfo info : qualifyInfo) {
            application.addQualifyInfo(info);
        }

        for (IntroduceInfo info : introduceInfo) {
            application.addIntroduceInfo(info);
        }
        return application;
    }

}
