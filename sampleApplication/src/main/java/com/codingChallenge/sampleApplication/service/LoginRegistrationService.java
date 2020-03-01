package com.codingChallenge.sampleApplication.service;

import com.codingChallenge.sampleApplication.common.TokenGenerator;
import com.codingChallenge.sampleApplication.dto.LoginDto;
import com.codingChallenge.sampleApplication.dto.RegLoginRequestDto;
import com.codingChallenge.sampleApplication.dto.RegistrationDto;
import com.codingChallenge.sampleApplication.enums.ErrorStatus;
import com.codingChallenge.sampleApplication.exception.ServiceException;
import com.codingChallenge.sampleApplication.mapper.LoginRegistrationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginRegistrationService {

    private final LoginRegistrationMapper loginRegistrationMapper;

    @Transactional
    public RegistrationDto getRegistrationInfo(RegLoginRequestDto param) {
        String token = new TokenGenerator().generateToken(param.getEmail());
        param.setToken(token);
        //loginRegistrationMapper.register(param);
        //RegistrationDto registration = loginRegistrationMapper.findByEmail(param.getEmail());

        RegistrationDto registration = sampleRegistration(token);
        if (registration == null) {
            throw new ServiceException(ErrorStatus.DATA_NOT_FOUND);
        }
        return registration;
    }

    private RegistrationDto sampleRegistration(String token) {
        RegistrationDto reg = new RegistrationDto();
        reg.setId(4L);
        reg.setToken(token);
        return reg;
    }


    @Transactional
    public RegistrationDto getLogin(RegLoginRequestDto param) {
        String token = new TokenGenerator().generateToken(param.getEmail());
        param.setToken(token);
        //loginRegistrationMapper.login(param);
        //RegistrationDto registration = loginRegistrationMapper.findByEmail(param.getEmail());

        RegistrationDto registration = sampleRegistration(token);
        if (registration == null) {
            throw new ServiceException(ErrorStatus.DATA_NOT_FOUND);
        }
        return registration;
    }
}
