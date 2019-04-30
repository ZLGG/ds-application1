package com.zlg.bs.mapper.user;

import com.zlg.bs.user.eo.UserEo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserImplMapper {
    @Select("SELECT FOUND_ROWS() as count;")
    Integer selectCount();

    @Select("select SQL_CALC_FOUND_ROWS * from mc_account where dr=0 and role != 0 and account_id!= #{id} limit #{page},#{limit}")
    List<UserEo> selectUserList(@Param("id") Long id, @Param("page") Integer page, @Param("limit") Integer limit);

    @Insert("insert into mc_account (account_id,password,role,userName,create_time) values(#{eo.accountId},#{eo.password},#{eo.role},#{eo.userName},now())")
    void insertAdmin(@Param("eo") UserEo UserEo);

    @Select("select * from mc_account where account_id =#{accountId}")
    UserEo selectAdminById(@Param("accountId") String accountId);

    @Select("select * from mc_account where dr=0 and role=0 limit #{page},#{limit}")
    List<UserEo> selectUser(@Param("page")Integer page,@Param("limit")Integer limit);

    @Update("update mc_account set dr = 1 and id =#{id}")
    void deleteAdmin(@Param("id") Integer id);

    @Select("select * from mc_account where dr=0 and email=#{eo.email}")
    UserEo selectFrontUser(@Param("eo") UserEo eo);

    @Insert("insert into mc_account (account_id,email,role,create_Time) values(#{eo.accountId},#{eo.email},0,now())")
    void addAccount(@Param("eo") UserEo eo);

    @Select("select * from mc_account where dr=0 and account_id=#{eo.accountId} and password=#{eo.password}")
    UserEo backLogin(@Param("eo") UserEo eo);
}
