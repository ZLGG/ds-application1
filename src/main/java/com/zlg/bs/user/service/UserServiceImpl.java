package com.zlg.bs.user.service;

import com.zlg.bs.mapper.user.UserImplMapper;
import com.zlg.bs.user.eo.UserEo;
import com.zlg.bs.vo.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl {
    @Resource
    UserImplMapper UserMapper;

    public Result selectUserList(Long id,Integer page,Integer limit) {
        page = (page - 1) * limit;
        List<UserEo> userEos = UserMapper.selectUserList(id, page, limit);
        Integer count = UserMapper.selectCount();
        return new Result(0, "", userEos, count);
    }

    public void insertAdmin(UserEo UserEo) {
        UserMapper.insertAdmin(UserEo);
    }

    public UserEo selectAdminById(String accountId) {
        UserEo userEo = UserMapper.selectAdminById(accountId);
        return userEo;
    }

    public  Result selectUser(Integer page, Integer limit) {
        page = (page - 1) * 10;
        List<UserEo> userEos = UserMapper.selectUser(page, limit);
        Integer count = UserMapper.selectCount();
        return new Result(0, "", userEos, count);
    }

    public void deleteAdmin(Integer id) {
        UserMapper.deleteAdmin(id);
    }

}
