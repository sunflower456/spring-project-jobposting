package com.toyproject.jobposting.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
public class QualifyInfo {
    @Id @GeneratedValue
    @Column(name = "qualifyinfo_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="application_id")
    private Application application;

    private String qualiName;
    private String qualiNumber;
    private String qualiOrg;
    private LocalDateTime qualiStaDate;
    private LocalDateTime qualiEndDate; // nullable
}
