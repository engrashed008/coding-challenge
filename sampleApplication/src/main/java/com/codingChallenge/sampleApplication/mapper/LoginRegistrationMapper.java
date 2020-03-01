package com.codingChallenge.sampleApplication.mapper;

import com.codingChallenge.sampleApplication.dto.RegLoginRequestDto;
import com.codingChallenge.sampleApplication.dto.RegistrationDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginRegistrationMapper {
    void register(RegLoginRequestDto param);

    RegistrationDto findByEmail(String email);
}
