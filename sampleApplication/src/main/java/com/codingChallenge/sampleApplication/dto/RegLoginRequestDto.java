package com.codingChallenge.sampleApplication.dto;

import lombok.Data;

@Data
public class RegLoginRequestDto {
    private String email;
    private String password;
    private String token;

}
