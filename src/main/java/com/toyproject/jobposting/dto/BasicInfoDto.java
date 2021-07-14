package com.toyproject.jobposting.dto;

import lombok.Data;


@Data
public class BasicInfoDto {

    private Long id;
    private Long applicationId;
    private String name;
    private String address;
    private String englishName;
    private String phoneNumber;
    private String nation;
}
