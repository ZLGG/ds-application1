package com.zlg.bs.user.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zlg.bs.center.user.api.UserApi;
import com.zlg.bs.center.user.eo.UserEo;
import com.zlg.bs.user.util.MailUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    @Reference(version = "0.0.1",group = "zlg")
    UserApi userApi;


    public String getUserById(int id) {
        UserEo userEo = userApi.selectUserById(1);
        return userEo.toString();
    }

    public String getUser(UserEo userEo) {
        userEo.setMobile("17633901170");
        List<UserEo> userEos = userApi.selectUser(userEo);
        return userEos.toString();
    }

    @Override
    public void insertUser(UserEo userEo) {
        UUID uuid = UUID.randomUUID();
        String s = String.valueOf(uuid);

    }

    @Override
    public void updateUser(UserEo userEo) {

    }

    @Override
    public void deleteUser(int id) {

    }

}
