package com.codingChallenge.sampleApplication.service;

import com.codingChallenge.sampleApplication.common.Const;
import com.codingChallenge.sampleApplication.dto.UserCreateRequestDto;
import com.codingChallenge.sampleApplication.dto.UserInfoDto;
import com.codingChallenge.sampleApplication.enums.ErrorStatus;
import com.codingChallenge.sampleApplication.exception.ServiceException;
import com.codingChallenge.sampleApplication.mapper.UserMapper;
import com.github.pagehelper.Constant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    /**
     * @param page
     * @param limit
     * @return
     */
    public List<UserInfoDto> getUserList(int page, int limit) {
        PageHelper.startPage(page, limit);
        // Following Mapper call fetch the usr list from DB
        //List<UserInfoDto> userList = userMapper.getList();
        // Sample output
        List<UserInfoDto> userList = getUserSampleList();
        if (userList.size() == 0) {
            throw new ServiceException(ErrorStatus.DATA_NOT_FOUND);
        }
        return userList;
    }

    private List<UserInfoDto> getUserSampleList() {
        List<UserInfoDto> list = new ArrayList<>();
        UserInfoDto usr1 = new UserInfoDto();
        usr1.setId(7L);
        usr1.setEmail("michael.lawson@reqres.in");
        usr1.setFirst_name("Michael");
        usr1.setLast_name("Lawson");
        usr1.setAvatar("https://s3.amazonaws.com/uifaces/faces/twitter/follettkyle/128.jpg");
        list.add(usr1);

        UserInfoDto usr2 = new UserInfoDto();
        usr2.setId(8L);
        usr2.setEmail("lindsay.ferguson@reqres.in");
        usr2.setFirst_name("Lindsay");
        usr2.setLast_name("Ferguson");
        usr2.setAvatar("https://s3.amazonaws.com/uifaces/faces/twitter/araa3185/128.jpg");
        list.add(usr2);

        UserInfoDto usr3 = new UserInfoDto();
        usr3.setId(9L);
        usr3.setEmail("tobias.funke@reqres.in");
        usr3.setFirst_name("Tobias");
        usr3.setLast_name("Funke");
        usr3.setAvatar("https://s3.amazonaws.com/uifaces/faces/twitter/vivekprvr/128.jpg");
        list.add(usr3);

        UserInfoDto usr4 = new UserInfoDto();
        usr4.setId(10L);
        usr4.setEmail("byron.fields@reqres.in");
        usr4.setFirst_name("Byron");
        usr4.setLast_name("Fields");
        usr4.setAvatar("https://s3.amazonaws.com/uifaces/faces/twitter/russoedu/128.jpg");
        list.add(usr4);

        UserInfoDto usr5 = new UserInfoDto();
        usr5.setId(11L);
        usr5.setEmail("byron.fields@reqres.in");
        usr5.setFirst_name("Byron");
        usr5.setLast_name("Fields");
        usr5.setAvatar("https://s3.amazonaws.com/uifaces/faces/twitter/russoedu/128.jpg");
        list.add(usr5);

        UserInfoDto usr6 = new UserInfoDto();
        usr6.setId(12L);
        usr6.setEmail("rachel.howell@reqres.in");
        usr6.setFirst_name("Rachel");
        usr6.setLast_name("Howell");
        usr6.setAvatar("https://s3.amazonaws.com/uifaces/faces/twitter/hebertialmeida/128.jpg");
        list.add(usr6);

        UserInfoDto usr7 = new UserInfoDto();
        usr7.setId(13L);
        usr7.setEmail("test.howell@reqres.in");
        usr7.setFirst_name("test");
        usr7.setLast_name("Howell");
        usr7.setAvatar("https://s3.amazonaws.com/uifaces/faces/twitter/hebertialmeida/128.jpg");
        list.add(usr7);

        return list;
    }

    /**
     * @param id
     * @return
     */
    public UserInfoDto getSingle(long id) {
        // Following Mapper call fetch the usr list from DB
        //List<UserInfoDto> userList = userMapper.getSingleUser(long id);
        // Sample output
        UserInfoDto singleUsr = singleUser(id);
        return singleUsr;
    }

    private UserInfoDto singleUser(Long id) {
        UserInfoDto usr = new UserInfoDto();
        usr.setId(id);
        usr.setEmail("janet.weaver@reqres.in");
        usr.setFirst_name("Janet");
        usr.setLast_name("Weaver");
        usr.setAvatar("https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg");
        return usr;
    }

    /**
     *
     * @param param
     * @return
     */
    @Transactional
    public UserInfoDto create(UserCreateRequestDto param) {
        String[] name = StringUtils.split(param.getName(), Const.SPACE);
        // The following code should be modified based on spec.
        UserInfoDto usr = new UserInfoDto();
        if(name == null){
            usr.setFirst_name(param.getName());
            usr.setLast_name(null);
        } else {
            usr.setFirst_name(name[0]);
            usr.setLast_name(name.length > 1 ? name[1] : null);
        }
        usr.setJob(param.getJob());
        usr.setCreatedAt(LocalDateTime.now());

        // Follwing code will update user with given Id
        //userMapper.createUser(usr);
        //UserInfoDto createdUsr = userMapper.fetchByNameAndJob(usr.getFirst_name(),  usr.getLast_name(), usr.getJob());

        // Sample code for output. UI only display necessary information
        UserInfoDto createdUsr = newCreatedSampleUser();
        if (createdUsr == null) {
            throw new ServiceException(ErrorStatus.USER_CREATE_ERROR);
        }
        return createdUsr;
    }

    private UserInfoDto newCreatedSampleUser() {
        UserInfoDto newUsr = new UserInfoDto();
        newUsr.setId(308L);
        newUsr.setName("morpheus");
        newUsr.setJob("leader");
        newUsr.setCreatedAt(LocalDateTime.parse("2020-03-01 06:05:13", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return newUsr;
    }


    /**
     *
     * @param param
     * @return
     */
    @Transactional
    public UserInfoDto update(UserCreateRequestDto param, long id) {
        String[] name = StringUtils.split(param.getName(), Const.SPACE);
        // The following code should be modified based on spec.
        UserInfoDto usr = new UserInfoDto();
        usr.setId(id);
        if(name == null){
            usr.setFirst_name(param.getName());
            usr.setLast_name(null);
        } else {
            usr.setFirst_name(name[0]);
            usr.setLast_name(name.length > 1 ? name[1] : null);
        }
        usr.setJob(param.getJob());
        usr.setCreatedAt(LocalDateTime.now());

        // Follwing code will insert user and retrieve newly inserted user
        // userMapper.updateUser(param);
        // UserInfoDto createdUsr = userMapper.fetchByNameAndJob(String usr.getFirst_name(), String getLast_name(), String usr.getJob());

        // Sample code for output. UI only display necessary information
        UserInfoDto updateUsr = updateSampleUser();
        if (updateUsr == null) {
            throw new ServiceException(ErrorStatus.USER_UPDATE_ERROR);
        }
        return updateUsr;
    }

    private UserInfoDto updateSampleUser() {
        UserInfoDto updateUsr = new UserInfoDto();
        updateUsr.setName("morpheus");
        updateUsr.setJob("zion resident");
        updateUsr.setUpdatedAt(LocalDateTime.parse("2020-03-01 06:05:13", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return updateUsr;
    }

    @Transactional
    public void delete(long id){
        int count=0;
        // count = userMapper.deleteUser(id);
        if(count == 0){
            throw new ServiceException(ErrorStatus.USER_DELETE_ERROR);
        }
    }

}
