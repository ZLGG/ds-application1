package com.zlg.bs.mapper.mall;

import com.zlg.bs.vo.Information;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface InformationMapper {
    @Select("SELECT FOUND_ROWS() as count;")
    Integer selectCount();

    @Insert("insert into information (img,data,text,infoCont) values(#{eo.img},#{eo.data},#{eo.text},#{eo.infoCont})")
    void addInformation(@Param("eo") Information Information);

    @Select("select SQL_CALC_FOUND_ROWS * from information where dr=0 limit #{page},#{limit};")
    List<Information> selectInformation(@Param("page") Integer page,@Param("limit") Integer limit);

    @Update("update information set dr=1 where id =#{id}")
    void deleteInformation(@Param("id") Integer id);

    @Insert("insert into address(userId,address) values(#{userId},#{address})")
    void setAddress(@Param("userId") Long userId, @Param("address") String address);
}
