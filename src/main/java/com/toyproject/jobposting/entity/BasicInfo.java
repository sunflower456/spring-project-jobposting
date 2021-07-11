package com.toyproject.jobposting.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class BasicInfo {
    @Id
    @GeneratedValue
    @Column(name = "basicinfo_id")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="application_id", nullable = false)
    private Application application;

    private String name;
    private String address;
    private String englishName;
    private String phoneNumber;
    private String nation;

}
