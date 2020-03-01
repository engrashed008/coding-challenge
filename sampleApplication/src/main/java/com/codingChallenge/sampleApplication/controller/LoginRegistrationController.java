package com.codingChallenge.sampleApplication.controller;

import com.codingChallenge.sampleApplication.common.CommonResponse;
import com.codingChallenge.sampleApplication.dto.RegLoginRequestDto;
import com.codingChallenge.sampleApplication.dto.RegistrationDto;
import com.codingChallenge.sampleApplication.enums.ErrorStatus;
import com.codingChallenge.sampleApplication.service.LoginRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")

public class LoginRegistrationController {
    @Autowired
    LoginRegistrationService loginRegistrationService;

    @PostMapping("/register")
    public CommonResponse<RegistrationDto> register(@RequestBody RegLoginRequestDto param) {
        if (param.getPassword() == null) {
            return CommonResponse.failed(HttpStatus.BAD_REQUEST, ErrorStatus.PASSWORD_ERROR.getErrorMessage());
        }

        if (param.getEmail() == null) {
            return CommonResponse.failed(HttpStatus.BAD_REQUEST, ErrorStatus.PASSWORD_ERROR.getErrorMessage());
        }
        RegistrationDto reg = loginRegistrationService.getRegistrationInfo(param);
        return CommonResponse.success(reg);
    }

    @PostMapping("/login")
    public CommonResponse<RegistrationDto> login(@RequestBody RegLoginRequestDto param) {
        // Same code as Registration. UI will show appropriate result.
        if (param.getPassword() == null) {
            return CommonResponse.failed(HttpStatus.BAD_REQUEST, ErrorStatus.PASSWORD_ERROR.getErrorMessage());
        }

        if (param.getEmail() == null) {
            return CommonResponse.failed(HttpStatus.BAD_REQUEST, ErrorStatus.PASSWORD_ERROR.getErrorMessage());
        }
        RegistrationDto reg = loginRegistrationService.getLogin(param);
        return CommonResponse.success(reg);
    }
}
