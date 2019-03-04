package com.zlg.bs.user.service;

import com.zlg.bs.center.user.eo.UserEo;
import com.zlg.bs.center.user.vo.ResponseDto;

import java.util.List;

public interface UserService {

    //根据accountId查找用户
    public ResponseDto getUserById(int id);

    //根据user字段条件查找用户
    public ResponseDto getUser(UserEo userEo);

    //插入用户
    public UserEo insertUser(UserEo userEo);

    //更新用户
    public UserEo updateUser(UserEo userEo);

    //逻辑删除用户
    public String deleteUser(int id);
}
