package com.toyproject.jobposting.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
public class SchoolInfo {
    @Id @GeneratedValue
    @Column(name = "schoolinfo_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private SchoolStatus schoolStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="application_id")
    private Application application;

    private String orgName;
    private String schoolMajor; // only when school
    private LocalDateTime orgStaDate;
    private LocalDateTime orgEndDate;
    private String jobTask; // only when career

}
