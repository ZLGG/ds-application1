package com.zlg.bs.user.service;

import com.zlg.bs.center.user.eo.UserEo;

public interface UserService {

    //根据accountId查找用户
    public String getUserById(int id);

    //根据user字段条件查找用户
    public String getUser(UserEo userEo);

    //插入用户
    public void insertUser(UserEo userEo);

    //更新用户
    public void updateUser(UserEo userEo);

    //逻辑删除用户
    public void deleteUser(int id);
}
