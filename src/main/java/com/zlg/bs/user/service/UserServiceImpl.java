package com.zlg.bs.user.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zlg.bs.center.user.api.UserApi;
import com.zlg.bs.center.user.eo.UserEo;
import com.zlg.bs.center.user.vo.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    @Reference(version = "0.0.1",group = "zlg")
    UserApi userApi;


    public ResponseDto getUserById(int id) {
        ResponseDto<UserEo> responseDto = userApi.selectUserById(1);
        return responseDto;
    }

    public ResponseDto<List<UserEo>> getUser(UserEo userEo) {
        ResponseDto<List<UserEo>> listResponseDto = userApi.selectUser(userEo);
        return listResponseDto;
    }

    @Override
    public UserEo insertUser(UserEo userEo) {

        if (userEo != null) {
            userApi.insertUser(userEo);
            return null;
        }
        return null;
    }

    @Override
    public UserEo updateUser(UserEo userEo) {
        return null;
    }

    @Override
    public String deleteUser(int id) {
        return null;
    }

}
