package com.codingChallenge.sampleApplication.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomerDto {
    private Long id;
    private String name;
    private String job;
    private LocalDateTime created_at;
}
