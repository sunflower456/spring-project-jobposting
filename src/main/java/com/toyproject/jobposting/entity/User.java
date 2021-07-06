package com.toyproject.jobposting.entity;

import com.toyproject.jobposting.dto.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String identity; // id
    private String password;
    private String name;
    private String email;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
//    private List<Application> applications = new ArrayList<>();


    // 연관 관계 편의 메소드 //
//    public void addApplications(Application application){
//        applications.add(application);
//        application.setUser(this);
//    }

    public void changeToUser(UserDto userDto){
        this.identity = userDto.getIdentity();
        this.name = userDto.getName();
        this.email = userDto.getEmail();
        this.phoneNumber = userDto.getPhoneNumber();
        this.userStatus = userDto.getUserStatus();
    }
}
