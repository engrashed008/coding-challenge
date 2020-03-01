package com.codingChallenge.sampleApplication.controller;

import com.codingChallenge.sampleApplication.common.CommonPage;
import com.codingChallenge.sampleApplication.common.CommonResponse;
import com.codingChallenge.sampleApplication.dto.UserCreateRequestDto;
import com.codingChallenge.sampleApplication.dto.UserInfoDto;
import com.codingChallenge.sampleApplication.enums.ErrorStatus;
import com.codingChallenge.sampleApplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public CommonResponse<CommonPage<UserInfoDto>> userList(@RequestParam(defaultValue = "1") int page,
                                                            @RequestParam(defaultValue = "6") int limit) {
        List<UserInfoDto> userList = userService.getUserList(page, limit);
        return CommonResponse.success(CommonPage.restPage(userList));
    }

    @GetMapping("/users/{delay}")
    public CommonResponse<CommonPage<UserInfoDto>> userListDelayed(@RequestParam(defaultValue = "1") int page,
                                                                   @RequestParam(defaultValue = "6") int limit,
                                                                   @RequestParam int delay) {
        try {
            Thread.sleep(delay * 1000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        List<UserInfoDto> userList = userService.getUserList(page, limit);
        return CommonResponse.success(CommonPage.restPage(userList));
    }

    @GetMapping("/users/{id}")
    public CommonResponse<UserInfoDto> singleUser(@PathVariable @NotNull Long id) {
        UserInfoDto user = userService.getSingle(id);
        if (user == null) {
            return CommonResponse.failed(HttpStatus.NOT_FOUND, ErrorStatus.DATA_NOT_FOUND.getErrorMessage());
        }
        return CommonResponse.success(user);
    }

    @PostMapping("/users")
    public CommonResponse<UserInfoDto> createUser(@RequestBody @NotNull UserCreateRequestDto param) {
        UserInfoDto user = userService.create(param);
        return CommonResponse.success(user);
    }

    @PutMapping("/users/{id}")
    public CommonResponse<UserInfoDto> updateUser(@RequestBody @NotNull UserCreateRequestDto param,
                                                  @PathVariable @NotNull long id) {
        UserInfoDto user = userService.update(param, id);
        return CommonResponse.success(user);
    }

    @PatchMapping("/users/{id}")
    public CommonResponse<UserInfoDto> updateSingleUser(@RequestBody @NotNull UserCreateRequestDto param,
                                                        @PathVariable @NotNull long id) {
        UserInfoDto user = userService.update(param, id);
        return CommonResponse.success(user);
    }

    @DeleteMapping("/users/{id}")
    public CommonResponse deleteUser(@PathVariable @NotNull long id) {
        userService.delete(id);
        return CommonResponse.success(HttpStatus.NO_CONTENT);
    }
}
