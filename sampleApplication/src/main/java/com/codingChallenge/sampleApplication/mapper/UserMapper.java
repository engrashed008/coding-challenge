package com.codingChallenge.sampleApplication.mapper;

import com.codingChallenge.sampleApplication.dto.UserCreateRequestDto;
import com.codingChallenge.sampleApplication.dto.UserInfoDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserInfoDto> getList();

    UserInfoDto getSingleUser(long id);

    void createUser(UserInfoDto usr);

    int updateUser(UserInfoDto usr);

    int deleteUser(long id);

    UserInfoDto fetchByNameAndJob(String firstName, String lastName, String job);
}
