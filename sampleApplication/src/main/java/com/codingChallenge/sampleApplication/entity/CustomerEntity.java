package com.codingChallenge.sampleApplication.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomerEntity {
    private Long id;
    private String name;
    private String job;
    private String address;
    private String city;
    private String post_code;
    private LocalDateTime dob;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
