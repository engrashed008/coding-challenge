package com.codingChallenge.sampleApplication.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserInfoDto {
    private Long id;
    private String job;
    private String email;
    private String name;
    private String first_name;
    private String last_name;
    private String avatar;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
